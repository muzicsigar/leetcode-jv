package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0052H_NQueensII {

  int matrixSize;

  /*
   * tracking array for columns.
   */
  boolean[] cols;
  /*
   * tracking array for major diagonals
   * major diagonal check: row - col = const && diff major diagonals have diff const value.
   * const -> [-(n - 1), ..., 0, 1, ... , n - 1] -> size = 2n- 1
   * mapping: row - col + (n - 1) to [0, 2(n - 1)]
   */
  boolean[] majors;
  /*
   * tracking array for minor diagonals
   * minor diagonal check: row + col = const && diff minor diagonals have diff const value.
   * const -> [0, ..., 2 * (n - 1) ] -> size = 2n - 1
   */
  boolean[] minors;

  private int ans;

  public int totalNQueens(int n) {
    if (n < 1) {
      return 0;
    }
    matrixSize = n;
    cols = new boolean[n]; // tracking array for columns
    majors = new boolean[2 * n - 1]; // tracking array for major diagonals
    minors = new boolean[2 * n - 1]; // tracking array for minor diagonals
    backtrack(0);
    return ans;
  }

  private void backtrack(int row) {
    if (row == matrixSize) {
      ans++;
      return;
    }
    for (int col = 0; col < matrixSize; col++) {
      // pruning
      if (cols[col] || majors[row - col + (matrixSize - 1)] || minors[row + col]) {
        continue;
      }

      cols[col] = true;
      majors[row - col + (matrixSize - 1)] = true;
      minors[row + col] = true;

      backtrack(row + 1);

      cols[col] = false;
      majors[row - col + (matrixSize - 1)] = false;
      minors[row + col] = false;
    }
  }

}
