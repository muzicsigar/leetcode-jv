package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0112E_PathSum {

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    backtrack(root, sum);
    return hasPathSum;
  }

  private boolean hasPathSum = false;

  private void backtrack(TreeNode root, int sum) {
    if ((hasPathSum || sum - root.val == 0 && root.left == null && root.right == null)) {
      hasPathSum = true;
      return;
    }
    /*if (sum - root.val < 0) { // sum is negative
      return;
    }*/
    if (root.left != null) {
      backtrack(root.left, sum - root.val);
    }
    if (root.right != null) {
      backtrack(root.right, sum - root.val);
    }
  }


  /* =============================================================================================
      solution 2: iterative
     ============================================================================================= */
  public boolean hasPathSum2(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    LinkedList<TreeNode> nodeStack = new LinkedList<>();
    LinkedList<Integer> sumStack = new LinkedList<>();
    nodeStack.push(root);
    sumStack.push(sum - root.val);
    while (!nodeStack.isEmpty()) {
      TreeNode p = nodeStack.pop();
      Integer rest = sumStack.pop();
      if(p.left == null && p.right == null && rest == 0) {
        return true;
      }
      if (p.left != null) {
        nodeStack.push(p.left);
        sumStack.push(rest - p.left.val);
      }
      if(p.right != null) {
        nodeStack.push(p.right);
        sumStack.push(rest - p.right.val);
      }
    }
    return false;
  }

}
