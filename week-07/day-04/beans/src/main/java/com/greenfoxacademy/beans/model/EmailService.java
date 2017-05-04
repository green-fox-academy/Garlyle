package com.greenfoxacademy.beans.model;

import com.greenfoxacademy.beans.interfaces.MessageService;

public class EmailService implements MessageService {
  @Override
  public void sendMessage(String msg, String address) {
    System.out.println("Email Sent to " + address + " with Message=" + msg);
  }
}
