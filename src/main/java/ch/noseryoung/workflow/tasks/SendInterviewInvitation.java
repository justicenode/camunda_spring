package ch.noseryoung.workflow.tasks;

import ch.noseryoung.workflow.service.mail.MailMessage;
import ch.noseryoung.workflow.service.mail.MailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;

@Component
public class SendInterviewInvitation implements JavaDelegate {
    private final MailService mailService;

    @Autowired
    SendInterviewInvitation(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String firstName = (String) delegateExecution.getVariable("Firstname");
        String lastName = (String) delegateExecution.getVariable("Lastname");
        String comment = (String) delegateExecution.getVariable("comment");

        System.out.println("Interview invitation sent to " + delegateExecution.getVariable("Firstname") + " " + delegateExecution.getVariable("Lastname")+ "<"  + delegateExecution.getVariable("email") + ">");

        MailMessage msg = new MailMessage();
        msg.subject = "Interview invitation";
        msg.to = new InternetAddress[]{
                new InternetAddress((String) delegateExecution.getVariable("email"))
        };
        msg.content = "Dear " + firstName + " " + lastName + "\n" +
                "Were happy to inform you that youre invited for a interview\n\n" + comment;

        mailService.sendMail(msg);
    }
}
