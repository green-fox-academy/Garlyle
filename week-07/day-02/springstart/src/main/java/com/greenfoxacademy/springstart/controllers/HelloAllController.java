package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class HelloAllController {
  String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
      "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
      "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
      "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

  @RequestMapping("/web/world")
  public String helloAll(Model model) {
    ArrayList<Message> entries = new ArrayList<>();
    Random rand = new Random();
    for (String line : hellos) {
      long value = rand.nextInt(22) + 10;
      int r, g, b;
      r = rand.nextInt(256);
      g = rand.nextInt(256);
      b = rand.nextInt(256);
      Message msg = new Message(line, String.format("#%02x%02x%02x", r, g, b), value);
      entries.add(msg);
    }
    model.addAttribute("entries", entries);
    return "greet-list";
  }
}
