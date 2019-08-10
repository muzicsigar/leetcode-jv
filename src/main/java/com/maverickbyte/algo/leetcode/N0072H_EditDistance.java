package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0072H_EditDistance {


  /* =============================================================================================
       1. sub quiz: dp(i, j) means the edit distance that word1[0, i] converted to word2[0,j].
       2. state transitions:
          - when word1[i] = word2[j], dp(i, j) == dp(i - 1, j - 1);
          - when word1[i] != word2[j], we can do insert, delete or replace op so that word1[i] =
            word2[j]
            * insert "c": ( aim: ("abc" -> "bd"), ("abc" -> "b")): dp(i, j) = dp(i, j - 1) + 1
            * delete "c":  ( aim: ("abc" -> "bd"), ("ab" -> "bd")): dp(i, j) = dp(i - 1, j) + 1
            * replace "c": ( aim: ("abc" -> "bd"), ("ab" -> "b")): dp(i, j) = dp(i - 1, j - 1) + 1
       3. boundary(some initial state values):
          dp(i, 0) = i, dp(0, j) = j;
     ============================================================================================= */

  /* =============================================================================================
       solution 1: recursive dp with state tracking , space: O(m*n)
     ============================================================================================= */
  public int minDistance1(String word1, String word2) {
    if (null == word1 || null == word2) {
      throw new NullPointerException();
    }
    int wd1Len = word1.length();
    int wd2Len = word2.length();
    if (wd1Len == 0) {
      return wd2Len;
    }
    if (wd2Len == 0) {
      return wd1Len;
    }
    states = new int[wd1Len + 1][wd2Len + 1];
    for (int[] row : states) {
      Arrays.fill(row, -1);
    }
    this.wd1 = word1;
    this.wd2 = word2;
    return dp(wd1Len, wd2Len);
  }

  private String wd1;
  private String wd2;
  private int[][] states;

  private int dp(int i, int j) {
    if (i == 0) {
      return j;
    }
    if (j == 0) {
      return i;
    }
    if (states[i][j] >= 0) {
      return states[i][j];
    }
    if (wd1.charAt(i - 1) == wd2.charAt(j - 1)) {
      int dp = dp(i - 1, j - 1);
      states[i][j] = dp;
      return dp;
    } else {
      int dp = Math.min(dp(i, j - 1), Math.min(dp(i - 1, j), dp(i - 1, j - 1))) + 1;
      states[i][j] = dp;
      return dp;
    }
  }

  /* =============================================================================================
       solution 2: iterative dp with state tracking, space: O(m * n)
     ============================================================================================= */
  public int minDistance2(String word1, String word2) {
    if (null == word1 || null == word2) {
      throw new NullPointerException();
    }
    int wd1Len = word1.length();
    int wd2Len = word2.length();
    if (wd1Len == 0) {
      return wd2Len;
    }
    if (wd2Len == 0) {
      return wd1Len;
    }
    int[][] states = new int[wd1Len + 1][wd2Len + 1];
    for (int i = 0; i <= wd2Len; i++) {
      states[0][i] = i;
    }
    for (int j = 0; j <= wd1Len; j++) {
      states[j][0] = j;
    }

    for (int i = 1; i <= wd1Len; i++) {
      for (int j = 1; j <= wd2Len; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          states[i][j] = states[i - 1][j - 1];
        } else {
          states[i][j] =
            Math.min(states[i - 1][j], Math.min(states[i][j - 1], states[i - 1][j - 1])) + 1;
        }
      }
    }
    return states[wd1Len][wd2Len];
  }

  /* =============================================================================================
       solution 3: iterative dp with state tracking, space: O(n). n = word2.length().
     ============================================================================================= */
  public int minDistance3(String word1, String word2) {
    if (null == word1 || null == word2) {
      throw new NullPointerException();
    }
    int wd1Len = word1.length();
    int wd2Len = word2.length();
    if (wd1Len == 0) {
      return wd2Len;
    }
    if (wd2Len == 0) {
      return wd1Len;
    }
    int[] rollingStates = new int[wd2Len + 1];
    for (int i = 0; i <= wd2Len; i++) {
      rollingStates[i] = i;
    }
    for (int i = 1; i <= wd1Len; i++) {
      int corner = rollingStates[0]; // dp(i - 1, j - 1)
      rollingStates[0] = i;
      for (int j = 1; j <= wd2Len; j++) {
        int left = rollingStates[j - 1]; // dp(i, j - 1)
        int up = rollingStates[j]; // dp(i - 1, j)
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          rollingStates[j] = corner;
        } else {
          rollingStates[j] = Math.min(left, Math.min(corner, up)) + 1;
        }
        corner = up;
      }
    }
    return rollingStates[wd2Len];
  }




}
