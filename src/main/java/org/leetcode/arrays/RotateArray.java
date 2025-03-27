package org.leetcode.arrays;

public class RotateArray {

  public static int[] rotate(int[] nums, int k) {
    k = k % nums.length;
    // reverse 0 - length -
    // reverse 0 - k-1
    // reverse k - length-1
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
    return nums;
  }

  public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }


}
