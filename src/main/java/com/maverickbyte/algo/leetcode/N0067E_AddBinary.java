package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0067E_AddBinary {


  public String addBinary(String a, String b) {
    if(a == null || b== null) {
      throw new NullPointerException();
    }
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int x = i >= 0 ? a.charAt(i--) - '0' : 0;
      int y = j >= 0 ? b.charAt(j--) - '0' : 0;
      int sum = carry + x + y;
      int ans = sum % 2;
      carry = sum / 2;
      sb.append(ans);
    }
    if (carry > 0) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }
}
