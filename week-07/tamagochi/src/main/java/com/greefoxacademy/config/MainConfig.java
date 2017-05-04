package com.greefoxacademy.config;

import com.greefoxacademy.components.Fox;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MainConfig {
  @Bean
  public Fox DefaultFox() {
    Fox myFox = new Fox("Mr. Fox", "pizza", "lemonade");
    myFox.learnTrick("write HTML");
    myFox.learnTrick("code in Java");

    return myFox;
  }

  public Fox newFox() {
    return new Fox("Mr. Green", "salad", "water");
  }
}
