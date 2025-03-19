package org.leetcode.problems;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.leetcode.problems.BinaryTreeLevelOrderReversal.TreeNode;

class BinaryTreeLevelOrderReversalTest {

  @Test
  @DisplayName("should bfs a binary tree")
  public void shouldBfsABinaryTree() {
    BinaryTreeLevelOrderReversal orderReversal = new BinaryTreeLevelOrderReversal();
    // [1,2,3,4,null,null,5]
    TreeNode treeNodeFor4 = new TreeNode(4);
    TreeNode treeNodeFor5 = new TreeNode(5);
    TreeNode treeNodeFor2 = new TreeNode(2, treeNodeFor4, null);
    TreeNode treeNodeFor3 = new TreeNode(3, null, treeNodeFor5);
    TreeNode treeNodeFor1 = new TreeNode(1, treeNodeFor2, treeNodeFor3);
    List<List<Integer>> actual = orderReversal.levelOrder(treeNodeFor1);
    List<List<Integer>> expected = List.of(List.of(1), List.of(2, 3), List.of(4, 5));

    for (int i = 0; i < expected.size(); i++) {
      assertArrayEquals(expected.get(i).toArray(), actual.get(i).toArray());
    }

  }

}