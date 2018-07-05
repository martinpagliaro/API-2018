package controlador;

import java.util.ArrayList;

import modelo.Lista;
import modelo.Participante;
import otros.EmailSender;
//import otros.EmailSender;

public class EmailController {
	
	private static EmailController instancia;
	
	static public EmailController getInstancia() {
		if(EmailController.instancia == null) {
			EmailController.instancia = new EmailController();
		}
		return EmailController.instancia;
	}
	
	public static void inicioDeLista(String nombreLista) {
		Lista l = ListaController.getInstancia().buscarLista(nombreLista);
		String asunto = "Regalo de cumple para " + l.getNombreAgasajado();
		String cuerpo = "Vamos a juntar " + l.getMontoTotal() + " pesos para " + l.getNombreAgasajado();
		ArrayList <Participante> participantes = l.getParticipantes();
		StringBuilder emails = getParticipantesEmails(participantes);
		EmailSender.buildMails(emails, asunto, cuerpo);
	}
	
	/*Corregir*/
	public void proximoCierre(String nombreLista){
		Lista l = ListaController.getInstancia().buscarLista(nombreLista);
		String asunto = "Regalo de cumple para " + l.getNombreAgasajado();
		String cuerpo = "La lista " + l.getNombreLista() + " esta proxima a vencer. Quedan 5 dias para realiar el pago";
		ArrayList <Participante> participantes = l.getParticipantes();
		StringBuilder emails = getParticipantesEmails(participantes);
		EmailSender.buildMails(emails, asunto, cuerpo);
	}
	
	/*Hacer*/
	public void avisoDeCierre(){
		
	}
	
	@SuppressWarnings("null")
	public static StringBuilder getParticipantesEmails (ArrayList<Participante> ListaParcip){
		
		StringBuilder emails = null;
		for (Participante participante : ListaParcip){
			emails.append(participante.getMail());
			emails.append(";");
		}
		return emails;
		
		//System.out.println(emails);
		//buildMails(emails, asunto, cuerpo);
		
	}

}
