package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0098M_ValidateBinarySearchTree {

  /* =============================================================================================
      solution 1
     ============================================================================================= */
  public boolean isValidBST1(TreeNode root) {
    if (null == root) {
      return true;
    }
    if (root.left != null) {
      TreeNode leftMax = root.left;
      while (leftMax.right != null) {
        leftMax = leftMax.right;
      }
      if (leftMax.val >= root.val) {
        return false;
      }
    }
    if (root.right != null) {
      TreeNode rightMin = root.right;
      while (rightMin.left != null) {
        rightMin = rightMin.left;
      }
      if (rightMin.val <= root.val) {
        return false;
      }
    }
    return isValidBST1(root.left) && isValidBST1(root.right);
  }


  /* =============================================================================================
      solution 2: inorder traversal
     ============================================================================================= */
  private TreeNode pre;

  public boolean isValidBST2(TreeNode root) {
    if (null == root) {
      return true;
    }
    if (!isValidBST2(root.left)) {
      return false;
    }
    if (pre != null && pre.val >= root.val) {
      return false;
    }
    pre = root;
    return isValidBST2(root.right);
  }


  /* =============================================================================================
      solution 3
     ============================================================================================= */
  public boolean isValidBST3(TreeNode root) {
    return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }

  public boolean isValid(TreeNode root, long upper, long lower) {
    if (root == null) {
      return true;
    }
    if (root.val >= upper || root.val <= lower) {
      return false;
    }
    if (!isValid(root.left, root.val, lower)) {
      return false;
    }
    if (!isValid(root.right, upper, root.val)) {
      return false;
    }
    return true;
  }


}
