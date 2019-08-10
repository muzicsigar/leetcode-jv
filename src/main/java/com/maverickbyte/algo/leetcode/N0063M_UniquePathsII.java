package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0063M_UniquePathsII {


  /* =============================================================================================
       solution 1: backtrack
       timeout
     ============================================================================================= */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (null == obstacleGrid || obstacleGrid.length == 0) {
      return 0;
    }
    this.ans1 = 0;
    backtrack(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    return this.ans1;
  }

  private int ans1;

  private void backtrack(int[][] obstacleGrid, int i, int j) {
    if (obstacleGrid[i][j] == 1) {
      return;
    }
    if (i == 0 && j == 0) {
      ans1++;
      return;
    }
    if (i > 0) { // up
      obstacleGrid[i][j] = 1;
      backtrack(obstacleGrid, i - 1, j);
      obstacleGrid[i][j] = 0;
    }
    if (j > 0) { // left
      obstacleGrid[i][j] = 1;
      backtrack(obstacleGrid, i, j - 1);
      obstacleGrid[i][j] = 0;
    }
  }

  /* =============================================================================================
      solution 2: iterative dp with in-place.
      og solution: https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode/
     ============================================================================================= */
  public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
    if (null == obstacleGrid || obstacleGrid.length == 0) {
      return 0;
    }
    int rowLen = obstacleGrid.length;
    int colLen = obstacleGrid[0].length;
    // 初始化的时候，由于[0][0]号元素会被初始化两次产生干扰，这个元素单独处理
    if(obstacleGrid[0][0] == 1) {
      return 0;
    } else {
      obstacleGrid[0][0] = 1;
    }
    for (int i = 1; i < colLen; i++) {
      if (obstacleGrid[0][i] == 1) {
        obstacleGrid[0][i] = 0;
      } else {
        obstacleGrid[0][i] = obstacleGrid[0][i - 1];
      }
    }
    for (int i = 1; i < rowLen; i++) {
      if (obstacleGrid[i][0] == 1) {
        obstacleGrid[i][0] = 0;
      } else {
        obstacleGrid[i][0] = obstacleGrid[i - 1][0];
      }
    }
    for (int i = 1; i < rowLen; i++) {
      for (int j = 1; j < colLen; j++) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
        } else {
          obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
        }
      }
    }
    return obstacleGrid[rowLen - 1][colLen - 1];
  }


}
