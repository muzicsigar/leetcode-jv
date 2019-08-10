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
public class N0094M_BinaryTreeInorderTraversal {


  /* =============================================================================================
      solution 1: recursive
     ============================================================================================= */
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    inorder0(root, ans);
    return ans;
  }

  private void inorder0(TreeNode root, List<Integer> visit) {
    if (root == null) {
      return;
    }
    inorder0(root.left, visit);
    visit.add(root.val);
    inorder0(root.right, visit);
  }

  private void inorder1(TreeNode root, List<Integer> visit) {
    if (root == null) {
      return;
    }
    if (root.left != null) { // dummy节点不访问，减少N次方法栈访问，N为节点总数
      inorder1(root.left, visit);
    }
    visit.add(root.val);
    if (root.right != null) {
      inorder1(root.right, visit);
    }
  }

  /* =============================================================================================
      solution 2: iterative with stack
     ============================================================================================= */
  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> visit = new ArrayList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      TreeNode leftOrParent = stack.pop();
      visit.add(leftOrParent.val);
      // 存的是下一个入栈的元素，在此之前，需要将 left，left.parent先出栈。root = root.right就是为了让left.parent出栈。
      root = leftOrParent.right;
    }
    return visit;
  }
}
