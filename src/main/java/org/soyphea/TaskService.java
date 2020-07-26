package org.soyphea;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.soyphea.binder.TaskSender;
import org.soyphea.domain.Task;
import org.soyphea.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  final private TaskRepository taskRepository;
  final private TaskSender taskSender;
  private Task task;

  public TaskService(TaskRepository taskRepository,
      TaskSender taskSender) {
    this.taskRepository = taskRepository;
    this.taskSender = taskSender;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }


  public TaskService save(Task sendTask) {
    this.setTask(sendTask);
    Task saveTask = taskRepository.save(this.getTask());
    return this;
  }

  public Task send(){
    taskSender.send(this.getTask());
    return this.getTask();
  }
  public List listAllTask(){
    return Stream.of(taskRepository.findAll()).collect(Collectors.toList());
  }

}
