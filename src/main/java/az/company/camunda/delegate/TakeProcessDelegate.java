package az.company.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class TakeProcessDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int id = (int) delegateExecution.getVariable("id");
        String name = (String) delegateExecution.getVariable("name");

        System.out.println(id);
        System.out.println(name);

        delegateExecution.setVariable("id", id + "...Success...");
        delegateExecution.setVariable("name", name + "...Success...");

    }
}
