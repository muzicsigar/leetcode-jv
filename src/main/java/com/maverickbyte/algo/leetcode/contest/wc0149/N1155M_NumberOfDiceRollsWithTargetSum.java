package com.maverickbyte.algo.leetcode.contest.wc0149;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N1155M_NumberOfDiceRollsWithTargetSum {

  private static final int MOD = 1000000007;

  /* =============================================================================================
          solution 1:
          用backtrack是不行的，Time是指数级的 O(d ^ f) , 当要用backtrack时，一定要先考虑下复杂度。同时多半这道
          题可以用DP解决。
         ============================================================================================= */
  public int numRollsToTarget1(int d, int f, int target) {
    if (target < d || target > d * f) {
      return 0;
    }

    this.target = target;
    this.d = d;
    this.f = f;

    backtrack(0, 0);
    return ans;
  }

  private int target;
  private int d;
  private int f;
  private int ans;

  private void backtrack(int depth, int sum) {
    if (depth == this.d && sum == this.target) {
      ans++;
      return;
    }
    for (int i = 1; i <= this.f; i++) {
      if (sum + i > target) {
        return;
      }
      backtrack(depth + 1, sum + i);
    }
  }


  /* =============================================================================================
      solution 2: dp
      STE:  dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j - 2] + ... + dp[i - 1][j - f]
      Bound: dp[1][j] = 1 (j <= f)
     ============================================================================================= */
  public int numRollsToTarget2(int d, int f, int target) {
    int[][] dp = new int[31][1001];
    int min = Math.min(f, target);
    for (int i = 1; i <= min; i++) {
      dp[1][i] = 1;
    }
    int targetMax = d * f;
    for (int i = 2; i <= d; i++) {
      for (int j = i; j <= targetMax; j++) {
        for (int k = 1; j - k >= 0 && k <= f; k++) {
          dp[i][j] += dp[i - 1][j - k] % MOD;
        }
      }
    }
    return dp[d][target];
  }


}
