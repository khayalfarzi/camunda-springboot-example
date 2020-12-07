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
@RequestMapping("/emp-leave-controller")
public class EmployeeController {

    private static final String PROCESS_DEFINITION_KEY = "employee-leave-flow";

    @PostMapping
    public ResponseEntity<?> startBPMNProcess(@RequestBody EmployeeDTO dto) {

        System.out.println("======================= Process started ===================================");

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        System.out.println(processEngine.toString());

        RuntimeService runtimeService = processEngine.getRuntimeService();

        System.out.println(runtimeService.toString());

        Map<String, Object> processVariables = new HashMap<>();

        processVariables.put("id", dto.getId());
        processVariables.put("name", dto.getName());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, processVariables);

        System.out.println(processInstance.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}