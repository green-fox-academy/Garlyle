package com.greefoxacademy.config;

import com.greefoxacademy.components.Fox;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;

@Configuration
class MainConfig {
  @Bean
  @Primary
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
  public Fox Chocobo() {
    Fox myChocobo = new Fox("Chocobo", "images/chocobo.png", "human", "water");
    myChocobo.learnTrick("moonwalk");
    myChocobo.learnTrick("do a barrel roll");

    return myChocobo;
  }

  @Bean
  public ArrayList<Fox> makeList() {
    ArrayList<Fox> foxes = new ArrayList<>();
    foxes.add(DefaultFox());
    foxes.add(CyberDragon());
    foxes.add(Chocobo());

    return foxes;
  }

  public Fox newFox() {
    return new Fox("Mr. Green", "images/greenfox.png","salad", "water");
  }
}
