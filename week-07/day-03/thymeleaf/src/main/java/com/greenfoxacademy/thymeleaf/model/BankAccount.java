package com.greenfoxacademy.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
  String name;
  String balance;
  String animalType;
  boolean king;
  boolean evil;

  public BankAccount(String name, String balance, String animalType) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    evil = king = false;
  }

  public void increaseBalance(int amount) {
    Integer value = Integer.parseInt(balance) + 10;
    balance = value.toString();
  }
}
