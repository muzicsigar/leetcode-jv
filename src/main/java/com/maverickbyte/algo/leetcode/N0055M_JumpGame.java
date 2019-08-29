package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0055M_JumpGame {

  public boolean canJump(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return true;
    }
    int i = 0;
    for (int j = 0; j < nums.length - 1; j++) {
      if (j + nums[j] >= nums.length - 1) {
        return true;
      }
      if (nums[j] <= 0) {
        boolean flag = false;
        for (int k = j - 1; k >= i; k--) {
          if (k + nums[k] > j) {
            nums[j] = 1;
            i = j;
            flag = true;
            break;
          }
        }
        if (!flag) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    N0055M_JumpGame runner = new N0055M_JumpGame();
    boolean ans = runner.canJump(new int[]{4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0});
    System.out.println(ans);
  }
}
