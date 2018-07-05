package otros;

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

import controlador.EmailController;
import controlador.PagoController;

public class Daemon extends Thread{
	
	public String horarioPago;
	public String horarioMail;
	private int i = 0;
	private int vencimiento = 5; // 
	
	public static void main(String[] args){
		Daemon daemon = new Daemon();
		daemon.start();
	}
	
	public void run(){
		while(true){
			/*Pagos*/
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dPago = new SimpleDateFormat("HH:mm:ss"); 
			Date nowPago = calendar.getTime();
			calendar.add(Calendar.MINUTE, 10);
			Date next = calendar.getTime();
			this.horarioPago = dPago.format(nowPago);
			/*Mails*/
			Calendar calendar2 = (Calendar) calendar.clone();
			SimpleDateFormat dMail = new SimpleDateFormat("dd/MM/yyyy");
			Date nowMail = calendar2.getTime();
			calendar2.add(Calendar.DAY_OF_YEAR, 1);
			Date nextDay =  calendar2.getTime();
			
			/*Procesamiento de pagos*/
			if (dPago.format(nowPago).equals(horarioPago)){
				try {
					readPago();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				horarioPago = dPago.format(next); 
			}
			/*Envio de mails*/
			if (dMail.format(nowMail).equals(horarioMail)){
				avisoDeRegalo();
				proximoCierre();	
			}
			horarioMail = dMail.format(nextDay);
		}
	}
	
	/*El archivo tiene que estar en formato csv.
	 *Valores: nombre de la lista, nombre del usuario, monto y fecha de movimiento*/
	public void readPago () throws IOException{
		String fileNamePago = "In/pago.csv";
		String fileNameLog = "log.txt";
		String fileNameCopia = "Out/pagoCopia"+i+".csv";
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
				/*Si el archivo de log no existe lo crea*/
				FileWriter fw = new FileWriter (log, true);
				PrintWriter pw = new PrintWriter(fw);
				pw.println("Nombre de lista: " + valores[0] + " - Nombre de participante: " + valores[1] + " - Monto: " + valores[2] + " - Fecha de movimiento: " + valores[3]);
				pw.close();
			}
			inputStream.close();
			/*Copia el archivo en la carpeta de destino con un nuevo nombre*/
			Files.copy(pago.toPath(), pagoCopia.toPath());
			i++;
			pago.delete();
		} catch (FileNotFoundException e){
			System.out.println("No se encontraron archivos de pagos");
		}
	}
	
	/*Se crea el pago y se actualiza el estado de pago y el monto pagado del participante*/
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
	
	public void avisoDeRegalo(Date nowMail){
		EmailController.getInstancia().avisoDeCierre(nowMail);
	}
	
	public void proximoCierre(Date nowMail){
		EmailController.getInstancia().proximoCierre(nowMail);
		
	}

}
