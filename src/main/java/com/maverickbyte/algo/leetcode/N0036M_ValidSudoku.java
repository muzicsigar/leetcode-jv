package com.maverickbyte.algo.leetcode;

import java.util.HashMap;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0036M_ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    // row
    for (int i = 0; i < 9; i++) {
      int[] valid = new int[10];
      for (int k = 0; k < 9; k++) {
        char ch = board[i][k];
        if (ch == '.') {
          continue;
        }
        if (++valid[ch - '0'] > 1) {
          return false;
        }
      }
    }
    // col
    for (int j = 0; j < 9; j++) {
      int[] valid = new int[10];
      for (int k = 0; k < 9; k++) {
        char ch = board[k][j];
        if (ch == '.') {
          continue;
        }
        if (++valid[ch - '0'] > 1) {
          return false;
        }
      }
    }
    //square
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        int[] valid = new int[10];
        for(int m = i; m < i +3; m++){
          for(int n = j; n < j + 3; n++) {
            char ch = board[m][n];
            if (ch == '.') {
              continue;
            }
            if (++valid[ch - '0'] > 1) {
              return false;
            }
          }
        }
      }
    }
    return true;
 }
  public boolean isValidSudoku2(char[][] board) {
    HashMap<Integer, Integer>[] rows = new HashMap[9];
    HashMap<Integer, Integer> [] columns = new HashMap[9];
    HashMap<Integer, Integer> [] boxes = new HashMap[9];
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashMap<Integer, Integer>();
      columns[i] = new HashMap<Integer, Integer>();
      boxes[i] = new HashMap<Integer, Integer>();
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char num = board[i][j];
        if (num != '.') {
          int n = (int)num;
          int box_index = (i / 3 ) * 3 + j / 3;

          rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
          columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
          boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

          if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
            return false;
          }
        }
      }
    }

    return true;
  }

}
