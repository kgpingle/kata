package org.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Approach BFS using a ArrayQueue
 */
public class BinaryTreeLevelOrderReversal {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public BinaryTreeLevelOrderReversal() {
  }


  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> bfsQueue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    bfsQueue.add(root);
    while (!bfsQueue.isEmpty()) {
      var levelSize = bfsQueue.size();
      var newLevel = new ArrayList<Integer>();
      for (int i = 0; i < levelSize; i++) {
        var node = bfsQueue.poll();
        newLevel.add(node.val);
        if (node.left != null) {
          bfsQueue.add(node.left);
        }
        if (node.right != null) {
          bfsQueue.add(node.right);
        }
      }
      result.add(newLevel);
    }
    return result;
  }
}
