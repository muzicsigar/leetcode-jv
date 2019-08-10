package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0011M_ContainerWithMostWater {

  // brutal-force
  public int maxArea1(int[] height) {
    if (null == height || height.length == 1) {
      return 0;
    }

    int maxArea = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
      }
    }
    return maxArea;
  }

  // double pointers
  public int maxArea2(int[] height) {
    if(null == height || height.length == 1)  {
      return 0;
    }

    int maxArea = 0;
    int i = 0;
    int j = height.length - 1;

    while (i < j) {
      maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
      if(height[i] < height[j])  {
        i++;
      }else {
        j--;
      }
    }
    return maxArea;
  }
}
