package org.soyphea.repository;

import org.soyphea.binder.TaskSender;
import org.springframework.stereotype.Component;

@Component
public class RepositoryEventImpl implements RepositoryEvent {

  private final TaskSender taskSender;

  public RepositoryEventImpl(TaskSender taskSender) {
    this.taskSender = taskSender;
  }

  @Override
  public <T> T send(T payload) {
      taskSender.send(payload);
      return payload;
  }

}
