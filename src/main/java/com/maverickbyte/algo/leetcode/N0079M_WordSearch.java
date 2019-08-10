package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0079M_WordSearch {

  /*
   * True terminated condition: depth equals to the word length.
   * Hints: use boolean matrix to track the footprints.
   *
   * Step 1. find the start place: word[0]
   * Step 2. dfs backtrack(left, right, up, down), count the depth
   */

  public boolean exist(char[][] board, String word) {
    int rowLength = board.length;
    int colLength = board[0].length;
    boolean[][] used = new boolean[rowLength][colLength];
    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < colLength; j++) {
        // find the start point
        if (board[i][j] == word.charAt(0)) {
          used[i][j] = true;
          if (backtrack(board, 1, i, j, used, word)) {
            return true;
          }
          used[i][j] = false;
        }
      }
    }
    return false;
  }


  private boolean backtrack(char[][] board, int step, int row, int col,
                            boolean[][] used, String word) {
    if (step == word.length()) {
      return true;
    }
    // left
    if (col - 1 >= 0 && !used[row][col - 1]) {
      used[row][col - 1] = true;
      if (board[row][col - 1] == word.charAt(step)
        && backtrack(board, step + 1, row, col - 1, used, word)) {
        return true;
      }
      used[row][col - 1] = false;
    }
    // right
    if (col + 1 < board[0].length && !used[row][col + 1]) {
      used[row][col + 1] = true;
      if (board[row][col + 1] == word.charAt(step)
        && backtrack(board, step + 1, row, col + 1, used, word)) {
        return true;
      }
      used[row][col + 1] = false;
    }
    // up
    if (row - 1 >= 0 && !used[row - 1][col]) {
      used[row - 1][col] = true;
      if (board[row - 1][col] == word.charAt(step) &&
        backtrack(board, step + 1, row - 1, col, used, word)) {
        return true;
      }
      used[row - 1][col] = false;
    }
    // down
    if (row + 1 < board.length && !used[row + 1][col]) {
      used[row + 1][col] = true;
      if (board[row + 1][col] == word.charAt(step)
        && backtrack(board, step + 1, row + 1, col, used, word)) {
        return true;
      }
      used[row + 1][col] = false;
    }

    return false;
  }


  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};// up, down, left,

  private boolean backtrack1(char[][] board, int step, int row, int col,
                             boolean[][] used, String word) {
    if (step == word.length()) {
      return true;
    }
    for (int[] direction : DIRECTIONS) {
      int r = row + direction[0];
      int c = col + direction[1];
      if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || used[r][c]) {
        continue;
      }
      used[r][c] = true;
      if (board[r][c] == word.charAt(step) && backtrack1(board, step + 1, r, c, used, word)) {
        return true;
      }
      used[r][c] = false;
    }
    return false;
  }

}
