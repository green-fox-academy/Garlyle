package com.greefoxacademy.config;

import com.greefoxacademy.components.Fox;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
class MainConfig {
  @Bean
  public Fox DefaultFox() {
    Fox myFox = new Fox("Mr. Fox", "images/greenfox.png","pizza", "lemonade");
    myFox.learnTrick("write HTML");
    myFox.learnTrick("code in Java");

    return myFox;
  }

  @Bean
  @Primary
  public Fox CyberDragon() {
    Fox myDragon = new Fox("Cyber Dragon", "images/cyberdragon.png", "sushi", "gasoline");

    return myDragon;
  }

  public Fox newFox() {
    return new Fox("Mr. Green", "images/greenfox.png","salad", "water");
  }
}
