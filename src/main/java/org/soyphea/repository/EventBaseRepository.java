package org.soyphea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EventBaseRepository<T,ID> extends CrudRepository<T,ID>{

}
