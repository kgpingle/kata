package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LeetCodeArrays {

  public static String numericToRoman(int num) {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    String roman = "";
    for (int i = 0; i < values.length; i++) {
      while (num >= values[i]) {
        num -= values[i];
        roman += symbols[i];
      }
    }
    return roman;
  }

  public static int removeElement(int[] nums, int val) {
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[index] = nums[i];
        index++;
      }
    }
    return index;
  }

  public static int removeDuplicate(int[] nums) {
    int uniqueIndex = 0;
    if (nums.length == 0) {
      return 0;
    }
    for (int i = 1; i < nums.length; i++) {
      if (nums[uniqueIndex] != nums[i]) {
        uniqueIndex++;
        nums[uniqueIndex] = nums[i];
      }
    }
    return uniqueIndex + 1;
  }

  public static int findMajority(int[] nums) {
    int count = 0;
    int candidate = 0;
    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (candidate == num) ? 1 : -1;
    }
    return candidate;
  }

  public static int[] mergeArrays(int[] nums1, int m, int[] nums2, int n) {
    int[] mergedArray = new int[nums1.length];
    int i = 0, j = 0, k = 0;
    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        mergedArray[k++] = nums1[i++];
      } else {
        mergedArray[k++] = nums2[j++];
      }
    }
    while (i < m) {
      mergedArray[k++] = nums1[i++];
    }
    while (j < n) {
      mergedArray[k++] = nums2[j++];
    }
    i = 0;
    while (i < nums1.length) {
      nums1[i] = mergedArray[i];
      i++;
    }
    return nums1;
  }

  /// / Todo from here.
  public static int maximizeStockProfit(int[] prices) {
    int profit = 0, minIndex = 0, maxIndex = 0;
    if (prices.length == 0) {
      return 0;
    }
    for (int i = 0; i < prices.length; i++) {
      if (prices[minIndex] > prices[i]) {
        profit = Math.max(profit, prices[maxIndex] - prices[minIndex]);
        minIndex = i;
        maxIndex = i;
      }
      if (prices[maxIndex] < prices[i]) {
        maxIndex = i;
      }
    }
    return Math.max(profit, prices[maxIndex] - prices[minIndex]);
  }

  public static int romanToNumeral(String roman) {
    if (roman.isBlank()) {
      return 0;
    }
    Map<String, Integer> romanNumericMapping = new HashMap();
    romanNumericMapping.put("I", 1);
    romanNumericMapping.put("V", 5);
    romanNumericMapping.put("X", 10);
    romanNumericMapping.put("L", 50);
    romanNumericMapping.put("C", 100);
    romanNumericMapping.put("D", 500);
    romanNumericMapping.put("M", 1000);
    int numeric = 0;

    int romanStringLength = roman.toCharArray().length;
    for (int i = 0; i < romanStringLength; i++) {
      int valueForNextChar = -1;
      int valueForCurrentChar = romanNumericMapping.get(String.valueOf(roman.charAt(i)));
      if ((i + 1) < romanStringLength) {
        valueForNextChar = romanNumericMapping.get(String.valueOf(roman.charAt(i + 1)));
      }
      if (valueForNextChar > valueForCurrentChar) {
        numeric -= valueForCurrentChar;
      } else {
        numeric += valueForCurrentChar;
      }
    }
    return numeric;
  }

  public static int lengthOfLastWord(String s) {
    String[] split = s.split(" ");
    for (int i = split.length - 1; i >= 0; i--) {
      if (!Objects.equals(split[i], "")) {
        return split[i].length();
      }
    }
    return 0;
  }

  public static String longestCommonPrefix(String[] strs) {
    int index = 0;
    String prefix = "";
    String firstString = strs[0];
    if (firstString.isBlank()) {
      return prefix;
    }
    while (index < firstString.length()) {
      prefix += firstString.charAt(index);
      for (int i = 1; i < strs.length; i++) {
        if (!strs[i].startsWith(prefix)) {
          prefix = prefix.substring(0, index);
          return prefix;
        }
      }
      index++;
    }
    return prefix;
  }

  public static int firstOccurenceInAString(String haystack, String needle) {
    if (needle.length() > haystack.length()) {
      return -1;
    }
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      boolean matchFound = true;
      for (int j = 0; j < needle.length(); j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          matchFound = false;
          break; // Exit early if characters don't match
        }
      }
      // If match is found, return the starting index
      if (matchFound) {
        return i;
      }
    }
    return -1;
  }

  public static int removeDuplicateUptoTwoOccurence(int[] nums) {
    int allowedOccurences = 2;
    if (nums.length <= allowedOccurences) {
      return nums.length; // If array has at most 2 elements, return its length
    }

    int uniqueIndex = allowedOccurences; // Start from index 2 since the first two elements are always valid

    for (int j = allowedOccurences; j < nums.length; j++) {
      // If the current element is not the same as the element at i-2, it's allowed
      if (nums[j] != nums[uniqueIndex - allowedOccurences]) {
        nums[uniqueIndex] = nums[j];
        uniqueIndex++; // Move the pointer forward
      }
    }

    return uniqueIndex; // The new length of the array
  }

  public static int bestTimeToBuyAndSellStock(int[] prices) {
    List<Integer> profits = new ArrayList<>();
    int minIndex = 0, maxIndex = 0;
    // 7,1,5,3,6,4
    for (int i = 0; i < prices.length; i++) {
      if (prices[minIndex] > prices[i] || prices[maxIndex] > prices[i]) {
        profits.add(prices[maxIndex] - prices[minIndex]);
        minIndex = i;
        maxIndex = i;
      }
      if (prices[maxIndex] < prices[i]) {
        maxIndex = i;
      }
    }
    return profits.stream().mapToInt(Integer::intValue).sum() + prices[maxIndex] - prices[minIndex];
  }

  public static int rotateAnArray(int[] nums, int k) {
    int length = nums.length;
    k = k % length;

    reverse(nums, 0, length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, length - 1);

    return k;
  }

  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }


  public static String reverseWordsInAString(String s) {
    String[] split = s.split(" ");
    int length = split.length;
    reverse(split, 0, length - 1);
    StringBuilder sb = new StringBuilder();
    for (String s1 : split) {
      if (s1 == "") {
        continue;
      }
      sb.append(s1).append(" ");
    }
    return sb.toString().trim();
  }

  private static void reverse(String[] s, int start, int end) {
    while (start < end) {
      String temp = s[start].trim();
      s[start] = s[end].trim();
      s[end] = temp;
      start++;
      end--;
    }
  }

  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int index = 0;

    while (index < words.length) {
      int lineStart = index;
      int lineLength = words[index].length();
      index++;

      while (index < words.length
          && (lineLength + words[index].length() + index - lineStart) <= maxWidth) {
        lineLength += words[index].length();
        index++;
      }

      int numOfWords = index - lineStart;
      int totalSpaces = maxWidth - lineLength;
      StringBuilder line = new StringBuilder();

      if (index == words.length || numOfWords == 1) {
        for (int i = lineStart; i < index; i++) {
          line.append(words[i]);
          if (i < index - 1) {
            line.append(" ");
          }
        }
        while (line.length() < maxWidth) {
          line.append(" ");
        }
      } else {
        int spacesSlot = numOfWords - 1;
        int spacesPerSlot = totalSpaces / spacesSlot;
        int extraSpaces = totalSpaces % spacesSlot;

        for (int i = lineStart; i < index; i++) {
          line.append(words[i]);
          if (i < index - 1) {
            int spacesToAdd = spacesPerSlot + (extraSpaces-- > 0 ? 1 : 0);
            for (int s = 0; s < spacesToAdd; s++) {
              line.append(" ");
            }
          }

        }
      }
      result.add(line.toString());

    }
    return result;
  }
}
