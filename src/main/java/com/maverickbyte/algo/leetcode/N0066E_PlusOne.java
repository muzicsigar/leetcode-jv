package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0066E_PlusOne {

  public int[] plusOne(int[] digits) {

    int len = digits.length;

    digits[len - 1]++;
    int carry = 0;
    if (digits[len - 1] == 10) {
      digits[len - 1] = 0;
      carry = 1;
    }
    for (int i = len - 2; i >= 0; i--) {
      int sum = digits[i] + carry;
      digits[i] = sum % 10;
      carry = sum / 10;
    }

    if (carry == 0) {
      return digits;
    } else {
      int[] ans = new int[len + 1];
      for (int i = 1; i < ans.length; i++) {
        ans[i] = digits[i - 1];
      }
      ans[0] = 1;
      return ans;
    }
  }
}
