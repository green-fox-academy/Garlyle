package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {
  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value="name") String name) {
    Greeting hi = new Greeting(1, "Hello " + name + "!");

    return hi;
  }
}
