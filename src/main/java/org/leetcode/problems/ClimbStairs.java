package org.leetcode.problems;

public class ClimbStairs {

  public static int climbStairs(int n) {
    int temp;
    int secondPrevStep = 0, firstPrevStep = 1;
    for (int i = 0; i < n; i++) {
      temp = secondPrevStep + firstPrevStep;
      secondPrevStep = firstPrevStep;
      firstPrevStep = temp;
    }
    return firstPrevStep;
  }

}
