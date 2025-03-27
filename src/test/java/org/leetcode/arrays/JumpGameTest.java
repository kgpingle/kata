package org.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JumpGameTest {

  @Test
  void canJump() {
    assertEquals(true, JumpGame.canJump(new int[]{1, 2, 0, 1}));
    assertEquals(true, JumpGame.canJump(new int[]{0}));
    assertEquals(true, JumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
    assertEquals(false, JumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
  }
}