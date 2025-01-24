
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtil {

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;

    public static void sendEmail(String toEmail, String subject, String messageBody) throws MessagingException {
        // Email credentials
        final String username = "shivuroopesh6362@gmail.com";
        final String password = "gcxy tgoh qtbn zfea";

        // SMTP properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        // Create a session with the SMTP server
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Create the email message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);
        message.setText(messageBody);

        // Send the email
        Transport.send(message);
        System.out.println("Email sent successfully to " + toEmail);
    }
    
    
    public static void main(String[] args) {
    	 String toEmail = "shivuroopesh6362@gmail.com"; // Replace with recipient email
         String subject = "Test Email from J2EE Project";
         String body = "Hi Dear.\nYour OTP for Signup is "+OTPGenerator.generateRandomString(6);

         try {
             EmailUtil.sendEmail(toEmail, subject, body);
             System.out.println("Email sent successfully!");
         } catch (MessagingException e) {
             e.printStackTrace();
             System.out.println("Failed to send email.");
         }
	}
}

