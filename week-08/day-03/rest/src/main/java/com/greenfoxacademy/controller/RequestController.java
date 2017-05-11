package com.greenfoxacademy.controller;

import com.greenfoxacademy.model.*;
import com.greenfoxacademy.model.Exception;
import com.greenfoxacademy.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RequestController {
  @Autowired
  LogRepository repository;

  @ModelAttribute
  public void log(HttpServletRequest request) {
    repository.save(new Log(request.getRequestURI(), request.getQueryString()));
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public Exception noNumberException() {
    return new Exception("Please provide a number!");
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
    return new Calculator(what, number.getUntil());
  }

  @GetMapping("/log")
  public Iterable<Log> log() {
    return repository.findAll();
  }
}
