package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0005M_LongestPalindromicSubstring {

  /* =============================================================================================
      solution 1: 中心扩展算法
      [0, 1, 2, 3, 4] => [0, #, 1, #, 2, #, 3, # 4], c 切在数字上为奇数中点，切在"#"上面为偶数中点
      同时 leftCenter = (c - 1) / 2, rightCenter = c / 2
     ============================================================================================= */
  public String longestPalindrome1(String s) {
    if (null == s || s.length() <= 1) {
      return s;
    }
    int max = 1, left = 0, right = 0, len = s.length();
    for (int i = 1; i < 2 * len; i++) {
      int l = (i - 1) / 2;
      int r = i / 2;
      if (s.charAt(l) != s.charAt(r)) {
        continue;
      }
      while (l - 1 >= 0 && r + 1 <= len - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
        l--;
        r++;
      }
      if (max < r - l + 1) {
        max = r - l + 1;
        left = l;
        right = r;
      }
    }
    return s.substring(left, right + 1);
  }


  /* =============================================================================================
      solution 2: DP
     ============================================================================================= */
  public String longestPalindrome2(String s) {
    if (null == s || s.length() <= 1) {
      return s;
    }
    int max = 1, left = 0, right = 0, len = s.length();
    boolean[][] dp = new boolean[len][len];
    for (int r = 1; r < len; r++) {
      for (int l = 0; l < r; l++) {
        if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
          dp[l][r] = true;
          if (r - l + 1 > max) {
            max = r - l + 1;
            left = l;
            right = r;
          }
        }
      }
    }
    return s.substring(left, right + 1);
  }


  /* =============================================================================================
      solution 3: Manacher's Algorithm
     ============================================================================================= */
  public String longestPalindrome3(String s) {
    return null;
  }

}
