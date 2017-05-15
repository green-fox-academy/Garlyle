package com.greenfoxacademy.controller;

import com.greenfoxacademy.model.Exception;
import com.greenfoxacademy.model.GrootTranslate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuardianController {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Exception error() {
    return new Exception("I am Groot!");
  }

  @GetMapping("/groot")
  public GrootTranslate grootTranslate(@RequestParam String message) {
    return new GrootTranslate(message);
  }
}
