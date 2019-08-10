package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0058E_LengthOfLastWord {


  public int lengthOfLastWord(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }

    int len = s.length();

    int end = len;
    for (int i = len - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ') {
        end = i;
        break;
      }
    }
    if(end == len) {
      return 0;
    }

    int start = -1;
    for (int i = end; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        start = i;
        break;
      } else if (i == 0) {
        break;
      }
    }
    return end - start;
  }
}
