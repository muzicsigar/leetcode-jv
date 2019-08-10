package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0096M_UniqueBinarySearchTrees {


  /* =============================================================================================
      solution 1: dp
      G(n) = f(1) + f(2) + ... + f(n)
      f(i) = G(i - 1) * G(n - i)
      G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) + ... + G(n - 1) * G(0)
     ============================================================================================= */
  public int numTrees(int n) {
    int[] g = new int[n + 1];
    g[0] = 1;
    g[1] = g[0] * g[0];

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        g[i] += g[j] * g[i - j - 1];
      }
    }
    return g[n];
  }
}
