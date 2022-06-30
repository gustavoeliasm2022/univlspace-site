package space.univl.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	private static final String SERVLET = "http://localhost:8080/Consultor-Plataformas-Digitales-01/activar";

	public void sendMail(String nombreCompleto, String email) {
		
		/**
		 * hotmail
		 */
//		String from = "gustavoeliasm@hotmail.com";
//		final String username = "gustavoeliasm@hotmail.com";
//		final String password = "010521APM";
//		String host = "smtp.office365.com";
//		Properties props = new Propertie	s();
//		props.put("mail.smtp.ssl.trust",  "smtp.office365.com");
//		props.put("mail.smtp.auth",  "true");
//		props.put("mail.smtp.starttls.enable", "true");
////		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.port", "587");
//		
		/**
		 * gmail
		 */
		String from = "gustavoeliasm@gmail.com";
		final String username = "gustavoeliasm@gmail.com";
		final String password = "zkhlmceljvhwavin";
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth",  "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		
		
		/**
		 * Login a nuestra cuenta
		 */
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			// adonde se envia el mensaje
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Activacion de tu cuenta");
			message.setContent("Bienvenido "+ nombreCompleto+ " a tu plataforma digital, para activar tu cuenta da click en el siguiente link"+"<a href=\""+ SERVLET + "?email="+ email +"\">Activar mi Cuenta</a>","text/html");
			Transport.send(message);
			System.out.println("Email de confirmacion enviado de forma Exitosa "+email);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
