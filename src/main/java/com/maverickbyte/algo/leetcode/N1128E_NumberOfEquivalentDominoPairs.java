package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N1128E_NumberOfEquivalentDominoPairs {

  // brutal-force + state saving
  public int numEquivDominoPairs1(int[][] dominoes) {
    if (null == dominoes || dominoes.length < 2) {
      return 0;
    }
    boolean[] used = new boolean[dominoes.length];
    int ans = 0;
    for (int i = 0; i < dominoes.length - 1; i++) {
      if (used[i]) {
        continue;
      }
      int candidates = 0;
      for (int j = i + 1; j < dominoes.length; j++) {
        if (dominoes[i].length != dominoes[j].length) {
          continue;
        }
        int len = dominoes[i].length;
        int count = len;
        for (int k = 0; k < len; k++) {
          if (dominoes[i][k] != dominoes[j][k]) {
            break;
          } else {
            --count;
          }
        }
        if (count == 0) {
          ++candidates;
          used[j] = true;
          continue;
        }
        count = len;
        for (int k = 0; k < len; k++) {
          if (dominoes[i][k] != dominoes[j][len - 1 - k]) {
            break;
          } else {
            --count;
          }
        }
        if (count == 0) {
          ++candidates;
          used[j] = true;
        }
      }

      while (candidates > 0) {
        ans += candidates;
        candidates--;
      }
      used[i] = true;
    }

    return ans;
  }

}
