package com.greenfoxacademy.beans;

import com.greenfoxacademy.beans.model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication implements CommandLineRunner {
  @Autowired
  HelloWorld hello;

  public static void main(String[] args) {
    SpringApplication.run(HelloWorldApplication.class);
  }

  @Override
  public void run(String... args) throws Exception {
    hello.setMessage("Hello World!");
    hello.getMessage();
  }
}
