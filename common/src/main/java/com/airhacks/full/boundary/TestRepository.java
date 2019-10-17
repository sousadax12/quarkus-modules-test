package com.airhacks.full.boundary;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * Created by joaosousa on 2019-10-17.
 */
@ApplicationScoped
public class TestRepository extends PersistenceRepository<TestEntity> implements PanacheRepositoryBase<TestEntity, Long> {
  @Override
  protected List<String> getSortableFields() {
    return null;
  }

  @Override
  protected List<String> getSearchableFields() {
    return null;
  }
}
