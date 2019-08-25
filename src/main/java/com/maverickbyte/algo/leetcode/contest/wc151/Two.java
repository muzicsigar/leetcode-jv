package com.maverickbyte.algo.leetcode.contest.wc151;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class Two {

  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    int[] ans = new int[queries.length];

    int[] cmp = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      cmp[i] = f(words[i]);
    }
    Arrays.sort(cmp);

    for (int i = 0; i < ans.length; i++) {
      if (i > cmp.length) {
        break;
      }
      int tmp = f(queries[i]);
      int j = 0;
      while (j < cmp.length) {
        if (tmp >= cmp[j]) {
          j++;
        } else {
          break;
        }
      }
      ans[i] = cmp.length - j;
    }

    return ans;
  }

  private int f(String word) {
    int[] count = new int[26];
    for (int i = 0; i < word.length(); i++) {
      count[word.charAt(i) - 'a']++;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] > 0) {
        return count[i];
      }
    }
    throw new IllegalStateException();
  }
}
