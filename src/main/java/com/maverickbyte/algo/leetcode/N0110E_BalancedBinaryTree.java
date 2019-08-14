package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0110E_BalancedBinaryTree {


  /* =============================================================================================
      solution 1:
     ============================================================================================= */
  public boolean isBalanced(TreeNode root) {
    height(root);
    return isBalanced;
  }

  private boolean isBalanced = true;
  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);
    if(Math.abs(left - right) > 1) {
      this.isBalanced = false;
    }
    return Math.max(left + 1, right + 1);

  }


}