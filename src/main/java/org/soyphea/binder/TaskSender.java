package org.soyphea.binder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskSender<T> {
  final private TaskEventProcessor taskEventProcessor;

  public TaskSender(TaskEventProcessor taskEventProcessor) {
    this.taskEventProcessor = taskEventProcessor;
  }

  public void send(T payload){
    log.info("Send payload:[{}]",payload);
    taskEventProcessor.taskOutput().send(MessageBuilder.withPayload(payload).build());
  }



}
