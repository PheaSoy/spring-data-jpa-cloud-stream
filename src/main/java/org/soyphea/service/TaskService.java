package org.soyphea.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.soyphea.domain.Task;
import org.soyphea.repository.RepositoryEvent;
import org.soyphea.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  final private TaskRepository taskRepository;
  private Task task;
  private RepositoryEvent repositoryEvent;

  public TaskService(TaskRepository taskRepository,
      RepositoryEvent repositoryEvent) {
    this.taskRepository = taskRepository;
    this.repositoryEvent = repositoryEvent;
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
    return repositoryEvent.send(this.getTask());
  }

  public Task saveThenSend(Task task){
    this.setTask(task);
    return repositoryEvent.send(taskRepository.save(this.getTask()));
  }
  public List listAllTask(){
    return Stream.of(taskRepository.findAll()).collect(Collectors.toList());
  }

}
