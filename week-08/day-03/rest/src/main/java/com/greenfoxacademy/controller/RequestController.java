package com.greenfoxacademy.controller;

import com.greenfoxacademy.model.Doubling;
import com.greenfoxacademy.model.Exception;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Exception exception() {
    return new Exception("Please provide an input!");
  }

  @GetMapping("/doubling")
  public Doubling doubling(@RequestParam int input) {
    return new Doubling(input);
  }
}
