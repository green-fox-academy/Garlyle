package com.greenfoxacademy.beans.model;

import com.greenfoxacademy.beans.interfaces.MyColor;

public class RedColor implements MyColor {
  @Override
  public void printColor() {
    System.out.println("It is red in color...");
  }
}
