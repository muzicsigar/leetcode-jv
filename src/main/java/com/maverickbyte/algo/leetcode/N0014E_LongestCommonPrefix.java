package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0014E_LongestCommonPrefix {

  /*
   * 重点学习这道题的不同解法， 面对一个问题，我们分别可以从哪些方面入手。
   */

  /* =============================== brutal-force ==================================*/
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }

    boolean flag = true;
    int targetCharIndex = 0;
    int targetChar = 0;
    while (flag) {
      for (int k = 0; k < strs.length; k++) {
        if (targetCharIndex == strs[k].length()) {
          flag = false;
          break;
        }
        if (k == 0) {
          targetChar = strs[0].charAt(targetCharIndex);
        } else if (targetChar != strs[k].charAt(targetCharIndex)) {
          flag = false;
          break;
        }
      }
      if(!flag) {
        break;
      }
      targetCharIndex++;
    }
    return strs[0].substring(0, targetCharIndex);
  }





}
