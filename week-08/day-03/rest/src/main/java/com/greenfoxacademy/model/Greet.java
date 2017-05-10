package com.greenfoxacademy.model;

public class Greet {
  public String welcome_message;

  public Greet(String name, String title) {
    welcome_message = "Oh, hi there " + name + ", my dear " + title + "!";
  }
}
