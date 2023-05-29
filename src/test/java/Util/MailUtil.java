package Util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class MailUtil {
public static void main(String[] args) {
    final String username = "nbogolu@altimetrik.com";  // like yourname@outlook.com
    final String password = "Newyear@@24";   // password here

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp-mail.outlook.com");
    props.put("mail.smtp.port", "587");
    
    Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
      });
    session.setDebug(true);

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("nbogolu@altimetrik.com"));   // like inzi769@gmail.com
        message.setSubject("Test");
        message.setText("HI you have done sending mail with outlook");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
}
}