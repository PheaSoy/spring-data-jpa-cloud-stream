package org.soyphea.repository;

@FunctionalInterface
public interface RepositoryEvent {
  public <T> T send(T payload);
}
