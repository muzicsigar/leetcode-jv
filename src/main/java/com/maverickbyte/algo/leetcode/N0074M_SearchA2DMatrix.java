package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0074M_SearchA2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    if(null == matrix || matrix.length == 0 || matrix[0].length == 0)   {
      return false;
    }
    int rLen = matrix.length;
    int cLen = matrix[0].length;

    int l = 0;
    int r = rLen - 1;
    int m;
    while (l < r) {
      m = (l + r) / 2;
      if (matrix[m][0] > target) {
        r = m - 1;
      } else if (matrix[m][cLen - 1] < target) {
        l = m + 1;
      } else {
        break;
      }
    }
    m = (r + l) / 2;

    int left = 0;
    int right = cLen - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (target > matrix[m][mid]) {
        left = mid + 1;
      } else if (target < matrix[m][mid]) {
        right = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    N0074M_SearchA2DMatrix runner = new N0074M_SearchA2DMatrix();
    int[][] matrix = {
      {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
    runner.searchMatrix(matrix, 3);

  }
}
