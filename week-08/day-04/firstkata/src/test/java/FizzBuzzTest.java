import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {
  @Test
  public void testForThree() {
    assertEquals("Fizz", FizzBuzz.doFizzBuzz(3));
  }

  @Test
  public void testForFour() {
    assertEquals("4", FizzBuzz.doFizzBuzz(4));
  }

  @Test
  public void testForFive() {
    assertEquals("Buzz", FizzBuzz.doFizzBuzz(5));
  }

  @Test
  public void testForSix() {
    assertEquals("Fizz", FizzBuzz.doFizzBuzz(6));
  }

  @Test
  public void testForSeven() {
    assertEquals("7", FizzBuzz.doFizzBuzz(7));
  }

  @Test
  public void testForTen() {
    assertEquals("Buzz", FizzBuzz.doFizzBuzz(10));
  }

  @Test
  public void testForFizzBuzz() {
    assertEquals("FizzBuzz", FizzBuzz.doFizzBuzz(15));
  }

  @Test
  public void testForZero() {
    assertEquals("0", FizzBuzz.doFizzBuzz(0));
  }

  @Test
  public void testForNegative() {
    assertEquals("-7", FizzBuzz.doFizzBuzz(-7));
  }
}