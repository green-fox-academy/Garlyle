package com.greenfoxacademy.beans.config;

import com.greenfoxacademy.beans.model.EmailService;
import com.greenfoxacademy.beans.model.TwitterService;
import com.greenfoxacademy.beans.service.MessageProceeder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MessageConfiguration {
  @Bean
  public EmailService getEmailService() {
    return new EmailService();
  }

  @Bean
  public TwitterService getTwitterService() {
    return new TwitterService();
  }

  @Bean
  @Primary
  public MessageProceeder getEmailProceeder() {
    return new MessageProceeder(getEmailService());
  }

  @Bean
  public MessageProceeder getTwitterProceeder() {
    return new MessageProceeder(getTwitterService());
  }
}
