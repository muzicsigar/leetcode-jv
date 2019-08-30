package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0000X_Practice {


  public int minPathSum(int[][] grid) {
    if (null == grid || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int rLen = grid.length;
    int cLen = grid[0].length;
    for (int j = 1; j < cLen; j++) {
      grid[0][j] += grid[0][j - 1];
    }
    for (int i = 1; i < rLen; i++) {
      grid[i][0] += grid[i - 1][0];
    }
    for(int i = 1; i < rLen; i++)  {
      for(int j = 1; j < cLen; j++) {
        grid[i][j] += Math.min(grid[i - 1][j] , grid[i][j - 1]);
      }
    }
    return grid[rLen - 1][cLen - 1];
  }
}



