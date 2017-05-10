package com.greenfoxacademy.controller;

import com.greenfoxacademy.model.Doubling;
import com.greenfoxacademy.model.Exception;
import com.greenfoxacademy.model.Greet;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Exception exception(MissingServletRequestParameterException ex) {
    String paramName = ex.getParameterName();

    if (paramName.equals("input")) {
      return new Exception("Please provide an input!");
    } else {
      return new Exception("Please provide a " + paramName + "!");
    }
  }

  @GetMapping("/doubling")
  public Doubling doubling(@RequestParam int input) {
    return new Doubling(input);
  }

  @GetMapping("/greeter")
  public Greet greeter(@RequestParam String name, @RequestParam String title) {
    return new Greet(name, title);
  }
}
