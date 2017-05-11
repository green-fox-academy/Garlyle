import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {
  @Test
  public void testForDifferentLength() {
    assertFalse(Utils.areAnagrams("kutya", "macska"));
  }

  @Test
  public void testForAnagram() {
    assertTrue(Utils.areAnagrams("abc", "ABC"));
  }

  @Test
  public void testForNonAnagrams() {
    assertFalse(Utils.areAnagrams("abc", "def"));
  }

  @Test
  public void testForDifferentOrder() {
    assertTrue(Utils.areAnagrams("abca", "baca"));
  }

  @Test
  public void TestForDifferentLetterCount() {
    assertFalse(Utils.areAnagrams("cicaa", "iiica"));
  }

  @Test
  public void TestForNull() {
    assertFalse(Utils.areAnagrams(null, "ok"));
  }

  @Test
  public void TestWithEastwood() {
    assertTrue(Utils.areAnagrams("Clint Eastwood", "Old West action"));
  }

  @Test
  public void TestForUnicode() {
    assertFalse(Utils.areAnagrams("o", "ő"));
  }

  @Test
  public void TestForEmpties() {
    assertTrue(Utils.areAnagrams("", ""));
  }

}