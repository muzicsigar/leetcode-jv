package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0045H_JumpGameII {

  public int jump1(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return 0;
    }
    int step = 0;
    for (int i = 0; i < nums.length - 1; ) {
      if(i+ nums[i] >= nums.length - 1) {
        step++;
        break;
      }
      int next = i + 1;
      for (int j = i + 1; j <= i + nums[i]; j++) {
        if (j + nums[j] >= nums.length - 1) {
          next = j;
          break;
        }
        if (next + nums[next] < j + nums[j]) {
          next = j;
        }
      }
      i = next;
      step++;
    }
    return step;
  }

  public int jump2(int[] nums) {
    int end = 0;
    int maxPosition = 0;
    int steps = 0;
    for(int i = 0; i < nums.length - 1; i++){
      //找能跳的最远的
      maxPosition = Math.max(maxPosition, nums[i] + i);
      if( i == end){ //遇到边界，就更新边界，并且步数加一
        end = maxPosition;
        steps++;
      }
    }
    return steps;
  }

}
