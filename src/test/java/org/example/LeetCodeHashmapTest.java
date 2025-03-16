package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LeetCodeHashmapTest {

  @Test
  @DisplayName("check ransom note")
  public void checkRansomNote() {
    assertEquals(false, LeetCodeHashMap.checkRansomNote("a", "b"));
    assertEquals(false, LeetCodeHashMap.checkRansomNote("aa", "ab"));
    assertEquals(true, LeetCodeHashMap.checkRansomNote("aa", "aab"));
  }

}
