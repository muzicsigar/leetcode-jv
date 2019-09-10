package com.maverickbyte.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0073M_SetMatrixZeroes {


  public void setZeroes(int[][] matrix) {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (rows.contains(i) || cols.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public void setZeroes2(int[][] matrix) {

    boolean col0ToZero = false;
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        col0ToZero = true;
        break;
      }
    }
    boolean row0ToZero = false;
    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        row0ToZero = true;
        break;
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (row0ToZero) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }
    if (col0ToZero) {
      for(int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }

  }

}
