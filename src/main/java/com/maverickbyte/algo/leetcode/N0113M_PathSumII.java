package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0113M_PathSumII {

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> pre = new LinkedList<>();
    pre.add(root.val);
    backtrack(root, sum - root.val, pre, ans);
    return ans;
  }

  private void backtrack(TreeNode root, int sum, LinkedList<Integer> pre, List<List<Integer>> ans) {
    if (sum == 0 && root.left == null && root.right == null) {
      ans.add(new ArrayList<>(pre));
      return;
    }
    if (root.left != null) {
      pre.add(root.left.val);
      backtrack(root.left, sum - root.left.val, pre, ans);
      pre.removeLast();
    }
    if (root.right != null) {
      pre.add(root.right.val);
      backtrack(root.right, sum - root.right.val, pre, ans);
      pre.removeLast();
    }
  }


}
