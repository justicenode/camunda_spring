package ch.noseryoung.workflow.tasks;

import ch.noseryoung.workflow.service.mail.MailMessage;
import ch.noseryoung.workflow.service.mail.MailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;

@Component
public class SendDeclinationLetter implements JavaDelegate {
    private final MailService mailService;

    @Autowired
    public SendDeclinationLetter(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String firstName = (String) delegateExecution.getVariable("Firstname");
        String lastName = (String) delegateExecution.getVariable("Lastname");
        String reason = (String) delegateExecution.getVariable("reason");

        System.out.println("Declination letter sent to " + firstName + " with the reason: " + reason);


        MailMessage msg = new MailMessage();
        msg.subject = "Application declined";
        msg.to = new InternetAddress[]{
                new InternetAddress((String) delegateExecution.getVariable("email"))
        };
        msg.content = "Dear " + firstName + " " + lastName + "\n" +
                "Were sorry to inform you that your application has been declined\n\n" + reason;

        mailService.sendMail(msg);
    }
}
