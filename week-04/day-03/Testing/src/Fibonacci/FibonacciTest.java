package Fibonacci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
  @Test
  public void TestCorrectNumber() {
    assertEquals(8, Fibonacci.fibonacci(6));
  }

  @Test
  public void TestForZero() {
    assertEquals(0, Fibonacci.fibonacci(0));
  }

  @Test
  public void TestForNegative() {
    assertEquals(0, Fibonacci.fibonacci(-20));
  }
}
