package com.greenfoxacademy.repository;


import com.greenfoxacademy.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {
  List<Todo> findByIsDoneEquals(boolean done);
}
