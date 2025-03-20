package org.leetcode.problems;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidAnagramTest {

  @Test
  @DisplayName("is valid anagram")
  public void isValidAnagram() {
    ValidAnagram validAnagram = new ValidAnagram();
    assertTrue(validAnagram.isAnagram("anagram", "nagaram"));
  }

}