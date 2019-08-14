package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0124H_BinaryTreeMaximumPathSum {

  public int maxPathSum(TreeNode root) {
    int rootVal = root.val;
    if (root.left == null && root.right == null) {
      return rootVal;
    }
    if (root.left == null) {
      int right = maxPathSum(root.right);
      int rootRight = right + rootVal;
      int all = right + rootVal;
      return Math.max(right, Math.max(rootVal, Math.max(rootRight, all)));
    }
    if (root.right == null) {
      int left = maxPathSum(root.left);
      int rootLeft = left + rootVal;
      int all = left + rootVal;
      return Math.max(left, Math.max(rootVal, Math.max(rootLeft, all)));
    }
    int right = maxPathSum(root.right);
    int left = maxPathSum(root.left);
    int rootRight = right + rootVal;
    int rootLeft = left + rootVal;
    int all = left + right + rootVal;
    return Math.max(left, Math.max(right, Math.max(rootVal, Math.max(rootLeft, Math.max(rootRight, all)))));
  }

}
