package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0038E_CountAndSay {


  /* =============================================================================================
      comment
      1 -> 11
      11 -> 21
      21 -> 1211
      12 -> 1112
      111 -> 31
     ============================================================================================= */


  public String countAndSay(int n) {
    String cur = "1";
    int i = 0;
    while (i < n - 1) { // 需要在原始："1"的基础上递归几次
      StringBuilder next = new StringBuilder();
      int count = 1;
      int j = 1;
      while (j < cur.length()) {
        if (cur.charAt(j) == cur.charAt(j - 1)) {
          count++;
        } else {
          next.append(count).append(cur.charAt(j - 1));
          count = 1;
        }
        j++;
      }
      next.append(count).append(cur.charAt(j - 1));
      cur = next.toString();
      i++;
    }
    return cur;
  }


  public static void main(String[] args) {
    N0038E_CountAndSay runner = new N0038E_CountAndSay();
    String ans = runner.countAndSay(10);
    System.out.println(ans);
  }
}
