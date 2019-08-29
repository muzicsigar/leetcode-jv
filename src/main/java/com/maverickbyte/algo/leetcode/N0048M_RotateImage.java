package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0048M_RotateImage {

  public void rotate(int[][] matrix) {
    if (null == matrix || matrix.length <= 1) {
      return;
    }
    int len = matrix.length;
    int i = 0, j = len - 1;
    while (i < j) {
      int[] tmp = matrix[i];
      matrix[i] = matrix[j];
      matrix[j] = tmp;
      i++;
      j--;
    }
    for (i = 0; i < len; i++) {
      for (j = i + 1; j < len; j++) {
        int tmp = matrix[i][j] ;
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }
}
