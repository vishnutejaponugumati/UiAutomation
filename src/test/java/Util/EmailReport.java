package Util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailReport {

	
	/**
	 * Send email using java
	 * 
	 * @param from
	 * @param pass
	 * @param to
	 * @param subject
	 * @param ccList
	 * @param host
	 * @param port
	 * @param body
	 */
	
		 
	public static void sendMail(){

		String body1 = "PFA Test Results";
		String host = "smtp-mail.outlook.com";// change accordingly
        @SuppressWarnings("unused")
        String mailStoreType = "pop3";
        String username = "nbogolu@altimetrik.com";
        String password = "Newyear@@24";
        
		Properties props = new Properties();
        props.put("mail.store.protocol", "pop3");
        props.put("mail.pop3.host", host);
        props.put("mail.pop3.port", "995");
        props.put("mail.pop3.starttls.enable","true");
        props.put("mail.pop3.user", "nbogolu@altimetrik.com");
        props.put("mail.pop3.password", "Newyear@@24");
        /*
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", "visatestautomation3@gmail.com");
		props.put("mail.smtp.password", "e_P7Yg.zaXGgzxq");
		props.put("mail.smtp.port", "587");
		//props.put("mail.smtp.auth", "true");
*/
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			// Set from address
			message.setFrom(new InternetAddress("nbogolu@altimetrik.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("nbogolu@altimetrik.com"));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress("nbogolu@altimetrik.com"));

			// Set subject
			message.setSubject("Here is the Test Rsults");
			message.setText(body1);
			message.setText(body1);
			 //3) create MimeBodyPart object and set your message text     
		    BodyPart messageBodyPart1 = new MimeBodyPart();  
		    messageBodyPart1.setText("This is message body");  
		      
		    //4) create new MimeBodyPart object and set DataHandler object to this object      
		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		  
		    String filename = System.getProperty("user.dir") +"\\test-output\\emailable-report.html";
		    		//"test-output\\emailable-report.html";//change accordingly  
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  
		     //5) create Multipart object and add MimeBodyPart objects to this object      
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2); 
		    message.setContent(multipart);
	        System.out.println("Sending");
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp-mail.outlook.com", "nbogolu@altimetrik.com", "Newyear@@24");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
}
	public static void main(String[] args) {
		//EmailReport er = new EmailReport();
		EmailReport.sendMail();
	}
}
