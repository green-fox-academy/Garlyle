package com.greefoxacademy.config;

import com.greefoxacademy.components.Fox;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

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
  public Fox CyberDragon() {
    Fox myDragon = new Fox("Cyber Dragon", "images/cyberdragon.png", "sushi", "gasoline");

    return myDragon;
  }

  @Bean
  public ArrayList<Fox> makeList() {
    ArrayList<Fox> foxes = new ArrayList<>();
    foxes.add(DefaultFox());
    foxes.add(CyberDragon());

    return foxes;
  }

  public Fox newFox() {
    return new Fox("Mr. Green", "images/greenfox.png","salad", "water");
  }
}
