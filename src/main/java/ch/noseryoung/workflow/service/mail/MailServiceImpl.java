package ch.noseryoung.workflow.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService{
    private final MailProperties mailProps;

    @Autowired
    public MailServiceImpl(MailProperties mailProps) {
        this.mailProps = mailProps;
    }

    @Override
    public void sendMail(MailMessage msg) throws AddressException, MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", mailProps.isAuth());
        props.put("mail.smtp.starttls.enable", mailProps.isStarttls());
        props.put("mail.smtp.host", mailProps.getSmtpHost());
        props.put("mail.smtp.port", mailProps.getSmtpPort());

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailProps.getUser(), mailProps.getPassword());
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(mailProps.getDisplayName(), false));

        message.setRecipients(Message.RecipientType.TO, msg.to);
        message.setRecipients(Message.RecipientType.CC, msg.cc);
        message.setRecipients(Message.RecipientType.BCC, msg.bcc);
        message.setSubject(msg.subject);
        message.setContent(msg.content, msg.contentType);
        message.setSentDate(new Date());

//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent("Tutorials point email", "text/html");
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//        MimeBodyPart attachPart = new MimeBodyPart();
//
//        attachPart.attachFile("/var/tmp/image19.png");
//        multipart.addBodyPart(attachPart);
//
//        message.setContent(multipart);
        Transport.send(message);
    }
}
