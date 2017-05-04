package com.greefoxacademy.controller;

import com.greefoxacademy.components.Fox;
import com.greefoxacademy.components.NavLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class MainController {
  final String[] foods = {"salad", "chicken", "pizza", "sushi", "human"};
  final String[] drinks = {"water", "lemonda", "beer", "gasoline"};

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
    model.addAttribute("foods", Arrays.asList(foods));
    model.addAttribute("drinks", Arrays.asList(drinks));
    model.addAttribute("fox", fox);

    return "store";
  }

  @RequestMapping("/updateNutrions")
  public String updateNutrions(String food, String drink) {
    fox.updateDiet(food, drink);

    return "redirect:/";
  }
}
