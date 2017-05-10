package com.greenfoxacademy.controller;

import com.greenfoxacademy.model.*;
import com.greenfoxacademy.model.Exception;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public Exception noNumberException(HttpMessageNotReadableException ex) {
    if (ex.getMessage().contains("CalculatorParams")) {
      return new Exception("Please provide what to do with the numbers!");
    } else {
      return new Exception("Please provide a number!");
    }
  }

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

  @GetMapping("/appenda/{appendable}")
  public AppendA appenda(@PathVariable String appendable) {
    return new AppendA(appendable);
  }

  @PostMapping("/dountil/{what}")
  public Calculator dountil(@PathVariable String what, @RequestBody MyNumber number) {
    return new Calculator(what, number.until);
  }

  @PostMapping("/arrays")
  public ArrayCalculator arrayHandler(@RequestBody CalculatorParams input) {
    CalculatorParams calcParam = new CalculatorParams();
    calcParam.what = input.what;
    calcParam.numbers = input.numbers;
    return new ArrayCalculator(calcParam.what, calcParam.numbers);
  }
}
