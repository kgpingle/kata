package org.leetcode.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatsTest {

  @Test
  @DisplayName("find longest substring without repeats")
  public void findLongestSubString() {
    assertEquals(" ", LongestSubstringWithoutRepeats.findSubString(" "));
    assertEquals("abc", LongestSubstringWithoutRepeats.findSubString("abcabcbb"));
    assertEquals("b", LongestSubstringWithoutRepeats.findSubString("bbbbb"));
    assertEquals("wke", LongestSubstringWithoutRepeats.findSubString("pwwkew"));
    assertEquals("", LongestSubstringWithoutRepeats.findSubString(""));
    assertEquals("", LongestSubstringWithoutRepeats.findSubString(null));
    assertEquals("abc", LongestSubstringWithoutRepeats.findAllLongestSubstrings("abcabcbb", 3));
  }

}