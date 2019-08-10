package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0008M_StringToInteger_atoi {


  /* =============================================================================================
      comment
      " +42 " => "42"
      " +423BA" => "423"
      " 4b0c"  => "4"
      " +12312312312312312312312312313123" => Integer.MAX
      " -12312312312312312312312312313123" => Integer.MIN
      null => 0
      "" => 0
      "+" => 0
      "-" => 0
     ============================================================================================= */
  public int myAtoi(String str) {
    // return 0
    if (null == str) {
      return 0;
    }
    String trimmed = str.trim();
    if (trimmed.isEmpty()) {
      return 0;
    }
    if ((trimmed.charAt(0) < '0' || trimmed.charAt(0) > '9')
      && trimmed.charAt(0) != '+' && trimmed.charAt(0) != '-') {
        return 0;
      }
    char[] cleanChars = new char[trimmed.length()];
    Arrays.fill(cleanChars, ' ');
    cleanChars[0] = trimmed.charAt(0);
    int j = 1;
    for (int i = 1; i < trimmed.length(); i++) {
      if (trimmed.charAt(i) >= '0' && trimmed.charAt(i) <= '9') {
        cleanChars[j++] = trimmed.charAt(i);
      } else {
        break;
      }
    }
    String target = new String(cleanChars).trim();
    int ans;
    if (target.equals("+") || target.equals("-")) {
      return 0;
    }
    try {
      ans = Integer.valueOf(target);
    } catch (Exception e) {
      if (target.charAt(0) == '-') {
        ans = Integer.MIN_VALUE;
      } else {
        ans = Integer.MAX_VALUE;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    N0008M_StringToInteger_atoi runner = new N0008M_StringToInteger_atoi();
    int ans = runner.myAtoi("922394932749723947912379479123794791284");
    System.out.println(ans);
  }
}
