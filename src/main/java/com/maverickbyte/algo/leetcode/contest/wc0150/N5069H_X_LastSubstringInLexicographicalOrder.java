package com.maverickbyte.algo.leetcode.contest.wc0150;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N5069H_X_LastSubstringInLexicographicalOrder {

  /* =============================================================================================
      solution 1: timeout
     ============================================================================================= */
  public String lastSubstring(String s) {
    if (s.length() <= 1) {
      return s;
    }
    char max = s.charAt(0);
    for (int i = 0; i < s.length(); i++) {
      if (max < s.charAt(i)) {
        max = s.charAt(i);
      }
    }

    int start = -1;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) != max) {
        continue;
      }
      if (start < 0) {
        start = i;
      } else {
        for (int j = start - 1; j >= 0; j--) {
          int m = j;
          int k = start;
          while (k < s.length()) {
            if (s.charAt(m) == s.charAt(k) && m == start) {
              start = j;
              break;
            }
            if (s.charAt(m) == s.charAt(k)) {
              k++;
              m++;
              continue;
            }
            if (s.charAt(m) > s.charAt(k)) {
              start = j;
              break;
            }
            if (s.charAt(m) < s.charAt(k)) {
              break;
            }
          }
          if (k == s.length()) {
            start = j;
          }
        }
      }
    }
    return s.substring(start);
  }

  /* =============================================================================================
      solution 2: timeout
     ============================================================================================= */
  public String lastSubstring2(String s) {
    int i = 1;
    String max = s;
    while (i < s.length()) {
      String cur = s.substring(i);
      if (max.compareTo(cur) < 0) {
        max = cur;
      }
      i++;
    }
    return max;
  }

  public String lastSubstring3(String s) {
    return null;
  }

}
