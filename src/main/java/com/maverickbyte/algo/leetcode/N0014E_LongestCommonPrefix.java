package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0014E_LongestCommonPrefix {

  public String longestCommonPrefix1(String[] strs) {
    if (null == strs || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    int i = 0;
    while (true) {
      int j = 0;
      while (j < strs.length - 1) {
        String cur = strs[j];
        String next = strs[j + 1];
        if (i == cur.length() || i == next.length() || cur.charAt(i) != next.charAt(i)) {
          break;
        }
        j++;
      }
      if (j == strs.length - 1) {
        i++;
      } else {
        break;
      }
    }
    if (i > 0) {
      return strs[0].substring(0, i);
    } else {
      return "";
    }
  }

  /* =============================================================================================
      divide and conquer
     ============================================================================================= */
  public String longestCommonPrefix2(String[] strs) {
    if (null == strs || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    return commonPrefix(strs, 0, strs.length - 1);
  }

  private String commonPrefix(String[] strs, int left, int right) {
    if (left == right) {
      return strs[left];
    }
    int mid = (left + right) / 2;
    String str1 = commonPrefix(strs, left, mid);
    String str2 = commonPrefix(strs, mid + 1, right);
    int minLen = Math.min(str1.length(), str2.length());
    int endIdx = -1;
    for (int i = 0; i < minLen; i++) {
      if (str1.charAt(i) == str2.charAt(i)) {
        endIdx = i;
      } else {
        break;
      }
    }
    return endIdx >= 0 ? str1.substring(0, endIdx + 1) : "";
  }




}
