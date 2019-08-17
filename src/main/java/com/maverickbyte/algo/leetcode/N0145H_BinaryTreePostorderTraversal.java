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
public class N0145H_BinaryTreePostorderTraversal {

  /* =============================== recursive version ==================================*/
  public List<Integer> postorderTraversal1(TreeNode root) {
    if (null == root) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    postorder(root, ans);
    return ans;
  }

  private void postorder(TreeNode root, List<Integer> ans) {
    if (null == root) {
      return;
    }
    postorder(root.left, ans);
    postorder(root.right, ans);
    ans.add(root.val);
  }

  /* =============================== iteration version ==================================*/
  // https://www.jianshu.com/p/6a1c47b5ac49
  public List<Integer> postorderTraversal2(TreeNode root) {
    if (null == root) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode prev  = null;
    while (null != root || !stack.isEmpty()) {
      if(null != root) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.peek();
        if(root.right != null && root.right != prev ) { //
          root = root.right;
        } else {
          stack.pop();
          ans.add(root.val);
          prev  = root;
          root = null;
        }
      }
    }
    return ans;
  }
}
