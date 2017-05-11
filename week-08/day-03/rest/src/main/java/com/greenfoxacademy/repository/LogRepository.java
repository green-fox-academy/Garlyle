package com.greenfoxacademy.repository;

import com.greenfoxacademy.model.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Long> {
}
