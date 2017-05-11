import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PotterTest {
  @Test
  public void testForSellOne() {
    assertEquals(8.0, Potter.getPriceTag(Arrays.asList(1)), 0);
  }

  @Test
  public void testForSellTwo() {
    assertEquals(16.0, Potter.getPriceTag(Arrays.asList(1,1)), 0);
  }

  @Test
  public void testFortSellTwoDifferent() {
    assertEquals(15.2, Potter.getPriceTag(Arrays.asList(1,2)), 0);
  }

  @Test
  public void testFortSellThreeDifferent() {
    assertEquals(21.6, Potter.getPriceTag(Arrays.asList(1,2,3)), 0);
  }

  @Test
  public void testFortSellFourDifferent() {
    assertEquals(25.6, Potter.getPriceTag(Arrays.asList(1,2,3,4)), 0);
  }

  @Test
  public void testFortSellFiveDifferent() {
    assertEquals(30.0, Potter.getPriceTag(Arrays.asList(1,2,3,4,5)), 0);
  }

  @Test
  public void testForShoppingThreePlusOne() {
    assertEquals(29.6, Potter.getPriceTag(Arrays.asList(1,2,3,1)), 0);
  }

  @Test
  public void testForPotterMania() {
    assertEquals(51.2, Potter.getPriceTag(Arrays.asList(1,1,2,2,3,3,4,5)), 0);
  }
}