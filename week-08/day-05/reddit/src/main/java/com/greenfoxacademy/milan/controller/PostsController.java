package com.greenfoxacademy.milan.controller;

import com.greenfoxacademy.milan.model.Post;
import com.greenfoxacademy.milan.model.PostForm;
import com.greenfoxacademy.milan.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {
  @Autowired
  PostRepository repository;

  @GetMapping("/posts")
  public Iterable<Post> getPosts() {
    return repository.findAll();
  }

  @PostMapping("/posts")
  public Post createPost(@RequestBody PostForm newPost) {
    Post post = new Post(newPost.getTitle(), newPost.getHref());
    repository.save(post);
    return post;
  }
}
