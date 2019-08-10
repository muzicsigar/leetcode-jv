package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0256E_PaintHouse {


  public int minCost1(int[][] costs) {
    if (costs.length < 1) {
      return 0;
    }
    int[] min = dp(costs, costs.length - 1);
    return Math.min(min[0], Math.min(min[1], min[2]));
  }


  // recursive + state memorization
  private int[] dp(int[][] costs, int i) {
    if (i == 0) {
      return new int[]{costs[0][0], costs[0][1], costs[0][2]};
    }
    int[] minPrev = dp(costs, i - 1);
    costs[i][0] = costs[i][0] + Math.min(minPrev[1], minPrev[2]);
    costs[i][1] = costs[i][1] + Math.min(minPrev[0], minPrev[2]);
    costs[i][2] = costs[i][2] + Math.min(minPrev[0], minPrev[1]);
    return new int[]{costs[i][0], costs[i][1], costs[i][2]};
  }


  // iteration && in-place
  public int minCost2(int[][] costs) {
    if (null == costs || costs.length < 1) {
      return 0;
    }
    int len = costs.length;
    for (int i = 1; i < len; i++) {
      costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
      costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
      costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
    }
    return Math.min(costs[len - 1][0], Math.min(costs[len - 1][1], costs[len - 1][2]));
  }

}
