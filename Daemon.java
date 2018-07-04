import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import controlador.PagoController;

public class Daemon extends Thread{
	
	public String horario;
	
	public static void main(String[] args){
		Daemon daemon = new Daemon();
		daemon.start();
	}
	
	public void run(){
		while(true){
			/*Pagos*/
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat d = new SimpleDateFormat("HH:mm:ss"); 
			Date now = calendar.getTime();
			calendar.add(Calendar.MINUTE, 10);
			Date next = calendar.getTime();
			this.horario = d.format(now);
			if (d.format(now).equalsIgnoreCase(horario)){
				try {
					readPago();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				horario = d.format(next); 
			}	
		}
	}
	
	/*El archivo tiene que estar en formato csv.
	 *Valores: nombre de la lista, nombre del usuario, monto y fecha de movimiento*/
	public void readPago () throws IOException{
		String fileNamePago = "In/pago.csv";
		String fileNameLog = "log.txt";
		String fileNameCopia = "Out/pagoCopia.csv";
		File pago = new File(fileNamePago);
		File log = new File(fileNameLog);
		File pagoCopia = new File(fileNameCopia);
		try{
			Scanner inputStream = new Scanner(pago);
			while(inputStream.hasNext()){
				String data = inputStream.next();
				String[] valores = data.split(",");
				//System.out.println(data);
				procesarPagos(valores); 
				FileWriter fw = new FileWriter (log, true);
				PrintWriter pw = new PrintWriter(fw);
				pw.println("Nombre de lista: " + valores[0] + " - Nombre de participante: " + valores[1] + " - Monto: " + valores[2] + " - Fecha de movimiento: " + valores[3]);
				pw.close();
			}
			inputStream.close();
			Files.copy(pago.toPath(), pagoCopia.toPath());
			pago.delete();
		} catch (FileNotFoundException e){
			System.out.println("No se encontraron archivos de pagos");
		}
	}

	public static boolean procesarPagos (String[] pago){
		if (pago.length == 4){
			try {
				String nombreLista = String.valueOf(pago[0]);
				String nombreUsuario = String.valueOf(pago[1]);
				float monto = Float.valueOf(pago[2]);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date fecha = (java.util.Date) formatter.parse(pago[3]);
				PagoController.getInstancia().NotificarPago(nombreLista, nombreUsuario, fecha, monto);
			} catch (ParseException e) {
				System.out.println("Error en los datos del archivo");
				e.printStackTrace();
			}
		} else
			System.out.println("Error en la cantidad de columnas informada en el archivo");
			return false;
	}

}
