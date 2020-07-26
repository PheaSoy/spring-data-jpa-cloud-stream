package org.soyphea.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EventQueueBaseRepository<T,ID> extends CrudRepository<T,ID> {

  Optional<T> findById(ID id);
  <S extends T> S save(S entity);

}
