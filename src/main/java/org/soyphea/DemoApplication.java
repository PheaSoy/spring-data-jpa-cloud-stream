package org.soyphea;

import java.time.LocalDate;
import org.soyphea.binder.TaskEventProcessor;
import org.soyphea.domain.Task;
import org.soyphea.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBinding(TaskEventProcessor.class)
public class DemoApplication {

	@Autowired
	private TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			taskService.save(new Task("Completed Java Master Course","Completed the course with Java master class",
					LocalDate.now())).send();

			taskService.saveThenSend(new Task("Java Master Class","Completed the course with Java master class",
					LocalDate.now()));
		};
	}

}
