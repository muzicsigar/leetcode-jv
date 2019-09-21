package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0000X_Practice {


  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left == 0 ? 0 : nums[left - 1] == target ? left - 1 : left;
  }
}



