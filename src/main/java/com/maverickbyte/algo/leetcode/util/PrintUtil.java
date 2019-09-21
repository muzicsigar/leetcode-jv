package com.maverickbyte.algo.leetcode.util;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public final class PrintUtil {

  private PrintUtil() {
    throw new AssertionError();
  }

  public static void print(boolean[][] source) {
    int rLen = source.length;
    int cLen = source[0].length;
    int[][] square = new int[rLen][cLen];
    for (int i = 0; i < rLen; i++) {
      for (int j = 0; j < cLen; j++) {
        if (source[i][j]) {
          square[i][j] = 1;
        }
      }
    }
    for (int[] r : square) {
      System.out.println(Arrays.toString(r));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    PrintUtil.print(new boolean[50][50]);
  }
}
