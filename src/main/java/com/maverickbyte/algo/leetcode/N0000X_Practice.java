package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0000X_Practice {


  /* =============================================================================================
      comment
      brutal-force: O(n ^ 2)
      dp: O(n ^ 2)

     ============================================================================================= */
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    for (int i = 0; i < nums.length; ) {
      while (i < nums.length && nums[i] <= 0) {
        max = Math.max(max, nums[i]);
        i++;
      }
      if (i == nums.length - 1) {
       break;
      }
      int temp = nums[i];
      int j = i + 1;
      for (; j < nums.length; ) {
        if (temp + nums[j] > 0) {
          temp += nums[j];
          max = Math.max(max, temp);
          j++;
        } else {
          break;
        }
      }
      i = j + 1;
    }
    return max;
  }

  public static void main(String[] args) {
    N0000X_Practice runner = new N0000X_Practice();
    int ans = runner.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    System.out.println(ans);
  }


}



