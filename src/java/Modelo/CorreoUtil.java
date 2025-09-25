package modelo;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class CorreoUtil {

    // CREDENCIALES HARDCODED (quemadas en el código) - solo para pruebas locales
    private static final String USER = "mikesuarez93049@gmail.com";
    private static final String PASS = "shoe hqii kfqh isec"; // <-- aquí tienes la contraseña hardcodeada

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";

    public static void enviarCodigo(String destino, String codigo) {

        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        // Requerir STARTTLS y confiar en el host
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.trust", SMTP_HOST);

        // timeouts opcionales
        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASS);
            }
        });

        // Desactiva el debug en producción; útil para ver la negociación SMTP en pruebas
        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            message.setSubject("Código de verificación");
            message.setText("Tu código de verificación es: " + codigo);

            Transport.send(message);
            System.out.println("Correo enviado a " + destino);

        } catch (MessagingException e) {
            System.err.println("Error al enviar correo:");
            e.printStackTrace();
        }
    }
}
