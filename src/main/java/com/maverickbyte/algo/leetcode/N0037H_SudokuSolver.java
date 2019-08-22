package com.maverickbyte.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0037H_SudokuSolver {

  //  public void solveSudoku(char[][] board) {
//    rows = new HashSet[9];
//    cols = new HashSet[9];
//    squares = new HashSet[9];
//    for (int i = 0; i < 9; i++) {
//      rows[i] = new HashSet<>();
//      cols[i] = new HashSet<>();
//      squares[i] = new HashSet<>();
//    }
//    for (int i = 0; i < 9; i++) {
//      for (int j = 0; j < 9; j++) {
//        if (board[i][j] != '.') {
//          int num = board[i][j] - '0';
//          int k = (i / 3) * 3 + j / 3;
//          rows[i].add(num);
//          cols[j].add(num);
//          squares[k].add(num);
//        }
//      }
//    }
//    this.board = board;
//    backtrack(0, 0);
//  }
//
//  private Set<Integer>[] rows;
//  private Set<Integer>[] cols;
//  private Set<Integer>[] squares;
//  private char[][] board;
//
//
//  private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//
//  private void backtrack(int r, int c) {
//    if (r < 0 || c < 0 || r > 8 || c > 8 || board[r][c] != '.') {
//      return;
//    }
//
//    Set<Integer> set = new HashSet<>();
//    for (int i = 1; i <= 9; i++) {
//      if (!rows[r].contains(i) && !cols[c].contains(i) && !squares[(r / 3) * 3 + c / 3]
// .contains(i)) {
//        set.add(i);
//      }
//    }
//    if (set.isEmpty()) {
//      return;
//    }
//
//    for (Integer num : set) {
//      rows[r].add(num);
//      cols[c].add(num);
//      squares[(r / 3) * 3 + c / 3].add(num);
//      board[r][c] = (char) (num + '0');
//
//      for (int[] direction : directions) {
//        int newX = r + direction[0];
//        int newY = c + direction[1];
//        backtrack(newX, newY);
//      }
//
//      rows[r].remove(num);
//      cols[c].remove(num);
//      squares[(r / 3) * 3 + c / 3].remove(num);
//      board[r][c] = '.';
//    }
//  }


  // box size
  int n = 3;
  // row size
  int N = n * n;

  int[][] rows = new int[N][N + 1];
  int[][] columns = new int[N][N + 1];
  int[][] boxes = new int[N][N + 1];

  char[][] board;

  boolean sudokuSolved = false;

  public boolean couldPlace(int d, int row, int col) {
    /*
    Check if one could place a number d in (row, col) cell
    */
    int idx = (row / n) * n + col / n;
    return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
  }

  public void placeNumber(int d, int row, int col) {
    /*
    Place a number d in (row, col) cell
    */
    int idx = (row / n) * n + col / n;

    rows[row][d]++;
    columns[col][d]++;
    boxes[idx][d]++;
    board[row][col] = (char) (d + '0');
  }

  public void removeNumber(int d, int row, int col) {
    /*
    Remove a number which didn't lead to a solution
    */
    int idx = (row / n) * n + col / n;
    rows[row][d]--;
    columns[col][d]--;
    boxes[idx][d]--;
    board[row][col] = '.';
  }

  public void placeNextNumbers(int row, int col) {
    /*
    Call backtrack function in recursion
    to continue to place numbers
    till the moment we have a solution
    */
    // if we're in the last cell
    // that means we have the solution
    if ((col == N - 1) && (row == N - 1)) {
      sudokuSolved = true;
    } else {
      // if we're in the end of the row
      // go to the next row
      if (col == N - 1)
        backtrack(row + 1, 0);
        // go to the next column
      else
        backtrack(row, col + 1);
    }
  }

  public void backtrack(int row, int col) {
    /*
    Backtracking
    */
    // if the cell is empty
    if (board[row][col] == '.') {
      // iterate over all numbers from 1 to 9
      for (int d = 1; d < 10; d++) {
        if (couldPlace(d, row, col)) {
          placeNumber(d, row, col);
          placeNextNumbers(row, col);
          // if sudoku is solved, there is no need to backtrack
          // since the single unique solution is promised
          if (!sudokuSolved)
            removeNumber(d, row, col);
        }
      }
    } else {
      placeNextNumbers(row, col);
    }
  }

  public void solveSudoku(char[][] board) {
    this.board = board;

    // init rows, columns and boxes
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        char num = board[i][j];
        if (num != '.') {
          int d = Character.getNumericValue(num);
          placeNumber(d, i, j);
        }
      }
    }
    backtrack(0, 0);
  }

}
