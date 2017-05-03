package com.greenfoxacademy.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class Exercise4 {
  @RequestMapping("/exercise4")
  public String handleString(Model model) {
    model.addAttribute("line", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "exercise4";
  }
}
