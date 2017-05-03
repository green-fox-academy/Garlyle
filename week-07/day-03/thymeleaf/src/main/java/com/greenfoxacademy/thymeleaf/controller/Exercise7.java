package com.greenfoxacademy.thymeleaf.controller;

import com.greenfoxacademy.thymeleaf.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
class Exercise7 {
  final String[] names = {"Simba", "Baloo", "Triton", "Goofy", "Tigger"};
  final String[] balance = {"2000", "42000", "99999", "1600", "1234"};
  final String[] type = {"lion", "bear", "King", "dog", "tiger"};
  final boolean[] kings = {false, false, true, false, false};

  @RequestMapping("/exercise7")
  public String listOfAccounts(Model model) {
    ArrayList<BankAccount> listOfAccounts = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      listOfAccounts.add(new BankAccount(names[i], balance[i], type[i], kings[i], false));
    }
    model.addAttribute("accounts", listOfAccounts);
    return "exercise7";
  }
}
