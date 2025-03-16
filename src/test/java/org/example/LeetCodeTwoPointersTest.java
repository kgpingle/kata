package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LeetCodeTwoPointersTest {

  @Test
  @DisplayName("find max area of water")
  public void maxAreaWater() {
    assertEquals(49, LeetCodeTwoPointers.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    assertEquals(1, LeetCodeTwoPointers.maxArea(new int[]{1, 1}));
  }

  @Test
  @DisplayName("find sum of three")
  public void findSumOfThree() {
    LeetCodeTwoPointers.findSumOfThree(new int[]{-1, 0, 1, 2, -1, -4});
  }

  @Test
  @DisplayName("find sum II")
  public void findSumII() {

    int[] nums = LeetCodeTwoPointers.sumII(new int[]{2, 7, 11, 15}, 9);
    int[] expectedNums = {1, 2};
    for (int i = 0; i < nums.length; i++) {
      assertEquals(expectedNums[i], nums[i]);
    }
    nums = LeetCodeTwoPointers.sumII(new int[]{2, 3, 4}, 6);
    expectedNums = new int[]{1, 3};
    for (int i = 0; i < nums.length; i++) {
      assertEquals(expectedNums[i], nums[i]);
    }
    nums = LeetCodeTwoPointers.sumII(new int[]{-1, 0}, -1);
    expectedNums = new int[]{1, 2};
    for (int i = 0; i < nums.length; i++) {
      assertEquals(expectedNums[i], nums[i]);
    }
  }

  @Test
  @DisplayName("is valid sub sequence")
  public void isSubsequence() {
    assertEquals(true, LeetCodeTwoPointers.isSubsequence("abc", "ahbgdc"));
    assertEquals(false, LeetCodeTwoPointers.isSubsequence("axc", "ahbgdc"));
  }

  @Test
  @DisplayName("should be valid palindrome")
  public void validPalindrome() {
    assertEquals(false, LeetCodeTwoPointers.validPalindrome("0P"));
    assertEquals(true, LeetCodeTwoPointers.validPalindrome(""));
    assertEquals(true, LeetCodeTwoPointers.validPalindrome("A man, a plan, a canal: Panama"));
    assertEquals(false, LeetCodeTwoPointers.validPalindrome("race a car"));
  }
}
