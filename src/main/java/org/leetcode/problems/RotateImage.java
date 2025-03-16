package org.leetcode.problems;

public class RotateImage {

  public static int[][] rotate(int[][] imageArray) {

    // transpose every row
    for (int row = 0; row < imageArray.length; row++) {
      for (int column = row; column < imageArray[row].length; column++) {
        int temp = imageArray[row][column];
        imageArray[row][column] = imageArray[column][row];
        imageArray[column][row] = temp;
      }
    }

    // swap every row
    for (int row = 0; row < imageArray.length; row++) {
      int start = 0;
      int end = imageArray[row].length - 1;
      while (start < end) {
        int temp = imageArray[row][start];
        imageArray[row][start] = imageArray[row][end];
        imageArray[row][end] = temp;
        start++;
        end--;
      }
    }

    return imageArray;
  }
}
