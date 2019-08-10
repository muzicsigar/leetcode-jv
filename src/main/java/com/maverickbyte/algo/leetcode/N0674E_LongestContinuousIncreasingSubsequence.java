package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0674E_LongestContinuousIncreasingSubsequence {


  public int findLengthOfLCIS(int[] nums) {
    if (null == nums || nums.length == 0) {
      return 0;
    }

    int ans = 1;
    int count = 1;
    int i = 1;
    while (i < nums.length) {
      if (nums[i] > nums[i - 1]) {
        count++;
      } else {
        ans = Math.max(ans, count);
        count = 1;
      }
      i++;
    }
    //注意这一步！！!
    if (i == nums.length) {
      ans = Math.max(ans, count);
    }
    return ans;
  }

}
