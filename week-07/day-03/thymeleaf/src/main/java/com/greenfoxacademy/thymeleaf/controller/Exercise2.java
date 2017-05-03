package com.greenfoxacademy.thymeleaf.controller;

import com.greenfoxacademy.thymeleaf.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exercise2 {
  @RequestMapping("/exercise2")
  public String getBankAccountWithDecimals(Model model) {
    BankAccount account = new BankAccount("Simba", "2000", "lion");
    model.addAttribute("account", account);
    return "exercise2";
  }
}
