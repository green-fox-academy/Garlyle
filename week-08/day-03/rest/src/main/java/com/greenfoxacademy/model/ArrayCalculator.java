package com.greenfoxacademy.model;

import java.util.ArrayList;
import java.util.List;

public class ArrayCalculator {
  public Object result;

  public ArrayCalculator(String what, List<Integer> numbers) {
    switch (what) {
      case "sum":
        addNumbers(numbers);
        break;
      case "multiply":
        multiplyNumbers(numbers);
        break;
      case "double":
        doubleNumbers(numbers);
        break;
      default:
        break;
    }
    }

  private void doubleNumbers(List<Integer> numbers) {
    List<Integer> ret = new ArrayList<>();
    for (Integer i : numbers) {
      ret.add(i * 2);
    }
    result = ret;
  }

  private void multiplyNumbers(List<Integer> numbers) {
    int temp = 1;
    for (Integer i : numbers) {
      temp *= i;
    }
    result = new Integer(temp);
  }

  private void addNumbers(List<Integer> numbers) {
    int temp = 0;
    for (Integer i : numbers) {
      temp += i;
    }
    result = new Integer(temp);
  }
}
