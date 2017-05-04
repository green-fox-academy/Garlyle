package com.greenfoxacademy.beans.service;

import com.greenfoxacademy.beans.interfaces.MessageService;

public class MessageProceeder {
  MessageService service;

  public MessageProceeder(MessageService service) {
    this.service = service;
  }

  public void processMessage(String msg, String address) {
    service.sendMessage(msg, address);
  }
}
