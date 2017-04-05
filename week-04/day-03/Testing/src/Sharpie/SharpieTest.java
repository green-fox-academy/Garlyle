package Sharpie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SharpieTest {
  Sharpie s;

  @BeforeEach
  void setup() {
    s = new Sharpie("blue", 5);

  }

  @Test
  void TestForColor() {
    assertEquals("blue", s.color);
  }

  @Test
  void TestForWidth() {
    assertEquals(5, (int)s.width);
  }

  @Test
  void TestForUsage() {
    s.use();
    assertEquals(99, (int)s.inkAmount);
  }
}
