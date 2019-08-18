package com.maverickbyte.algo.leetcode.contest.wc0150;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N5052M_MaximumLevelSumOfABinaryTree {

  public int maxLevelSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    int level = 1, ans = 0, max = Integer.MIN_VALUE;
    while (!queue.isEmpty()) {
      int size = queue.size();
      int sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode p = queue.removeFirst();
        sum += p.val;
        if (p.left != null) {
          queue.addLast(p.left);
        }
        if (p.right != null) {
          queue.addLast(p.right);
        }
      }
      if (max < sum) {
        max = sum;
        ans = level;
      }
      level++;
    }
    return ans;
  }
}
