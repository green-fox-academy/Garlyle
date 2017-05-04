package com.greenfoxacademy.beans.model;

import com.greenfoxacademy.beans.interfaces.MyColor;

public class GreenColor implements MyColor {
  @Override
  public void printColor() {
    System.out.println("This color is green!!");
  }
}
