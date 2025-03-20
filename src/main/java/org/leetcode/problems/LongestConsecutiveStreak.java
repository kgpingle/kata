package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveStreak {

  public static int shouldFindLongestStreak(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int maxStreak = 0;
    Set<Integer> numbers = new HashSet<>();
    for (int num : nums) {
      numbers.add(num);
    }

    for (int num : numbers) {
      if (!numbers.contains(num - 1)) {
        int currentNum = num;
        int streak = 1;
        while (numbers.contains(currentNum + 1)) {
          streak++;
          currentNum++;
        }
        maxStreak = Math.max(maxStreak, streak);
      }

    }
    return maxStreak;
  }
}
