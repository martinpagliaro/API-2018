package otros;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//public class EmailSender{ public static void main(String args[]) { 
public class EmailSender {
	
	static String remitente = "NombreUsuarioDelRemitente";  //Para la dirección nomcuenta@gmail.com
  static String clave = "ClaveDelMailAUtilizar";
    
	public static void buildMails (StringBuilder emails, String asunto, String cuerpo){
		
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", emails);
	    props.put("mail.smtp.clave", "ClaveDelMailAUtilizar");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
	
	    
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	
	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, emails.toString());   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, clave);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
    
	}
	
}
