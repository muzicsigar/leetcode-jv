package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0034M_FindFirstAndLastPositionOfElementInSortedArray {

  public int[] searchRange(int[] nums, int target) {
    int[] ans = new int[]{-1, -1};
    if (nums == null || nums.length == 0) {
      return ans;
    }

    // left bound
    int left = 0;
    int right = nums.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (left != nums.length) {
      ans[0] = nums[left] == target ? left : -1;
    }

    // right bound
    left = 0;
    right = nums.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    if (left != 0) {
      ans[1] = nums[left - 1] == target ? left - 1 : -1;
    }

    return ans;
  }
}
