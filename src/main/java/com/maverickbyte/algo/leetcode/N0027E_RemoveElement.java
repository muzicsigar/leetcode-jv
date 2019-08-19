package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0027E_RemoveElement {

  public int removeElement(int[] nums, int val) {
    int empty = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val && empty >= 0) {
        int tmp = nums[empty];
        nums[empty] = nums[i];
        nums[i] = tmp;
        empty++;
      } else if (nums[i] == val && empty < 0) {
        empty = i;
      }
    }
    return empty >= 0 ? empty : nums.length;
  }


  public static void main(String[] args) {
    N0027E_RemoveElement runner = new N0027E_RemoveElement();
    int[] nums = {3, 2, 2, 3};
    int ans = runner.removeElement(nums, 3);
    System.out.println(Arrays.toString(nums));
  }
}
