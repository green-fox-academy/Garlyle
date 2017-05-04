package com.greenfoxacademy.beans;

import com.greenfoxacademy.beans.config.ColorConfig;
import com.greenfoxacademy.beans.interfaces.MyColor;
import com.greenfoxacademy.beans.model.BlueColor;
import com.greenfoxacademy.beans.model.GreenColor;
import com.greenfoxacademy.beans.model.RedColor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ColorApplication implements CommandLineRunner{
  MyColor red, green, blue;

  public static void main(String[] args) {
    SpringApplication.run(ColorApplication.class);
  }

  @Override
  public void run(String... args) throws Exception {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ColorConfig.class);
    red = ctx.getBean(RedColor.class);
    green = ctx.getBean(GreenColor.class);
    blue = ctx.getBean(BlueColor.class);

    red.printColor();
    green.printColor();
    blue.printColor();
  }
}
