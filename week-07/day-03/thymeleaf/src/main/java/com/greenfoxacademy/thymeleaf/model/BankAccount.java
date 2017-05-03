package com.greenfoxacademy.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BankAccount {
  String name;
  String balance;
  String animalType;
  boolean isKing;
  boolean isEvil;

  public BankAccount(String name, String balance, String animalType) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    isEvil = isKing = false;
  }
}
