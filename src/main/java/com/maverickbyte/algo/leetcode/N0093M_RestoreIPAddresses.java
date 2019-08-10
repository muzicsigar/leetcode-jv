package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0093M_RestoreIPAddresses {


  /* ===================== brutal-force ================================*/
  public List<String> restoreIpAddresses1(String s) {
    List<String> ans = new ArrayList<>();
    int n = s.length();
    for (int i = 0; i < 3; i++) {
      for (int j = i + 1; j < i + 4; j++) {
        for (int k = j + 1; k < j + 4; k++) {
          if (i < n && j < n && k < n) {
            String segment1 = s.substring(0, i + 1);
            String segment2 = s.substring(i + 1, j + 1);
            String segment3 = s.substring(j + 1, k + 1);
            String segment4 = s.substring(k + 1);
            if (valid0(segment1) && valid0(segment2) && valid0(segment3) && valid0(segment4))
              ans.add(segment1 + "." + segment2 + "." + segment3 + "." + segment4);
          }
        }
      }
    }
    return ans;
  }


  /*
   * Check if the current segment is valid :
   * 1. less or equal to 255
   * 2. the first character could be '0' only if the segment is equal to '0'
   */
  private boolean valid0(String segment) {
    if (segment == null || segment.length() == 0 || segment.length() > 3
      || (segment.charAt(0) == '0' && segment.length() > 1)
      || Integer.parseInt(segment) > 255) {
      return false;
    }
    return true;
  }


  /* ===================== backtracking ================================*/

  public List<String> restoreIpAddresses2(String s) {
    List<String> ips = new ArrayList<>();
    backtrack(s, 0, 4, "", ips);
    return ips;
  }

  private boolean check(String s, int i, int j) {
    if (i == j && s.charAt(j) == '0') {
      return true;
    }
    if (s.charAt(i) != '0' && Integer.valueOf(s.substring(i, j + 1)) <= 255) {
      return true;
    }
    return false;
  }

  public void backtrack(String s, int i, int flag, String temp, List<String> ips) {
    // find a ip
    if (i == s.length() && flag == 0) {
      ips.add(temp.substring(0, temp.length() - 1));
      return;
    }

    // 没有这一句， leetcode timeout。还有这一句就是传说中的剪枝吗？
    if (flag < 0) {
      return;
    }

    for (int j = i; j < i + 3 && j < s.length(); j++) {
      if (check(s, i, j)) {
        backtrack(s, j + 1, flag - 1, temp + s.substring(i, j + 1) + ".", ips);
      }
    }
  }


}
