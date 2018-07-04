package controlador;

import java.util.ArrayList;

import modelo.Lista;
import modelo.Participante;
import otros.EmailSender;

public class EmailController {
	
	public void inicioDeLista(String nombreLista) {
		Lista l = ListaController.getInstancia().buscarLista(nombreLista);
		String asunto = "Regalo de cumple para " + l.getNombreAgasajado();
		String cuerpo = "Vamos a juntar " + l.getMontoTotal() + " pesos para " + l.getNombreAgasajado();
		ArrayList <Participante> participantes = l.getParticipantes();
		StringBuilder emails = getParticipantesEmails(participantes);
		EmailSender.buildMails(emails, asunto, cuerpo);
	}
	
	public void proximoCierre(String nombreLista){
		Lista l = ListaController.getInstancia().buscarLista(nombreLista);
		String asunto = "Regalo de cumple para " + l.getNombreAgasajado();
		String cuerpo = "Vamos a juntar " + l.getMontoTotal() + " pesos para " + l.getNombreAgasajado();
		ArrayList <Participante> participantes = l.getParticipantes();
		StringBuilder emails = getParticipantesEmails(participantes);
		EmailSender.buildMails(emails, asunto, cuerpo);
	}
	
	public void avisoDeCierre(){
	
	}
	
	@SuppressWarnings("null")
	public StringBuilder getParticipantesEmails (ArrayList<Participante> ListaParcip){
		
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