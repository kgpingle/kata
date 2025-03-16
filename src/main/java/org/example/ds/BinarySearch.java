package org.example.ds;

public class BinarySearch {

  public static int search(int[] nums, int val) {
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == val) {
        return mid;
      }
      if (nums[mid] < val) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

}
