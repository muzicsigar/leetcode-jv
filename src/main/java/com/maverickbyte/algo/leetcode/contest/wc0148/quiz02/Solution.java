package com.maverickbyte.algo.leetcode.contest.wc0148.quiz02;

import com.maverickbyte.algo.leetcode.util.TreeNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class Solution {


  /* =============================================================================================
       link: https://leetcode-cn.com/contest/weekly-contest-148/problems/binary-tree-coloring-game/
       warn: 测试用例最后一两个没通过
     ============================================================================================= */
  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    if (null == root || x > n) {
      throw new IllegalArgumentException();
    }
    if (n < 3) {
      return false;
    }
    TreeNode redStartNode = find(root, x);
    if (redStartNode.val == root.val) {
      int leftCount = count(root.left, 0);
      int rightCount = count(root.right, 0);
      return leftCount > rightCount + 1 || rightCount > leftCount + 1;
    } else {
      int redCount = count(redStartNode, 0);
      return redCount * 2 < n;
    }
  }

  private TreeNode find(TreeNode root, int x) {
    if (null == root) {
      return null;
    }
    if (x == root.val) {
      return root;
    }
    TreeNode left = find(root.left, x);
    if (left != null) {
      return left;
    }
    TreeNode right = find(root.right, x);
    if (right != null) {
      return right;
    }
    return null;
  }

  private int count(TreeNode root, int count) {
    if (null == root) {
      return count;
    }
    int total = 1;
    if (root.left != null) {
      total += count(root.left, count + 1);
    }
    if (root.right != null) {
      total += count(root.right, count + 1);
    }
    return total;
  }

}
