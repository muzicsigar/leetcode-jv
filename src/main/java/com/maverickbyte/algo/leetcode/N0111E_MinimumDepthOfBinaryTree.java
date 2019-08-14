package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0111E_MinimumDepthOfBinaryTree {


  public int minDepth1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    LinkedList<TreeNode> deque = new LinkedList<>();
    deque.addLast(root);
    int depth = 1;
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode p = deque.removeFirst();
        if (p.left == null && p.right == null) {
          return depth;
        }
        if (p.left != null) {
          deque.addLast(p.left);
        }
        if (p.right != null) {
          deque.addLast(p.right);
        }
      }
      depth++;
    }
    throw new IllegalStateException();
  }


  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null) {
      return minDepth(root.right) + 1;
    }
    if (root.right == null) {
      return minDepth(root.left) + 1;
    }
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }

}
