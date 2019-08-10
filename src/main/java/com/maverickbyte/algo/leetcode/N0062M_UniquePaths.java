package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0062M_UniquePaths {

  /* =============================== recursive dp ==================================*/
  public int uniquePaths1(int m, int n) {
    if (n < 1 || m < 1) {
      return 0;
    }
    return dp1(m, n);
  }

  private int dp1(int m, int n) {
    // initial state: dp1(m, 1) = 1, dp1(1, n) = 1
    if (n == 1 || m == 1) {
      return 1;
    }
    // state transition equation(STE): dp1(m, n) = dp1(m, n - 1) + dp1(m - 1, n)
    return dp1(m, n - 1) + dp1(m - 1, n);
  }

  /* ============================= recursive dp with state tracking ===========================*/
  public int uniquePaths2(int m, int n) {
    if (n < 1 || m < 1) {
      return 0;
    }
    int[][] states = new int[m + 1][n + 1];
    Arrays.fill(states[1], 1);
    for (int i = 1; i <= m; i++) {
      states[i][1] = 1;
    }
    return dp2(m, n, states);
  }

  private int dp2(int m, int n, int[][] states) {
    if (states[m][n] > 0) {
      return states[m][n];
    }
    int value = dp2(m, n - 1, states) + dp2(m - 1, n, states);
    states[m][n] = value;
    return value;
  }

  /* =============================================================================================
     solution 3
     1. recursive dp
     2. with state tracking
     3. with space optimization
  ===============================================================================================*/
  public int uniquePaths3(int m, int n) {
    if (m < 1 || n < 1) {
      return 0;
    }
    int[] states = new int[n];
    Arrays.fill(states, 1);
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        states[j] += states[j - 1];
      }
    }
    return states[n - 1];
  }


  /* =============================================================================================
       solution 4:
       1. math -> permutation & combination: C(m -1, m - 1 + n - 1)
     ============================================================================================= */
  public int uniquePaths(int m, int n) {
    // TODO
    return 0;
  }

  public static void main(String[] args) {
    N0062M_UniquePaths runner = new N0062M_UniquePaths();
    runner.uniquePaths2(5, 6);
  }


}
