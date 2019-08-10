package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0064M_MinimumPathSum {


  /* =============================================================================================
       version 1: recursive dp without state tracking
       leetcode timeout
     ============================================================================================= */
  public int minPathSum1(int[][] grid) {
    if (null == grid || grid.length == 0) {
      return 0;
    }
    int rlen = grid.length;
    int clen = grid[0].length;
    for (int i = rlen - 2; i >= 0; i--) {
      grid[i][clen - 1] += grid[i + 1][clen - 1];
    }
    for (int j = clen - 2; j >= 0; j--) {
      grid[rlen - 1][j] += grid[rlen - 1][j + 1];
    }
    return dp1(grid, 0, 0);
  }

  private int dp1(int[][] grid, int i, int j) {
    if (i == grid.length - 1 || j == grid[0].length - 1) {
      return grid[i][j];
    }
    return Math.min(dp1(grid, i + 1, j), dp1(grid, i, j + 1)) + grid[i][j];
  }

  /* =============================================================================================
       version 2: recursive dp with state tracking
       skip here
     ============================================================================================= */

  /* =============================================================================================
       version 3: iterative dp, space optimized(in-place)
     ============================================================================================= */
  public int minPathSum2(int[][] grid) {
    if (null == grid || grid.length == 0) {
      return 0;
    }
    int rlen = grid.length;
    int clen = grid[0].length;
    for (int i = rlen - 2; i >= 0; i--) {
      grid[i][clen - 1] += grid[i + 1][clen - 1];
    }
    for (int j = clen - 2; j >= 0; j--) {
      grid[rlen - 1][j] += grid[rlen - 1][j + 1];
    }
    for (int i = rlen - 2; i >= 0; i--) {
      for (int j = clen - 2; j >= 0; j--) {
        grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
      }
    }
    return grid[0][0];
  }

}
