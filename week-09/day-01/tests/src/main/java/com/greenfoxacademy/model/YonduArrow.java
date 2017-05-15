package com.greenfoxacademy.model;

public class YonduArrow {
  private double distance, time, speed;
  public YonduArrow(float distance, float time) {
    this.distance = distance;
    this.time = time;
    this.speed = distance / time;
  }

  public double getDistance() {
    return distance;
  }

  public double getTime() {
    return time;
  }

  public double getSpeed() {
    return speed;
  }
}
