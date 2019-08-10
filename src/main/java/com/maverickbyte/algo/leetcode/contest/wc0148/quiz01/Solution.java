package com.maverickbyte.algo.leetcode.contest.wc0148.quiz01;

/**
 * @author Alan Li
 * @since 1.0
 */
public class Solution {


  /* =============================================================================================
       quiz: https://leetcode-cn.com/contest/weekly-contest-148/problems/decrease-elements-to-make-array-zigzag/
       difficulty: easy
     ============================================================================================= */
  public int movesToMakeZigzag(int[] nums) {
    if (null == nums || nums.length <= 1) {
      return 0;
    }
    int odd = 0;
    int even = 0;
    // let odd elem > even elem, count even ops.
    for (int i = 0; i < nums.length; i += 2) {
      if (i - 1 >= 0 && i + 1 < nums.length) {
        int min = Math.min(nums[i - 1], nums[i + 1]);
        if (min <= nums[i]) {
          even += nums[i] - min + 1;
        }
      } else if (i - 1 < 0) {
        if (nums[i] >= nums[i + 1]) {
          even += nums[i] - nums[i + 1] + 1;
        }
      } else {
        if (nums[i] >= nums[i - 1]) {
          even += nums[i] - nums[i - 1] + 1;
        }
      }
    }
    // let even elem > odd elem, count odd ops.
    for (int i = 1; i < nums.length; i += 2) {
      if (i - 1 >= 0 && i + 1 < nums.length) {
        int min = Math.min(nums[i - 1], nums[i + 1]);
        if (min <= nums[i]) {
          odd += nums[i] - min + 1;
        }
      } else if (i - 1 < 0) {
        if (nums[i] >= nums[i + 1]) {
          odd += nums[i] - nums[i + 1] + 1;
        }
      } else {
        if (nums[i] >= nums[i - 1]) {
          odd += nums[i] - nums[i - 1] + 1;
        }
      }
    }
    return Math.min(odd, even);
  }
}
