package az.company.camunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("camunda-springboot-example")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}