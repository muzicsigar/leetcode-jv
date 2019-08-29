package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0050M_Pow {

  /* =============================================================================================
      solution 1: timeout
     ============================================================================================= */
  public double myPow(double x, int n) {
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    double ans = 1;
    for (long i = 0; i < n; i++) {
      ans = ans * x;
    }
    return ans;
  }


  public double myPow2(double x, long n) {
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    return fastPow(x, n);
  }

  private double fastPow(double x, long n) {
    if (n == 0) {
      return 1.0;
    }
    double half = fastPow(x, n / 2);
    if (n % 2 == 0) {
      return half * half;
    } else {
      return half * half * x;
    }
  }

}
