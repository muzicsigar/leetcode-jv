package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0007E_ReverseInteger {

  public int reverse1(int x) {
    long ans = 0;
    while (x != 0) {
      ans = ans * 10 + x % 10;
      x = x / 10;
    }
    if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
      ans = 0;
    }
    return (int) ans;
  }


  public int reverse2(int x) {
    int rev = 0;
    while (x != 0) {
      x /= 10;
      int pop = x % 10;
      if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
      if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
      rev = rev * 10 + pop;
    }
    return rev;
  }

  public static void main(String[] args) {
    int a = 1534236469;
    int b = 2147483647;
    System.out.println(Integer.MAX_VALUE);
    System.out.println( -12 % 10);
  }
}
