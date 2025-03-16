package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LeetCodeMultiDimensionalDpTest {

  @Test
  @DisplayName("min path triangle")
  public void minPathTriangle() {
    // [[2],[3,4],[6,5,7],[4,1,8,3]]
    assertEquals(11, LeetCodeMultiDimensionalDp.minPathTriangle(
        List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
    assertEquals(-10, LeetCodeMultiDimensionalDp.minPathTriangle(
        List.of(List.of(-10))));
  }

}
