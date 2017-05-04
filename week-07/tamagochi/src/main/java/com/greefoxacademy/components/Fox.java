package com.greefoxacademy.components;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Fox {
  String name;
  ArrayList<String> tricks;
  String food;
  String drink;

  public Fox(String name, String food, String drink) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    tricks = new ArrayList<>();
  }

  public void learnTrick(String newTrick) {
    tricks.add(newTrick);
  }

  public int knownTricks() {
    return tricks.size();
  }

  public void updateDiet(String food, String drink) {
    this.food = food;
    this.drink = drink;
  }
}
