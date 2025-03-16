package org.example;

public class LeetCodeHashMap {

  public static boolean checkRansomNote(String ransomNote, String magazine) {
    int[] freq = new int[26]; // Stores letter counts for 'a' to 'z'

    // Count occurrences of each character in magazine
    for (char ch : magazine.toCharArray()) {
      freq[ch - 'a']++;
    }

    // Check if ransomNote can be formed
    for (char ch : ransomNote.toCharArray()) {
      if (--freq[ch - 'a'] < 0) {
        return false; // If a letter is unavailable, return false
      }
    }

    return true;
  }
}
