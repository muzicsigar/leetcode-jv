package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0108E_ConvertSortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    return toBST(nums, 0, nums.length - 1);
  }

  private TreeNode toBST(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    // int mid = (left + right) >>> 1;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = toBST(nums, left, mid - 1);
    root.right = toBST(nums, mid + 1, right);
    return root;
  }
}
