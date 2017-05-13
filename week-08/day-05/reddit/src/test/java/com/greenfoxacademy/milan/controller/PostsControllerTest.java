package com.greenfoxacademy.milan.controller;

import com.greenfoxacademy.milan.RedditApplication;
import com.greenfoxacademy.milan.repository.PostRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedditApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class PostsControllerTest {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

  private MockMvc mockMvc;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostsController postsController;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();

    postRepository.deleteAll();
  }

  @Test
  public void testForGetPosts() throws Exception {
    mockMvc.perform(get("/posts"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType));
  }

  @Test
  public void testForPosting() throws Exception {
    mockMvc.perform(post("/posts")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"title\": \"JUnit Testing\", \"href\": \"http://9gag.com\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType));
  }
}