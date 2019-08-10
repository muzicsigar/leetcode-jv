package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0144M_BinaryTreePreorderTraversal {

  /* =============================== recursive version ==================================*/
  public List<Integer> preorderTraversal1(TreeNode root) {
    if (null == root) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    preorder(root, ans);
    return ans;
  }

  private void preorder(TreeNode root, List<Integer> ans) {
    // base case
    if (null == root) {
      return;
    }
    // making progress
    ans.add(root.val);
    preorder(root.left, ans);
    preorder(root.right, ans);
  }

  /* =============================== iteration version ==================================*/
  public List<Integer> preorderTraversal2(TreeNode root) {
    if(null == root) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (null != root || !stack.isEmpty()) {
      while (null != root) {
        ans.add(root.val);
        stack.push(root);
        root = root.left;
      }
      if(!stack.isEmpty()) {
        root = stack.pop();
        root = root.right;
      }
    }
    return ans;
  }


}
