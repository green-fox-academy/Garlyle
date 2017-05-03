package com.greenfoxacademy.thymeleaf.controller;

import com.greenfoxacademy.thymeleaf.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
class Exercise11 {
  final String[] names = {"Simba", "Baloo", "Triton", "Goofy", "Tigger"};
  final String[] balance = {"2000", "42000", "99999", "1600", "1234"};
  final String[] type = {"lion", "bear", "King", "dog", "tiger"};
  final boolean[] kings = {false, false, true, false, false};
  final boolean[] evils = {true, false, false, true, false};

  ArrayList<BankAccount> listOfAccounts = new ArrayList<>();

  @RequestMapping("/exercise11")
  public String listOfAccounts(Model model) {
    if (listOfAccounts.isEmpty()) {
      for (int i = 0; i < 5; i++) {
        listOfAccounts.add(new BankAccount(names[i], balance[i], type[i], kings[i], evils[i]));
      }
    }
    model.addAttribute("accounts", listOfAccounts);
    model.addAttribute("newAccount", new BankAccount());
    return "exercise11";
  }

  @RequestMapping("/topup2")
  public String topUp(int index) {
    System.out.println(index);
    listOfAccounts.get(index).increaseBalance(10);

    return "redirect:/exercise11";
  }

  @RequestMapping("/add")
  public String addNewAccount(BankAccount account) {
    System.out.println(account);
    listOfAccounts.add(account);
    return "redirect:/exercise11";
  }
}
