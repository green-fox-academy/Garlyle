package com.greenfoxacademy.milan.repository;

import com.greenfoxacademy.milan.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
//  Post findFirstById();
}
