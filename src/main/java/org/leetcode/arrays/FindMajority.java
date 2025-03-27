package org.leetcode.arrays;

public class FindMajority {

  public static int majorityElement(int[] nums) {
    int count = 0;
    int candidate = nums[0];

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += candidate == num ? 1 : -1;
    }
    return candidate;
  }

}
