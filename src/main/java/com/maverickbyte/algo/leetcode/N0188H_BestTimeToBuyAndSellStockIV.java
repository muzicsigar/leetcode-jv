package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0188H_BestTimeToBuyAndSellStockIV {

  /* =============================================================================================
      comment
      1. state: dp[i][k][0]

      2. state transition equation(STE):
        dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i] )
        dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])

      3. base case
        dp[-1][k][0] = dp[i][0][0] = 0
        dp[-1][k][1] = dp[i][0][1] = -infinity

     ============================================================================================= */
}
