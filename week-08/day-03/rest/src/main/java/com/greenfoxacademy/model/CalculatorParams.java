package com.greenfoxacademy.model;

import java.util.List;

public class CalculatorParams {
  public String what;
  public List<Integer> numbers;

  public CalculatorParams() {
  }

  public CalculatorParams(String what, List<Integer> numbers) {
    this.what = what;
    this.numbers = numbers;
  }
}
