package ch.noseryoung.workflow.tasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SendContract implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("SendContract");

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        LOGGER.log(Level.INFO, "Contract sent to " + delegateExecution.getVariable("Firstname") + " with the reason: " + delegateExecution.getVariable("reason"));
    }
}
