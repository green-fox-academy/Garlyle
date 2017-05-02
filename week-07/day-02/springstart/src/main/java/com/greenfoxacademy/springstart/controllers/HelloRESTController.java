package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {
  private final AtomicLong counter = new AtomicLong();
  private final HashMap<String, AtomicLong> greetingTable = new HashMap<>();

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value="name") String name) {
    if (!greetingTable.containsKey(name)) {
      greetingTable.put(name, new AtomicLong());
    }
    long value = greetingTable.get(name).incrementAndGet();
    //long value = counter.incrementAndGet();
    Greeting hi = new Greeting(value, "Hello " + name + "!");
    return hi;
  }
}
