package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0035E_SearchInsertPosition {


  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int left = 0;
    int right = nums.length;

    while (left < right) { // 注意最后有个元素没有比较
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      }
    }
    if (left == nums.length) {
      return left;
    }

    // as left < right, so left == right is not compared with target. fix it
    return nums[left] >= target ? left : left + 1;
  }
}
