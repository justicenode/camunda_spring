package ch.noseryoung.workflow.tasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendContract implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        System.out.println("Interview invitation sent to "  + delegateExecution.getVariable("Firstname") + " with the reason: " + delegateExecution.getVariable("reason"));
    }
}
