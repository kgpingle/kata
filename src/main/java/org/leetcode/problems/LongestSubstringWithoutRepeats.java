package org.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestSubstringWithoutRepeats {

  public static String findSubString(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }
    Set<Character> uniqueChars = new HashSet<>();
    int start = 0, end = 0, maxStart = 0, maxLength = 0;

    while (end < s.length()) {
      char c = s.charAt(end);
      while (uniqueChars.contains(c)) {
        uniqueChars.remove(s.charAt(start));
        start++;
      }
      uniqueChars.add(c);
      if (end - start + 1 > maxLength) {
        maxLength = end - start + 1;
        maxStart = start;
      }
      end++;
    }
    return s.substring(maxStart, maxStart + maxLength);
  }

  /**
   * Returns All Longest Unique Substrings:
   * <p>
   * Maintains multiple substrings of the same max length. Handles Real-Time Streaming Input:
   * <p>
   * Uses LinkedHashMap to maintain insertion order efficiently. Supports Unicode Characters:
   * <p>
   * Works with non-ASCII characters, e.g., 💡🔥💡a💡. Finds the k-th Longest Unique Substring:
   * <p>
   * Uses MinHeap (PriorityQueue) to track the k-th longest substring.
   */
  public static List<String> findAllLongestSubstrings(String s, int k) {
    if (s == null || s.isEmpty()) {
      return Collections.emptyList();
    }

    Map<Character, Integer> charIndexMap = new LinkedHashMap<>();
    int start = 0, maxLen = 0;
    List<String> longestSubstrings = new ArrayList<>();
    PriorityQueue<String> minHeap = new PriorityQueue<>(Comparator.comparingInt(String::length));

    for (int end = 0; end < s.length(); end++) {
      char c = s.charAt(end);
      while (charIndexMap.containsKey(c)) {
        start = Math.max(start, charIndexMap.get(c) + 1);
        charIndexMap.remove(c);
      }
      charIndexMap.put(c, end);
      int currentLen = end - start + 1;

      if (currentLen > maxLen) {
        maxLen = currentLen;
        longestSubstrings.clear();
        longestSubstrings.add(s.substring(start, end + 1));
      } else if (currentLen == maxLen) {
        longestSubstrings.add(s.substring(start, end + 1));
      }

      if (minHeap.size() < k) {
        minHeap.offer(s.substring(start, end + 1));
      } else if (minHeap.peek().length() < currentLen) {
        minHeap.poll();
        minHeap.offer(s.substring(start, end + 1));
      }
    }

    System.out.println("K-th longest substring: " + (minHeap.isEmpty() ? "N/A" : minHeap.poll()));
    return longestSubstrings;
  }
}


