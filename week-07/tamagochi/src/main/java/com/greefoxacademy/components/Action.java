package com.greefoxacademy.components;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Action {
  Date postTime;
  String message;
}
