package com.greenfoxacademy.controller;

import com.greenfoxacademy.model.ArrayCalculator;
import com.greenfoxacademy.model.CalculatorParams;
import com.greenfoxacademy.model.Exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArrayHandlingController {
  @ExceptionHandler(java.lang.Exception.class)
  public Exception error() {
    return new Exception("Please provide what to do with the numbers!");
  }

  @PostMapping("/arrays")
  public ArrayCalculator arrayHandler(@RequestBody CalculatorParams input) {
    return new ArrayCalculator(input.getWhat(), input.getNumbers());
  }
}
