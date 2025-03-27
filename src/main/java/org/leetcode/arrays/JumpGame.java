package org.leetcode.arrays;

public class JumpGame {

  public static boolean canJump(int[] nums) {
    // 3,2,1,0,4
//    int index = nums.length - 2;
//    int nextStep = nums.length - 1;
//    if (index < 0) {
//      return true;
//    }
//    boolean canJump = false;
//    while (index >= 0) {
//      if ((index + nums[index]) >= nextStep) {
//        nextStep = index;
//        canJump = true;
//      } else {
//        canJump = false;
//      }
//      index--;
//    }
//    return canJump;

    int goal = nums.length - 1; // The last index we need to reach

    for (int i = nums.length - 2; i >= 0; i--) {
      if (i + nums[i] >= goal) {
        goal = i; // Update the goal to the current index
      }
    }

    return goal == 0; // Can we reach index 0?
  }

}
