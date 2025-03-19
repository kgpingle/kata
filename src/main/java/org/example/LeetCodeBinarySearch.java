package org.example;

public class LeetCodeBinarySearch {

  public static int searchInsertPosition(int[] nums, int target) {
    int start = 0, mid = 0, end = nums.length - 1;
    while (start <= end) {
      mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > target) {
        // move left
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }

  public static int searchInRotatedArray(int[] nums, int target) {
    int start = 0, end = nums.length - 1, mid = 0;
    while (start <= end) {
      mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // if left is sorted
      if (nums[start] <= nums[mid]) {
        if (target >= nums[start] && target < nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (target > nums[mid] && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }

  private static int findElement(int[] nums, int target, boolean findFirst) {
    int start = 0, end = nums.length - 1, mid = 0, result = -1;

    while (start <= end) {
      mid = (start + end) / 2;
      if (nums[mid] == target) {
        result = mid;
        if (findFirst) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else if (target > nums[mid]) {
        start = mid + 1;
      } else {
        end = end - 1;
      }
    }
    return result;
  }

  public static int[] findFirstAndLastElementPositionFromSortedArray(int[] nums, int target) {
    int firstPosition = findElement(nums, target, true);
    int lastPosition = findElement(nums, target, false);
    return new int[]{firstPosition, lastPosition};
  }

  public static int finMinInRotatedArray(int[] nums) {
    int start = 0, end = nums.length - 1;
    while (start < end) {
      int mid = (start + end) / 2;
      // left is sorted
      if (nums[end] < nums[mid]) {
        start = mid + 1;
      } else {
        // right is sorted
        end = mid;
      }
    }
    return nums[start];
  }

  public static boolean search2DMatrix(int[][] matrix, int target) {
    int start = 0, end = matrix.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      int[] midRow = matrix[mid];

      if (target >= midRow[0] && target <= midRow[midRow.length - 1]) {
        int element = findElement(midRow, target, true);
        return element != -1;
      } else if (target < midRow[0]) {
        end = mid - 1;
      } else if (target > midRow[midRow.length - 1]) {
        start = mid + 1;
      }
    }
    return false;
  }
}
