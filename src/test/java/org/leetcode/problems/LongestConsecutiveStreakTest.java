package org.leetcode.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LongestConsecutiveStreakTest {

  @Test
  @DisplayName("should find longest consecutive streak")
  public void shouldFindLongestStreak() {
    assertEquals(4,
        LongestConsecutiveStreak.shouldFindLongestStreak(new int[]{100, 4, 200, 1, 3, 2}));
    assertEquals(9,
        LongestConsecutiveStreak.shouldFindLongestStreak(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    assertEquals(3,
        LongestConsecutiveStreak.shouldFindLongestStreak(new int[]{1, 0, 1, 2}));
  }

}