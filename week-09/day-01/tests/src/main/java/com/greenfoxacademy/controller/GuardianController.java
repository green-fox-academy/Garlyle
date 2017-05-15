package com.greenfoxacademy.controller;

import com.greenfoxacademy.model.Exception;
import com.greenfoxacademy.model.GrootTranslate;
import com.greenfoxacademy.model.YonduArrow;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuardianController {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Exception error(MissingServletRequestParameterException ex) {
    if (ex.getParameterName().equals("message")) {
      return new Exception("I am Groot!");
    }
    return new Exception("Please give distance and time parameters");
  }

  @GetMapping("/groot")
  public GrootTranslate grootTranslate(@RequestParam String message) {
    return new GrootTranslate(message);
  }

  @GetMapping("/yondu")
  public YonduArrow yonduCalculate(@RequestParam float distance, @RequestParam float time) {
    return new YonduArrow(distance, time);
  }
}
