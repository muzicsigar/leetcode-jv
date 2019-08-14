package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0173M_BinarySearchTreeIterator {

}

class BSTIterator {

  private LinkedList<TreeNode> stack = new LinkedList<>();

  public BSTIterator(TreeNode root) {
    while (root !=null) {
      stack.push(root);
      root = root.left;
    }
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    TreeNode p = stack.pop();
    TreeNode right = p.right;
    while (right != null){
      stack.push(right);
      right = right.left;
    }
    return p.val;
  }

  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}
