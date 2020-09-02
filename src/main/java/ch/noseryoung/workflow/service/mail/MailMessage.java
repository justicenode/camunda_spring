package ch.noseryoung.workflow.service.mail;

import javax.mail.internet.InternetAddress;

public class MailMessage {
    public String subject = "";
    public InternetAddress[] to = new InternetAddress[0];
    public InternetAddress[] cc = new InternetAddress[0];
    public InternetAddress[] bcc = new InternetAddress[0];
    public String content = "";
    public String contentType= "text/html";
}
