package org.leetcode.arrays;

public class RemoveDuplicatesFromSortedArray {

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int uniquePointer = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[uniquePointer++] = nums[i];
      }
    }
    return uniquePointer;
  }


  public static int removeDuplicatesUpto2(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int uniquePointer = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] != nums[uniquePointer - 2]) {
        nums[uniquePointer++] = nums[i];
      }
    }
    return uniquePointer;
  }

}
