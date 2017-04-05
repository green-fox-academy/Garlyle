package Sum;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SumTest {
  ArrayList<Integer> testNumbers;
  Sum sumClass;

  @Before
  public void setup() {
    sumClass = new Sum();
    testNumbers = new ArrayList<>();
  }

  @Test
  public void TestForEmpty() {
    assertEquals(0, sumClass.sum(testNumbers));
  }

  @Test
  public void TestForOne() {
    testNumbers.add(1);
    assertEquals(1, sumClass.sum(testNumbers));
  }

  @Test
  public void TestForMultiple() {
    testNumbers.add(1);
    testNumbers.add(2);
    testNumbers.add(3);
    testNumbers.add(4);
    testNumbers.add(6);

    assertEquals(16, sumClass.sum(testNumbers));
  }

  @Test
  public void TestForNull() {
    assertEquals(0, sumClass.sum(null));
  }
}
