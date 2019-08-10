package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0746E_MinCostClimbingStairs {


  /* =============================================================================================
       recursive dp with memo
     ============================================================================================= */
  public int minCostClimbingStairs1(int[] cost) {
    int len = cost.length;
    if (len < 3) {
      return cost[len - 1];
    }
    states = new int[len];

    return Math.min(dp(cost, len - 1), dp(cost, len));
  }

  private int[] states;

  private int dp(int[] cost, int n) {
    if (n < 3) {
      return cost[n - 1];
    }
    if (states[n - 1] > 0) {
      return states[n - 1];
    }
    int pp = dp(cost, n - 2);
    int p = dp(cost, n - 1);
    int min = Math.min(p, pp) + cost[n - 1];
    states[n - 1] = min;
    return min;
  }

  /* =============================================================================================
       iterative dp, in-place
     ============================================================================================= */
  public int minCostClimbingStairs2(int[] cost) {
    int len = cost.length;
    if (len < 3) {
      return cost[len - 1];
    }
    for (int i = 2; i < len; i++) {
      cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
    }
    return Math.min(cost[len - 1], cost[len - 2]);
  }
}
