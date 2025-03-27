package org.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

  Map<Integer, Integer> valueIndexMapping;
  List<Integer> values;


  public RandomizedSet() {
    valueIndexMapping = new HashMap<>();
    values = new ArrayList<>();
  }

  public boolean insert(int val) {
    if (valueIndexMapping.containsKey(val)) {
      return false;
    }
    valueIndexMapping.put(val, values.size());
    values.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!valueIndexMapping.containsKey(val)) {
      return false;
    }

    int index = valueIndexMapping.get(val); // Get index of val
    int lastElement = values.get(values.size() - 1); // Get last element

    // Swap current element with the last element
    values.set(index, lastElement);
    valueIndexMapping.put(lastElement, index); // Update index of last element in map

    // Remove last element from list and map
    values.remove(values.size() - 1);
    valueIndexMapping.remove(val);
    return true;
  }

  public int getRandom() {
    Random random = new Random();
    return values.get(random.nextInt(0, values.size()));
  }

  public static void main(String[] args) {
    List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
    Random random = new Random();

    for (int i = 0; i < 5; i++) {
      System.out.println("Check : " + random.nextInt(integers.size()));
    }
  }

}
