package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0009E_PalindromeNumber {


  /* =============================================================================================
      solution 1: 转成字符串
     ============================================================================================= */
  public boolean isPalindrome1(int x) {
    if (x < 0) {
      return false;
    }
    String s = String.valueOf(x);
    for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  // 1221, 13231
  public boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }
    int original = x;
    int reverse = 0;
    while (x > 0) {
      int pop = x % 10;
      x /= 10;
      if (reverse > Integer.MAX_VALUE / 10 || reverse == Integer.MAX_VALUE / 10 && pop > 7) {
        return false;
      }
      reverse = reverse * 10 + pop;
    }
    return reverse == original;
  }
}
