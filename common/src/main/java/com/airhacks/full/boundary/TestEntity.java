package com.airhacks.full.boundary;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

/**
 * Created by joaosousa on 2019-10-17.
 */
@Entity
public class TestEntity extends PanacheEntity {
  private String name;

  public String getName() {
    return name;
  }

  public TestEntity setName(String name) {
    this.name = name;
    return this;
  }
}
