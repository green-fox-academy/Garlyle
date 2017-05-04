package com.greenfoxacademy.beans.config;

import com.greenfoxacademy.beans.model.BlueColor;
import com.greenfoxacademy.beans.model.GreenColor;
import com.greenfoxacademy.beans.model.RedColor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ColorConfig {
  @Bean
  RedColor redColor() {
    return new RedColor();
  }

  @Bean
  GreenColor greenColor() {
    return new GreenColor();
  }

  @Bean
  BlueColor blueColor() {
    return new BlueColor();
  }
}
