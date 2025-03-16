package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LeetCodeArraysTest {

  @Test
  @DisplayName("Should full justify text")
  public void shouldFullJustify() {
    List<String> actual = LeetCodeArrays.fullJustify(
        new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    List<String> expected = new ArrayList<>();
    expected.add("This    is    an");
    expected.add("example  of text");
    expected.add("justification.  ");
    for (int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), actual.get(i));
    }

    actual = LeetCodeArrays.fullJustify(
        new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
    expected = new ArrayList<>();
    expected.add("What   must   be");
    expected.add("acknowledgment  ");
    expected.add("shall be        ");
    for (int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), actual.get(i));
    }

    actual = LeetCodeArrays.fullJustify(
        new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
            "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);
    expected = new ArrayList<>();
    expected.add("Science  is  what we");
    expected.add("understand      well");
    expected.add("enough to explain to");
    expected.add("a  computer.  Art is");
    expected.add("everything  else  we");
    expected.add("do                  ");
    for (int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), actual.get(i));
    }
  }

  @Test
  @DisplayName("reverse words in a string")
  public void reverseWordsInAString() {
    assertEquals("blue is sky the", LeetCodeArrays.reverseWordsInAString("the sky is blue"));
    assertEquals("world hello", LeetCodeArrays.reverseWordsInAString("  hello world  "));
    assertEquals("example good a", LeetCodeArrays.reverseWordsInAString("a good   example"));
  }

  @Test
  @DisplayName("Rotate an array")
  public void rotateAnArray() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    LeetCodeArrays.rotateAnArray(nums, 1);
    int[] expectedNums = {7, 1, 2, 3, 4, 5, 6};
    for (int i = 0; i < nums.length; i++) {
      assertEquals(expectedNums[i], nums[i]);
    }
  }

  @Test
  @DisplayName("should find time to buy and sell stocks")
  public void bestTimeToBuyAndSellStock() {
    assertEquals(7, LeetCodeArrays.bestTimeToBuyAndSellStock(new int[]{7, 1, 5, 3, 6, 4}));
    assertEquals(4, LeetCodeArrays.bestTimeToBuyAndSellStock(new int[]{1, 2, 3, 4, 5}));
    assertEquals(0, LeetCodeArrays.bestTimeToBuyAndSellStock(new int[]{7, 6, 4, 3, 1}));
  }

  @Test
  @DisplayName("remove duplicates from array up to max 2 occurence")
  public void removeDuplicatesUptoTwoOccurence() {
    assertEquals(5, LeetCodeArrays.removeDuplicateUptoTwoOccurence(new int[]{1, 1, 1, 2, 2, 3}));
    assertEquals(7,
        LeetCodeArrays.removeDuplicateUptoTwoOccurence(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
  }

  @Test
  @DisplayName("roman to numeric")
  public void romanToNumeric() {
    assertEquals("IX", LeetCodeArrays.numericToRoman(9));
    assertEquals("MCMXCIV", LeetCodeArrays.numericToRoman(1994));
    assertEquals("LVIII", LeetCodeArrays.numericToRoman(58));
  }

  @Test
  @DisplayName("First occurence in a string")
  public void firstOccurenceInAString() {
    assertEquals(4, LeetCodeArrays.firstOccurenceInAString("mississippi", "issip"));
    assertEquals(2, LeetCodeArrays.firstOccurenceInAString("hello", "ll"));
    assertEquals(-1, LeetCodeArrays.firstOccurenceInAString("haystack", "needle"));
    assertEquals(0, LeetCodeArrays.firstOccurenceInAString("sadbutsad", "sad"));
    assertEquals(-1, LeetCodeArrays.firstOccurenceInAString("leetcode", "leeto"));
  }

  @Test
  @DisplayName("Longest common prefix")
  public void shouldFindLongestCommonPrefix() {
    assertEquals("fl",
        LeetCodeArrays.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    assertEquals("", LeetCodeArrays.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
  }

  @Test
  @DisplayName("shoulc calculate length of last word")
  public void lengthOfLastWord() {
    assertEquals(4, LeetCodeArrays.lengthOfLastWord("   fly me   to   the moon  "));
    assertEquals(3, LeetCodeArrays.lengthOfLastWord("Today is a nice day"));
    assertEquals(5, LeetCodeArrays.lengthOfLastWord("Hello World"));
    assertEquals(6, LeetCodeArrays.lengthOfLastWord("luffy is still joyboy"));
    assertEquals(6, LeetCodeArrays.lengthOfLastWord("          luffy is still joyboy"));
  }

  @Test
  @DisplayName("should convert roman to numerals")
  public void shouldConvertRomansToNumerals() {
    assertEquals(58, LeetCodeArrays.romanToNumeral("LVIII"));
    assertEquals(1994, LeetCodeArrays.romanToNumeral("MCMXCIV"));
    assertEquals(4, LeetCodeArrays.romanToNumeral("IV"));
    assertEquals(9, LeetCodeArrays.romanToNumeral("IX"));
    assertEquals(1, LeetCodeArrays.romanToNumeral("I"));
    assertEquals(3, LeetCodeArrays.romanToNumeral("III"));
    assertEquals(5, LeetCodeArrays.romanToNumeral("V"));
    assertEquals(6, LeetCodeArrays.romanToNumeral("VI"));
  }

  @Test
  @DisplayName("should maximize stock profit")
  public void shouldMaximizeStockProfit() {
    assertEquals(5, LeetCodeArrays.maximizeStockProfit(new int[]{7, 1, 5, 3, 6, 4}));
    assertEquals(0, LeetCodeArrays.maximizeStockProfit(new int[]{7, 6, 4, 3, 1}));
    assertEquals(0, LeetCodeArrays.maximizeStockProfit(new int[]{}));
    assertEquals(3, LeetCodeArrays.maximizeStockProfit(new int[]{4, 7, 2, 1}));
  }

  @Test
  @DisplayName("should merge 2 sorted arrays")
  public void shouldMerge2SortedArrays() {
    assertEquals(6,
        LeetCodeArrays.mergeArrays(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3).length);
  }

  @Test
  @DisplayName("should find majority element")
  public void shouldFindMajorityElement() {
    assertEquals(3, LeetCodeArrays.findMajority(new int[]{3, 2, 3}));
    assertEquals(2, LeetCodeArrays.findMajority(new int[]{2, 2, 1, 1, 1, 2, 2}));
  }

  @Test
  @DisplayName("should remove duplicates")
  public void shouldRemoveDuplicates() {
    assertEquals(0, LeetCodeArrays.removeDuplicate(new int[]{}));
    assertEquals(2, LeetCodeArrays.removeDuplicate(new int[]{1, 1, 2}));
    assertEquals(5, LeetCodeArrays.removeDuplicate(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }

  @Test
  @DisplayName("should remove element from array")
  public void shouldRemoveElement() {
    assertEquals(0, LeetCodeArrays.removeElement(new int[]{}, 3));
    assertEquals(2, LeetCodeArrays.removeElement(new int[]{3, 2, 2, 3}, 3));
    assertEquals(5, LeetCodeArrays.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
  }
}
