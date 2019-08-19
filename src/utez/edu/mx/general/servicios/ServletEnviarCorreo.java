package utez.edu.mx.general.servicios;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "ServletEnviarCorreo")
public class ServletEnviarCorreo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Username = "20183ti004@utez.edu.mx";
        String PassWord = "20183ti004";
        String To = request.getParameter("Correo");
        String Subject = "Recuperacion de Contraseña";
        String Mensage = "Link para recuperar contraseña: \n ";


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(Username, PassWord);
            }
            });

        System.out.println("vas bien :v");
            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(Username));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(To));
                message.setSubject(Subject);
                message.setText(Mensage);

                Transport.send(message);
                System.out.println("Listo!!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
