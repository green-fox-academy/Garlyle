package com.greenfoxacademy.model;

public class GrootTranslate {
  private String received, translated;

  public GrootTranslate(String message) {
    received = message;
    translated = "I am Groot!";
  }

  public String getReceived() {
    return received;
  }

  public String getTranslated() {
    return translated;
  }
}
