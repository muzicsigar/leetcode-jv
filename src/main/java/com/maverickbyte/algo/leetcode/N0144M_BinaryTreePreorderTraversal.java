package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0144M_BinaryTreePreorderTraversal {

  /* =============================================================================================
      solution 1: recursion
     ============================================================================================= */
  public List<Integer> preorderTraversal1(TreeNode root) {
    if (null == root) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    preorder(root, ans);
    return ans;
  }

  private void preorder(TreeNode root, List<Integer> ans) {
    if (null == root) {
      return;
    }
    ans.add(root.val);
    preorder(root.left, ans);
    preorder(root.right, ans);
  }

  /* =============================================================================================
      solution 2: iteration with stack
     ============================================================================================= */
  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> visit = new ArrayList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode p = root;
    while (null != p || !stack.isEmpty()) {
      while (null != p) {
        visit.add(p.val);
        stack.push(p);
        p = p.left;
      }
      p = stack.pop().right;
    }
    return visit;
  }

  /* =============================================================================================
      solution 3: morris
     ============================================================================================= */
  public List<Integer> preorderTraversal3(TreeNode root) {
    // TODO
    return null;
  }


}
