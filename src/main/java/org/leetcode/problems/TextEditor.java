package org.leetcode.problems;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class TextEditor {

  Deque<Character> leftStack = new LinkedList<>();
  Deque<Character> rightStack = new LinkedList<>();

  public void addText(String text) {
    for (char c : text.toCharArray()) {
      leftStack.push(c);
    }
  }

  public int deleteText(int k) {
    int count = 0;
    while (!leftStack.isEmpty() && count < k) {
      leftStack.pop();
      count++;
    }
    return count;
  }

  public String cursorLeft(int k) {
    int count = 0;
    while (!leftStack.isEmpty() && count < k) {
      rightStack.push(leftStack.pop());
      count++;
    }
    return getLast10Chars();
  }

  public String cursorRight(int k) {
    int count = 0;
    while (!rightStack.isEmpty() && count < k) {
      leftStack.push(rightStack.pop());
      count++;
    }
    return getLast10Chars();
  }

  private String getLast10Chars() {
    StringBuilder sb = new StringBuilder();
    Iterator<Character> iter = leftStack.iterator();
    while (sb.length() < 10 && iter.hasNext()) {
      sb.insert(0, iter.next()); // Insert at start to maintain order
    }
    return sb.toString();
  }

}
