package org.soyphea.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TaskEventProcessor {

  String TASK_OUTPUT = "task_output";
  String TASK_INPUT = "task_input";

  @Output(TASK_OUTPUT)
  MessageChannel taskOutput();

  @Input(TASK_INPUT)
  SubscribableChannel taskInput();

}
