package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0010H_RegularExpressionMatching {


  /* =============================================================================================
       solution 1: https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan
       -fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/
       solution 2: https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai
       -gui-hua-by-powcai/
     ============================================================================================= */

  public boolean isMatch(String s, String p) {
    if (null == p || null == s) {
      throw new NullPointerException();
    }
    this.memo = new HashMap<>();
    this.s = s;
    this.p = p;
    return dp(0, 0);
  }

  private HashMap<Pair<Integer, Integer>, Boolean> memo;
  private String s;
  private String p;

  private boolean dp(int i, int j) {
    Pair<Integer, Integer> key = Pair.of(i, j);
    Boolean ans = memo.get(key);
    if (ans != null) {
      return ans;
    }
    if (j == p.length()) {
      return i == s.length();
    }

    boolean fstLetterMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

    if (j + 2 < p.length() && p.charAt(j + 1) == '*') {
      ans = dp(i, j + 2) || (fstLetterMatch && dp(i + 1, j));
    } else {
      ans = fstLetterMatch && dp(i + 1, j + 1);
    }
    memo.put(key, ans);
    return ans;
  }
}
