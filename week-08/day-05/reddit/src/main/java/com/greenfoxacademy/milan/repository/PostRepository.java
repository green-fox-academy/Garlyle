package com.greenfoxacademy.milan.repository;

import com.greenfoxacademy.milan.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
