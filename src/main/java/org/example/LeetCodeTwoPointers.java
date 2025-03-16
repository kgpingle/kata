package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeTwoPointers {

  public static boolean validPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      while (left < right
          && !Character.isAlphabetic(s.charAt(left))
          && !Character.isDigit(s.charAt(left))) {
        left++;
      }
      while (left < right
          && !Character.isAlphabetic(s.charAt(right))
          && !Character.isDigit(s.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static boolean isSubsequence(String s, String t) {
    if (s.length() > t.length()) {
      return false;
    }
    int sIndex = 0, tIndex = 0;
    while (sIndex < s.length() && tIndex < t.length()) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
      }
      tIndex++;
    }
    if (sIndex == s.length()) {
      return true;
    }
    return false;
  }

  public static int[] sumII(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (numbers[left] + numbers[right] != target && right > left) {
      if (numbers[left] + numbers[right] > target) {
        right--;
      } else {
        left++;
      }
    }
    return new int[]{left + 1, right + 1};
  }

  public static int maxArea(int[] height) {
    int l = 0, r = height.length - 1;
    int area = 0;
    while (l < r) {
      int minheight = Math.min(height[l], height[r]);
      area = Math.max(area, minheight * (r - l));

      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return area;
  }

  public static List<List<Integer>> findSumOfThree(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // Step 1: Sort the array

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue; // Skip duplicate elements
      }

      int l = i + 1, r = nums.length - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];

        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[l], nums[r]));

          // Skip duplicate values for 'l' and 'r'
          while (l < r && nums[l] == nums[l + 1]) {
            l++;
          }
          while (l < r && nums[r] == nums[r - 1]) {
            r--;
          }
          l++;
          r--; // Move pointers inward
        } else if (sum < 0) {
          l++; // Need a bigger sum
        } else {
          r--; // Need a smaller sum
        }
      }
    }

    return result;
  }
}
