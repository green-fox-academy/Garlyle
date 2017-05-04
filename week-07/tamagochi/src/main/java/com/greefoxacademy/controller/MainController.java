package com.greefoxacademy.controller;

import com.greefoxacademy.components.Fox;
import com.greefoxacademy.components.NavLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class MainController {
  @Autowired
  Fox fox;

  @ModelAttribute
  public void addAttributes(Model model) {
    ArrayList<NavLink> links = new ArrayList<>();
    links.add(new NavLink("/", "Information"));
    links.add(new NavLink("/nutritionStore", "Nutrion Store"));
    model.addAttribute("nav", links);
  }

  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("fox", fox);
    return "index";
  }

  @RequestMapping("/nutritionStore")
  public String store(Model model) {
    return "store";
  }
}
