package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0029M_DivideTwoIntegers {

  /* =============================================================================================
      特殊情况：-INF / 1, abs(x) > INF ???
     ============================================================================================= */
  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE) {
      if (divisor == 1) {
        return Integer.MIN_VALUE;
      }
      if (divisor == -1) {
        return Integer.MAX_VALUE;
      }
    }
    if(divisor == Integer.MIN_VALUE){
      return dividend == Integer.MIN_VALUE ? 1 : 0;
    }
    boolean isPositive = true;
    if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
      isPositive = false;
    }
    divisor = Math.abs(divisor);
    int count = 0;
    if (dividend == Integer.MIN_VALUE) {
      dividend += divisor;
      count++;
    }
    dividend = Math.abs(dividend);
    return isPositive ? count + divide0(dividend, divisor) : -(count + divide0(dividend,
      divisor));
  }

  private int divide0(int dividend, int divisor) {
    if (dividend < divisor) {
      return 0;
    }
    int d = divisor;
    int count = 1;
    while (Integer.MAX_VALUE - d >= d && (d + d) <= dividend) {
      d += d;
      count += count;
    }
    return count + divide0(dividend - d, divisor);
  }


  public static void main(String[] args) {
    N0029M_DivideTwoIntegers runner = new N0029M_DivideTwoIntegers();
    int ans = runner.divide(Integer.MAX_VALUE, 2);
    System.out.println(ans);
  }
}
