package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0028E_ImplementStrStr {


  /* =============================================================================================
      solution 1: brutal-force
     ============================================================================================= */
  public int strStr(String haystack, String needle) {
    if (null == haystack) {
      throw new NullPointerException();
    }
    if (null == needle) {
      return -1;
    }
    if (needle.equals("")) {
      return 0;
    }

    int i = 0, j = 0, k = 0;
    while (k < haystack.length()) {
      if (haystack.charAt(k) == needle.charAt(0)) {
        i = k;
        j = 0;
        while (i < haystack.length() && j < needle.length()) {
          if (needle.charAt(j) != haystack.charAt(i)) {
            break;
          }
          i++;
          j++;
        }
        if (j == needle.length()) {
          return k;
        }
      }
      k++;
    }
    return -1;
  }


  /* =============================================================================================
      solution 2: KMP
     ============================================================================================= */
  public int strStr2(String haystack, String needle) {

    return 0;
  }
}
