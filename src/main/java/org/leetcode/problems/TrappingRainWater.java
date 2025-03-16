package org.leetcode.problems;

public class TrappingRainWater {

  public static int trapRainWater(int[] height) {
    int totalWater = 0, left = 0, right = height.length - 1;
    int leftMax = height[left];
    int rightMax = height[right];
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          totalWater += leftMax - height[left];
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          totalWater += rightMax - height[right];
        }
        right--;
      }
    }
    return totalWater;
  }
}
