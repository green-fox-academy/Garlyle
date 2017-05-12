package com.greenfoxacademy.milan.controller;

import com.greenfoxacademy.milan.model.Post;
import com.greenfoxacademy.milan.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class PostsController {
  @Autowired
  PostRepository repository;

  @GetMapping("/posts")
  public Iterable<Post> getPosts() {
    return repository.findAll();
  }

  @PostMapping("/posts")
  public Post createPost(@RequestBody Post newPost) {
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

  @DeleteMapping("/posts/{id}")
  public Post deletePost(@PathVariable Long id) {
    Post post = repository.findOne(id);
    repository.delete(id);

    return post;
  }

  @PutMapping("/posts/{id}")
  public Post updatePost(@PathVariable Long id, @RequestBody Post updateForm) {
    Post post = repository.findOne(id);
    post.setTitle(updateForm.getTitle());
    post.setHref(updateForm.getHref());
    repository.save(post);

    return post;
  }
}
