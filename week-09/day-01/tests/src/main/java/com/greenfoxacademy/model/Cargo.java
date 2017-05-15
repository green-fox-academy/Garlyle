package com.greenfoxacademy.model;

public class Cargo {
  private int caliber25, caliber30, caliber50;
  private String shipstatus;
  private boolean ready;

  public Cargo() {
    caliber25 = caliber30 = caliber50 = 0;
    shipstatus = "empty";
    ready = false;
  }

  public int getCaliber25() {
    return caliber25;
  }

  public int getCaliber30() {
    return caliber30;
  }

  public int getCaliber50() {
    return caliber50;
  }

  public String getShipstatus() {
    return shipstatus;
  }

  public boolean isReady() {
    return ready;
  }
}
