package com.greenfoxacademy.milan.controller;

import com.greenfoxacademy.milan.model.Post;
import com.greenfoxacademy.milan.model.PostForm;
import com.greenfoxacademy.milan.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @PutMapping("/posts/{id}/upvote")
  public Post upvote(@PathVariable Long id) {
    Post post = repository.findOne(id);
    post.upVote();
    repository.save(post);

    return post;
  }

  @PutMapping("/posts/{id}/downvote")
  public Post downvote(@PathVariable Long id) {
    Post post = repository.findOne(id);
    post.downVote();
    repository.save(post);

    return post;
  }
}
