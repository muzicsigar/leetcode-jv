package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0016M_3SumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ans = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        int tmp = nums[i] + nums[j] + nums[k];
        if (Math.abs(target - tmp) < Math.abs(target - ans)) {
          ans = tmp;
        }
        if (tmp < target) {
          j++;
        } else if (tmp > target) {
          k--;
        } else {
          return tmp;
        }
      }
    }
    return ans;
  }
}
