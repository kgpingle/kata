package org.example;

import java.util.List;

public class LeetCodeMultiDimensionalDp {

  public static int minPathTriangle(List<List<Integer>> triangle) {
    int minPath = 0;
    int index = 0;
    for (int i = 0; i < triangle.size(); i++) {
      List<Integer> integers = triangle.get(i);
      if (integers.size() > (index + 1)) {
        if (integers.get(index) < integers.get(index + 1)) {
          minPath += integers.get(index);
        } else {
          minPath += integers.get(index + 1);
        }
      } else {
        minPath += integers.get(i);
        index = i;
      }
    }
    return minPath;
  }
}
