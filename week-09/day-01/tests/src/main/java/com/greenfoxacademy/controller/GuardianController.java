package com.greenfoxacademy.controller;

import com.greenfoxacademy.model.*;
import com.greenfoxacademy.model.Exception;
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
    } else if (ex.getParameterName().equals("distance") || ex.getParameterName().equals("time")) {
      return new Exception("Please give distance and time parameters");
    }
    return new Exception("Please give caliber and amount parameters");
  }

  @GetMapping("/groot")
  public GrootTranslate grootTranslate(@RequestParam String message) {
    return new GrootTranslate(message);
  }

  @GetMapping("/yondu")
  public YonduArrow yonduCalculate(@RequestParam float distance, @RequestParam float time) {
    return new YonduArrow(distance, time);
  }

  @GetMapping("/rocket")
  public Cargo getCargo() {
    return new Cargo();
  }

  @GetMapping("/rocket/fill")
  public CargoStatus fillCargo(@RequestParam String caliber, @RequestParam int amount) {
    return new CargoStatus(caliber, amount);
  }
}
