package com.maverickbyte.algo.leetcode.contest.wc0152;

/**
 * @author Alan Li
 * @since 1.0
 */
public class Two {

  public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
    int score = 0;
    int len = calories.length;
    int round = len % k;

    int start = 0;
    while (start <= round) {
      int i = start;
      System.out.println("start : " + i);

      while (i  < len) {
        int tmp = k;
        int t = 0;
        while (tmp > 0 && i < len) {
          t += calories[i++];
          tmp--;
        }
        if(tmp > 0) {
          continue;
        }
        if (t < lower) {
          score--;
        } else if (t > upper) {
          score++;
        }
      }
      System.out.println("score: " + score);
      start++;
    }
    return score;
  }
}
