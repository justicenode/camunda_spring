package ch.noseryoung.workflow.service.mail;

import javax.mail.MessagingException;

public interface MailService {
    public void sendMail(MailMessage msg) throws MessagingException;
}
