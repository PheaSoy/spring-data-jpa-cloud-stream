package org.soyphea.binder;

import lombok.extern.slf4j.Slf4j;
import org.soyphea.domain.Task;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskListener {

  @StreamListener(TaskEventProcessor.TASK_INPUT)
  public void receiveTask(Task task) {
    log.info("Received Task:[{}]", task);
  }

}
