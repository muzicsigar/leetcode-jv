package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0058E_LengthOfLastWord {


  public int lengthOfLastWord(String s) {
    int end = s.length() - 1;
    while (end >= 0) {
      if (s.charAt(end) != ' ') {
        break;
      }
      end--;
    }
    int start = end;
    while (start >= 0) {
      if (s.charAt(start) == ' ') {
        break;
      }
      start--;
    }
    return end < 0 ? 0 : end - start;
  }
}
