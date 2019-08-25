package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0041H_FirstMissingPositive {


  public int firstMissingPositive(int[] nums) {
    if (null == nums || nums.length == 0) {
      return 1;
    }
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      while (nums[i] - 1 >= 0 && nums[i] - 1 < len && i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      }
    }
    for (int i = 0; i < len; i++) {
      if (nums[i] - 1 != i) {
        return i + 1;
      }
    }
    return len + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
