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


  public int myAtoi2(String str) {
    int i = 0, j = 0, len = str.length();
    boolean negative = false;
    for (i = 0; i < len; i++) {
      if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
        break;
      } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
        negative = str.charAt(i) == '-';
        i++;
        break;
      } else if (str.charAt(i) != ' ') {
        return 0;
      }
    }
    for (j = i; j < len; j++) {
      if (str.charAt(j) < '0' || '9' < str.charAt(j)) {
        break;
      }
    }
    int ret = 0;
    String num = str.substring(i, j);
    for (int x = 0; x < num.length(); x++) {
      int cur = num.charAt(x) - '0';
      if (negative) {
        //这里判断溢出的情况和第7题一样
        if (ret < Integer.MIN_VALUE / 10 || ret == Integer.MIN_VALUE / 10 && cur > 8) {
          return Integer.MIN_VALUE;
        }
        ret = ret * 10 - cur;
      } else {
        if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
          return Integer.MAX_VALUE;
        }
        ret = ret * 10 + cur;
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    N0008M_StringToInteger_atoi runner = new N0008M_StringToInteger_atoi();
    int ans = runner.myAtoi("922394932749723947912379479123794791284");
    System.out.println(ans);
  }
}
