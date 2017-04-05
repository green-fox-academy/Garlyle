package Anagram;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnagramTest {
  Anagram anagram = new Anagram();

  @Test
  public void TestWithMonica() {
    boolean result = anagram.areAnagrams("Monica Lewinsky", "Nice Silky Woman");
    assertTrue(result);
  }

  @Test
  public void TestWithMachines() {
    boolean result = anagram.areAnagrams("Slot Machines", "Cash lost in me");
    assertTrue(result);
  }

  @Test
  public void TestWithThirteen() {
    boolean result = anagram.areAnagrams("Eleven plus Two", "Twelve plus One");
    assertTrue(result);
  }

  @Test
  public void TestWithBanderas() {
    boolean result = anagram.areAnagrams("Antonio Banderas", "No brains on a date");
    assertTrue(result);
  }

  @Test
  public void TestWithEastwood() {
    boolean result = anagram.areAnagrams("Clint Eastwood", "Old West action");
    assertTrue(result);
  }

  @Test
  public void TestWithElvis() {
    boolean result = anagram.areAnagrams("Elvis", "lives");
    assertTrue(result);
  }
}
