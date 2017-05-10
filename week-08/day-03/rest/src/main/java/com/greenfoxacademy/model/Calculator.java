package com.greenfoxacademy.model;

public class Calculator {
  public int result;
  public Calculator(String what, int until) {
    if (what.equals("factor")) {
      result = 1;
      for (int i = 1; i <= until; i++) {
        result *= i;
      }
    }
    if (what.equals("sum")) {
      result = 0;
      for (int i = 1; i <= until; i++) {
        result += i;
      }
    }

//    result = (what == "factor")? 1 : 0;
//    for (int i = 1; i <= until; i++) {
//      if (what == "sum") result += i;
//      if (what == "factor") result *= i;
//    }
  }
}
