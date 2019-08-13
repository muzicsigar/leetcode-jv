package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0099H_RecoverBinarySearchTree {

  /* =============================================================================================
      solution 1: recursive
     ============================================================================================= */
  public void recoverTree1(TreeNode root) {
    inorder(root);
    int tmp = first.val;
    first.val = second.val;
    second.val = tmp;
  }

  private TreeNode first;
  private TreeNode second;
  private TreeNode pre;

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    if (pre != null && first == null && pre.val >= root.val) {
      first = pre;
    }
    if (pre != null && first != null && pre.val >= root.val) {
      second = root;
    }
    pre = root;
    inorder(root.right);
  }


  /* =============================================================================================
      solution 2: iteration stack
     ============================================================================================= */
  public void recoverTree2(TreeNode root) {
    if (root == null || root.left == null && root.right == null) {
      return;
    }
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;
    LinkedList<TreeNode> stack = new LinkedList<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      TreeNode leftOrParent = stack.pop();
      if (pre != null && first == null && pre.val >= leftOrParent.val) {
        first = pre;
      }
      if (pre != null && first != null && pre.val >= leftOrParent.val) {
        second = leftOrParent;
      }
      pre = leftOrParent;
      root = leftOrParent.right;
    }
    int tmp = first.val;
    first.val = second.val;
    second.val = tmp;
  }

}
