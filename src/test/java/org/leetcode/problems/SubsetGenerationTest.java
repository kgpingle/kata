package org.leetcode.problems;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubsetGenerationTest {

  @Test
  @DisplayName("should generate subset")
  public void shouldGenerateSubset() {
    List<List<Integer>> lists = SubsetGeneration.subsetBackTracking(new int[]{1, 2, 3});
    System.out.println("Output:");
    lists.stream().forEach(i -> System.out.println(Arrays.asList(i)));

  }
}