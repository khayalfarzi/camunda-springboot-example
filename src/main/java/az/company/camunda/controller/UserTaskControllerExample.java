package az.company.camunda.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ActivityInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserTaskControllerExample {

    private static final String PROCESS_DEFINITION_KEY = "test_rest";

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    private ProcessEngine processEngine;
    //    @Autowired
    private ProcessInstance processInstance;
    private ActivityInstance activityInstance;

    @GetMapping("/start")
    public ResponseEntity<?> startBPMNProcess() {
        System.out.println("======================= Start Process started ===================================");
        runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
        System.out.println("======================= Start Process ended ===================================");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/complete")
    public ResponseEntity<?> callUserTask() {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("demo").list();

        String id = null;
        System.out.println("start olunmus task " + tasks.toString());

        for (Task t : tasks) {
            System.out.println("======================= Complete Process started ===================================");
            System.out.println(t);
            System.out.println("======================= Complete Process ended ===================================");

            System.out.println(t.getAssignee() + " " +
                    t.getCaseDefinitionId() + " " +
                    t.getCaseExecutionId() + " " +
                    t.getCaseInstanceId() + " " +
                    t.getId() + " " +
                    t.getName() + " " +
                    t.getPriority());
            id = t.getId();
        }

        taskService.setVariable(id, "key", "yes");
        taskService.complete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}