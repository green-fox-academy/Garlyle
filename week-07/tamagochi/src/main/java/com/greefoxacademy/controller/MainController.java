package com.greefoxacademy.controller;

import com.greefoxacademy.components.Action;
import com.greefoxacademy.components.Fox;
import com.greefoxacademy.components.NavLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Controller
public class MainController {
  final String[] foods = {"salad", "chicken", "pizza", "sushi", "human"};
  final String[] drinks = {"water", "lemonda", "beer", "gasoline"};
  final String[] tricks = {"write HTML", "make coffee", "code in Java", "do a barrel roll",
                          "hack the bank", "eat @beans", "play darts", "salute", "moonwalk",
                          "write CV", "draw fractal trees"};

  @Autowired
  Fox fox;
  ArrayList<Action> history = new ArrayList<>();

  @ModelAttribute
  public void addAttributes(Model model) {
    ArrayList<NavLink> links = new ArrayList<>();
    links.add(new NavLink("/", "Information"));
    links.add(new NavLink("/nutritionStore", "Nutrion Store"));
    links.add(new NavLink("/trickCenter", "Trick Center"));
    links.add(new NavLink("/actionHistory", "Action History"));
    model.addAttribute("nav", links);

    model.addAttribute("fox", fox);
    model.addAttribute("history", history);
  }

  @RequestMapping("/")
  public String index(Model model) {
    return "index";
  }

  @RequestMapping("/nutritionStore")
  public String store(Model model) {
    model.addAttribute("foods", Arrays.asList(foods));
    model.addAttribute("drinks", Arrays.asList(drinks));

    return "store";
  }

  @RequestMapping("/updateNutrions")
  public String updateNutrions(String food, String drink) {
    fox.updateDiet(food, drink);

    return "redirect:/";
  }

  @RequestMapping("/trickCenter")
  public String trickCenter(Model model) {
    model.addAttribute("tricks", Arrays.asList(tricks));

    return "trick";
  }

  @RequestMapping("/learnTrick")
  public String learnTrick(String trick) {
    if (trick != null) {
      fox.learnTrick(trick);
    }

    return "redirect:/";
  }

  @RequestMapping("/actionHistory")
  public String showHistory(Model model) {
    history.add(new Action(new Date(), "Watched Action history"));
    return "history";
  }
}
