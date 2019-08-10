package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution: https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode/
 *
 * @author Alan Li
 * @since 1.0
 */
public class N0051H_NQueens {

  private int matrixSize;

  /*
   * tracking array for columns.
   */
  private boolean[] cols;
  /*
   * tracking array for major diagonals
   * major diagonal check: row - col = const && diff major diagonals have diff const value.
   * const -> [-(n - 1), ..., 0, 1, ... , n - 1] -> size = 2n- 1
   * mapping: row - col + (n - 1) to [0, 2(n - 1)]
   */
  private boolean[] majors;
  /*
   * tracking array for minor diagonals
   * minor diagonal check: row + col = const && diff minor diagonals have diff const value.
   * const -> [0, ..., 2 * (n - 1) ] -> size = 2n - 1
   */
  private boolean[] minors;

  private char[] rowQueenTemplate;

  public List<List<String>> solveNQueens(int n) {
    if (n < 1) {
      return new ArrayList<>();
    }

    matrixSize = n;
    rowQueenTemplate = new char[n];
    Arrays.fill(rowQueenTemplate, '.');

    cols = new boolean[n]; // tracking array for columns
    majors = new boolean[2 * n - 1]; // tracking array for major diagonals
    minors = new boolean[2 * n - 1]; // tracking array for minor diagonals

    int[] queens = new int[n];
    Arrays.fill(queens, -1);
    List<List<String>> ans = new ArrayList<>();
    backtrack(0, queens, ans);
    return ans;
  }


  private void backtrack(int row, int[] queens, List<List<String>> ans) {
    if (row == matrixSize) {
      fillQueens(queens, ans);
      return;
    }

    for (int col = 0; col < matrixSize; col++) {
      // pruning
      if (notValid(row, col)) {
        continue;
      }

      queens[row] = col;
      cols[col] = true;
      majors[row - col + (matrixSize - 1)] = true;
      minors[row + col] = true;

      backtrack(row + 1, queens, ans);

      queens[row] = -1;
      cols[col] = false;
      majors[row - col + (matrixSize - 1)] = false;
      minors[row + col] = false;
    }
  }

  private boolean notValid(int row, int col) {
    return cols[col] || majors[row - col + (matrixSize - 1)] || minors[row + col];
  }

  private void fillQueens(int[] queens, List<List<String>> ans) {
    List<String> queenList = new ArrayList<>();
    for (int i = 0; i < matrixSize; i++) {
      rowQueenTemplate[queens[i]] = 'Q';
      queenList.add(new String(rowQueenTemplate));
      rowQueenTemplate[queens[i]] = '.';
    }
    ans.add(queenList);
  }

  public static void main(String[] args) {
    N0051H_NQueens runner = new N0051H_NQueens();
    List<List<String>> lists = runner.solveNQueens(4);
    for (List<String> list : lists) {
      System.out.println(list);
    }
  }
}

