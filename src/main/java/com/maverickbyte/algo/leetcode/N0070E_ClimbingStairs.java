package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0070E_ClimbingStairs {


  /* =============================================================================================
       recursive dp: timeout
     ============================================================================================= */
  public int climbStairs1(int n) {
    if (n <= 3) {
      return n;
    }
    return climbStairs1(n - 1) + climbStairs1(n - 2);
  }

  /* =============================================================================================
       iterative dp
     ============================================================================================= */
  public int climbStairs2(int n) {
    if (n < 3) {
      return n;
    }
    int pp = 1;
    int p = 2;
    int c = pp + p;
    int i = 3;
    while (i < n) {
      pp = p;
      p = c;
      c = pp + p;
      i++;
    }
    return c;
  }
}
