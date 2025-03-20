package org.leetcode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidAnagram {

  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> charCountCheck = new HashMap<>();
    for (char c : s.toCharArray()) {
      var aDefault = charCountCheck.getOrDefault(c, 0);
      charCountCheck.put(c, aDefault + 1);
    }
    for (char c : t.toCharArray()) {
      Integer i = charCountCheck.get(c);
      if (i == null || i == 0) {
        return false;
      }
      charCountCheck.put(c, i - 1);
    }
    List<Integer> list = charCountCheck.values().stream().distinct().toList();
    return list.size() == 1 && list.getFirst() == 0;
  }
}
