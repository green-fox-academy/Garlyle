package Animal;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Milan Kovacs on 2017. 04. 05..
 */
public class AnimalTest {
  Animal a;

  @BeforeEach
  void setup() {
    a = new Animal();
  }

  @Test
  void TestForPlay()
  {
    a.play();
    assertEquals(51, a.hunger);
    assertEquals(51, a.thirst);
  }

  @Test
  void TestForEat()
  {
    a.eat();
    assertEquals(49, a.hunger);
  }

  @Test
  void TestForDrink()
  {
    a.drink();
    assertEquals(49, a.thirst);
  }
}
