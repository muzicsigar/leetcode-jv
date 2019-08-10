package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0075M_SortColors {


  private static final int RED = 0;
  private static final int WHITE = 1;
  private static final int BLUE = 2;

  // two round traversal
  public void sortColors1(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int red = 0;
    int white = 0;
    int blue = 0;
    for (int i = 0; i < nums.length; i++) {
      switch (nums[i]) {
        case RED:
          red++;
          break;
        case WHITE:
          white++;
          break;
        case BLUE:
          blue++;
          break;
        default:
          throw new IllegalArgumentException();
      }
    }

    int i = 0;
    while (red > 0) {
      nums[i++] = RED;
      red--;
    }
    while (white > 0) {
      nums[i++] = WHITE;
      white--;
    }
    while (blue > 0) {
      nums[i++] = BLUE;
      blue--;
    }
  }

  /* =============================== one round traversal==================================*/
  public void sortColors2(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int i = 0;
    int j = nums.length - 1;
    int cur = 0;

    int temp;
    while (cur <= j) {
      if (nums[cur] == BLUE) {
        temp = nums[cur];
        nums[cur] = nums[j];
        nums[j--] = temp;
      } else if (nums[cur] == RED) {
        temp = nums[cur];
        nums[cur++] = nums[i];
        nums[i++] = temp;
      } else {
        cur++;
      }
    }

  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 0, 2, 1, 1, 0};
    new N0075M_SortColors().sortColors1(nums);
    System.out.println(Arrays.toString(nums));
  }
}
