package com.greenfoxacademy.beans.model;

import com.greenfoxacademy.beans.interfaces.MessageService;

public class TwitterService implements MessageService {
  @Override
  public void sendMessage(String msg, String address) {
    System.out.println("Tweet Sent to " + address + " with Message=" + msg);
  }
}
