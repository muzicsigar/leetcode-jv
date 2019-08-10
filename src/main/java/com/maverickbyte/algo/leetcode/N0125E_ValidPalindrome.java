package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0125E_ValidPalindrome {


  public boolean isPalindrome(String s) {
    if (null == s) {
      throw new NullPointerException();
    }
    if (s.length() == 0) {
      return true;
    }
    int i = -1;
    int j = s.length();
    while (i < j) {
      while (i < s.length() - 1 && !Character.isLetterOrDigit(s.charAt(++i))) {
      }
      while (j > 0 && !Character.isLetterOrDigit(s.charAt(--j))) {
      }
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        break;
      }
    }
    return j <= i;
  }

}
