package Count;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CountLettersTest {
  HashMap<Character, Integer> characterOccurence;

  @Test
  public void TestWithPanama() {
    characterOccurence = CountLetters.Count("Panama");

    assertEquals(3, (int)characterOccurence.get('a'));
  }

  @Test
  public void TestWithMississippi() {
    characterOccurence = CountLetters.Count("Mississippi");

    assertEquals(4, (int)characterOccurence.get('i'));
    assertEquals(4, (int)characterOccurence.get('s'));
  }

  @Test
  public void TestWithAlabama() {
    characterOccurence = CountLetters.Count("Alabama");

    assertEquals(4, (int)characterOccurence.get('a'));
  }
}
