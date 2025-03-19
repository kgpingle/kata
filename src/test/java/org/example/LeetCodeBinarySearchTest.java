package org.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LeetCodeBinarySearchTest {

  @Test
  @DisplayName("search 2D matrix")
  public void search2DMatrix() {
    assertFalse(LeetCodeBinarySearch.search2DMatrix(
        new int[][]{{1}, {2}}, 3));
    assertTrue(LeetCodeBinarySearch.search2DMatrix(
        new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    assertFalse(LeetCodeBinarySearch.search2DMatrix(
        new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
  }

  @Test
  @DisplayName("find min in rotated array")
  public void finMinInRotatedArray() {
    assertEquals(1, LeetCodeBinarySearch.finMinInRotatedArray(new int[]{3, 1, 2}));
    assertEquals(1, LeetCodeBinarySearch.finMinInRotatedArray(new int[]{3, 4, 5, 1, 2}));
    assertEquals(0, LeetCodeBinarySearch.finMinInRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}));
    assertEquals(11,
        LeetCodeBinarySearch.finMinInRotatedArray(new int[]{11, 13, 15, 17}));
  }

  @Test
  @DisplayName("Find first and last element position from sorted array")
  public void findFirstAndLastElementPositionFromSortedArray() {
    assertArrayEquals(new int[]{3, 4},
        LeetCodeBinarySearch.findFirstAndLastElementPositionFromSortedArray(
            new int[]{5, 7, 7, 8, 8, 10}, 8));
  }

  @Test
  @DisplayName("search in rotated array")
  public void searchInRotatedArray() {
    assertEquals(0, LeetCodeBinarySearch.searchInRotatedArray(new int[]{5, 1, 3}, 5));
    assertEquals(4, LeetCodeBinarySearch.searchInRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
  }

  @Test
  @DisplayName("search insert position")
  public void searchInsertPosition() {
    assertEquals(0, LeetCodeBinarySearch.searchInsertPosition(new int[]{1}, 1));
    assertEquals(2, LeetCodeBinarySearch.searchInsertPosition(new int[]{1, 3, 5, 6}, 5));
    assertEquals(1, LeetCodeBinarySearch.searchInsertPosition(new int[]{1, 3, 5, 6}, 2));
    assertEquals(4, LeetCodeBinarySearch.searchInsertPosition(new int[]{1, 3, 5, 6}, 7));
    assertEquals(0, LeetCodeBinarySearch.searchInsertPosition(new int[]{1, 3, 5, 6}, 0));
  }

}