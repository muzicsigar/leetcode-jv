package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0043M_MultiplyStrings {

  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    int m = num1.length();
    int n = num2.length();
    char[] nums1 = num1.toCharArray();
    char[] nums2 = num2.toCharArray();

    int[] res = new int[m + n];

    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        res[i + j + 1] = res[i + j + 1] + (nums1[i] - '0') * (nums2[j] - '0');
      }
    }

    // let num1.length = 3, num2.len = 4 =>  01000000 <= num1 * num2 < 9999000
    // res[0] <= 9, i >= 0 is OK, but i > 0 is better.
    for (int i = m + n - 1; i > 0; i--) {
      if (res[i] > 9) {
        res[i - 1] = res[i - 1] + res[i] / 10;
        res[i] = res[i] % 10;
      }
    }
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i <= m + n - 1; i++) {
      sb.append(res[i]);
    }
    if (sb.charAt(0) == '0') {
      sb = sb.deleteCharAt(0);
    }

    return sb.toString();
  }

}
