package com.greenfoxacademy.thymeleaf.controller;

import com.greenfoxacademy.thymeleaf.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class Exercise5 {
  final String[] names = {"Simba", "Baloo", "Donald", "Goofy", "Tigger"};
  final String[] balance = {"2000", "42000", "500", "1600", "1234"};
  final String[] type = {"lion", "bear", "duck", "dog", "tiger"};

  @RequestMapping("/exercise5")
  public String listOfAccounts(Model model) {
    ArrayList<BankAccount> listOfAccounts = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      listOfAccounts.add(new BankAccount(names[i], balance[i], type[i]));
    }
    model.addAttribute("accounts", listOfAccounts);
    return "exercise5";
  }
}
