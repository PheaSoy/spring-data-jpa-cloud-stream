package org.soyphea.controller;

import org.soyphea.TaskService;
import org.soyphea.domain.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskRestController {

  private final TaskService taskService;

  public TaskRestController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping("/_tasks")
  public ResponseEntity<Task> createTask(@RequestBody Task task) {
    return ResponseEntity.ok(taskService.save(task).send());
  }

  @GetMapping("/_tasks")
  public ResponseEntity<?> getAllTask(){
    return ResponseEntity.ok(taskService.listAllTask());
  }



}
