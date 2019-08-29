package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0059M_SpiralMatrixII {

  public int[][] generateMatrix(int n) {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] ans = new int[n][n];
    int i = 0, j = 0, v = 1, cur = 0;
    while (true) {
      ans[i][j] = v++;
      int x = directions[cur % 4][0] + i;
      int y = directions[cur % 4][1] + j;
      if (x >= n || x < 0 || y >= n || y < 0 || ans[x][y] > 0) {
        cur++;
        x = directions[cur % 4][0] + i;
        y = directions[cur % 4][1] + j;
        if (x >= n || x < 0 || y >= n || y < 0 || ans[x][y] > 0) {
          break;
        }
      }
      i = x;
      j = y;
    }
    return ans;
  }

  public int[][] generateMatrix2(int n) {
    int l = 0, r = n - 1, t = 0, b = n - 1;
    int[][] mat = new int[n][n];
    int num = 1, tar = n * n;
    while (num <= tar) {
      for (int i = l; i <= r; i++)
        mat[t][i] = num++; // left to right.
      t++;
      for (int i = t; i <= b; i++)
        mat[i][r] = num++; // top to bottom.
      r--;
      for (int i = r; i >= l; i--)
        mat[b][i] = num++; // right to left.
      b--;
      for (int i = b; i >= t; i--)
        mat[i][l] = num++; // bottom to top.
      l++;
    }
    return mat;
  }


}
