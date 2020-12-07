package az.company.camunda.logging;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {

    private static final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        LOGGER.info("\n\n  ... LoggerDelegate invoked by "
                + " , processDefinitionId=" + delegateExecution.getProcessDefinitionId()
                + " , activityName" + delegateExecution.getCurrentActivityId()
                + " , processInstanceId" + delegateExecution.getCurrentActivityName()
                + " , businessKey" + delegateExecution.getBusinessKey()
                + " , executionId" + delegateExecution.getId()
                + "\n\n");
    }
}
