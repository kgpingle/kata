package org.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class SubsetGeneration {

  public static List<List<Integer>> subsetBackTracking(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    generateSubset(0, nums, new ArrayList<>(), result);
    return result;
  }

  private static void generateSubset(int index, int[] nums, List<Integer> current,
      List<List<Integer>> result) {
    result.add(new ArrayList<>(current));

    for (int i = index; i < nums.length; i++) {
      current.add(nums[i]);
      generateSubset(i + 1, nums, current, result);
      current.removeLast();
    }
  }

}
