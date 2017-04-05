package Apples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplesTest {
  @Test
  public void TestForApples() {
    Apples myObject = new Apples();
    assertEquals("apple", myObject.getApple());
  }
}
