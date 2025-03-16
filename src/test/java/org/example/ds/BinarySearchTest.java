package org.example.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

  @Test
  @DisplayName("search number")
  public void searchNum() {
    assertEquals(0, BinarySearch.search(new int[]{1, 2, 3, 4, 5}, 1));
    assertEquals(4, BinarySearch.search(new int[]{1, 2, 3, 4, 5}, 5));
    assertEquals(3, BinarySearch.search(new int[]{1, 2, 3, 4, 5}, 4));
    assertEquals(-1, BinarySearch.search(new int[]{1, 2, 3, 4, 5}, 14));
  }

}