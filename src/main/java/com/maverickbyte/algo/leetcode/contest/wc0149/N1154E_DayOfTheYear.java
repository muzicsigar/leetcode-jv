package com.maverickbyte.algo.leetcode.contest.wc0149;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N1154E_DayOfTheYear {

  private static final int[] base = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public int dayOfYear(String date) {
    int year = Integer.parseInt(date.substring(0, 4));
    int mon = Integer.parseInt(date.substring(5, 7));
    int ans = Integer.parseInt(date.substring(8, 10));
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
      base[2]++;
    }
    for (int i = 1; i < mon; i++) {
      ans += base[i];
    }
    return ans;
  }
}

