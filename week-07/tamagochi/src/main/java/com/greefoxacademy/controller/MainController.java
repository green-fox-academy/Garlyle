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
  ArrayList<Fox> foxes;
  Fox fox;
  ArrayList<Action> history = new ArrayList<>();

  @ModelAttribute
  public void addAttributes(Model model) {
    if (fox == null) {
      fox = foxes.get(0);
    }

    ArrayList<NavLink> links = new ArrayList<>();
    links.add(new NavLink("/", "Information"));
    links.add(new NavLink("/nutritionStore", "Nutrion Store"));
    links.add(new NavLink("/trickCenter", "Trick Center"));
    links.add(new NavLink("/actionHistory", "Action History"));
    links.add(new NavLink("/switchPet", "Switch pet"));
    model.addAttribute("nav", links);

    model.addAttribute("fox", fox);
  }

  private void postAction(String message) {
    history.add(0, new Action(new Date(), message));
  }

  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("history", history);

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
    postAction(fox.getName() + " changed diet to " + food + " and " + drink);

    return "redirect:/";
  }

  @RequestMapping("/trickCenter")
  public String trickCenter(Model model) {
    model.addAttribute("tricks", Arrays.asList(tricks));

    return "trick";
  }

  @RequestMapping("/learnTrick")
  public String learnTrick(String trick) {
    fox.learnTrick(trick);
    postAction(fox.getName() + " learned how to " + trick);

    return "redirect:/";
  }

  @RequestMapping("/actionHistory")
  public String showHistory(Model model) {
    model.addAttribute("history", history);

    return "history";
  }

  @RequestMapping("/switchPet")
  public String showPetList(Model model) {
    model.addAttribute("list", foxes);

    return "switch";
  }

  @RequestMapping("/switch")
  public String changePet(int index) {
    fox = foxes.get(index);

    return "redirect:/";
  }
}
