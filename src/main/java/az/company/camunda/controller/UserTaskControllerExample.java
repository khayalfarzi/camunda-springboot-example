package az.company.camunda.controller;

import az.company.camunda.dto.EmployeeDTO;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user-task-rest-call")
public class UserTaskControllerExample {

    private static final String PROCESS_DEFINITION_KEY = "restCallForUserTask";

    @PostMapping
    public ResponseEntity<?> startBPMNProcess() {

        System.out.println("======================= Process started ===================================");

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/complete-user-task")
    public ResponseEntity<?> callUserTask(@RequestBody EmployeeDTO dto) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance instance;
        System.out.println("===");

        System.out.println("===");

        Map<String, Object> processVariables = new HashMap<>();

        processVariables.put("id", dto.getId());
        processVariables.put("name", dto.getName());


        processEngine.getTaskService().complete("Activity_088scpe", processVariables);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}