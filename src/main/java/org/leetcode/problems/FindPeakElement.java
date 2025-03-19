package org.leetcode.problems;

public class FindPeakElement {


  public static int findPeakElement(int[] nums) {
    int start = 0, mid = 0, end = nums.length - 1;
    // 6, 6, 6
    while (start < end) {
      // find mid
      mid = (start + end) / 2;
      int left = mid - 1 > start ? nums[mid - 1] : nums[start];
      int right = mid + 1 < end ? nums[mid + 1] : nums[end];
      if (nums[mid] <= right) {
        // move right
        start = mid + 1;
      } else if (nums[mid] <= left) {
        // move left
        end = mid - 1;
      } else {
        return mid;
      }
    }
    return start == end ? start : mid;
  }
}
