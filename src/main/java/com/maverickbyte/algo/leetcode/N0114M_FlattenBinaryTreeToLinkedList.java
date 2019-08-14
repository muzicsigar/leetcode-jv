package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0114M_FlattenBinaryTreeToLinkedList {


  /* =============================================================================================
      solution 1: best
     ============================================================================================= */
  public void flatten1(TreeNode root) {
    while (root != null) {
      if (root.left == null) {
        root = root.right;
      } else {
        TreeNode p = root.left;
        while (p.right != null) {
          p = p.right;
        }
        p.right = root.right;
        root.right = root.left;
        root.left = null;
        root = root.right;
      }
    }
  }

  /* =============================================================================================
      solution 2
     ============================================================================================= */
  public void flatten2(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten2(root.right);
    flatten2(root.left);
    if(root.left != null) {
      TreeNode p = root.left;
      while (p.right != null) {
        p = p.right;
      }
      p.right = root.right;
      root.right = root.left;
      root.left = null;
    }
  }


  /* =============================================================================================
      solution 3
     ============================================================================================= */
  private TreeNode pre;
  public void flatten3(TreeNode root) {
    if(root == null) {
      return;
    }
    flatten3(root.right);
    flatten3(root.left);
    root.right = pre;
    root.left = null;
    pre = root;
  }



}
