package com.maverickbyte.algo.leetcode.contest.wc0150;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N5048E_FindWordsThatCanBeFormedByCharacters {


  public int countCharacters(String[] words, String chars) {

    int[] dic = new int[128];
    for (int i = 0; i < chars.length(); i++) {
      dic[chars.charAt(i)]++;
    }

    int ans = 0;
    for (String word : words) {
      int i = 0;
      int[] temp = Arrays.copyOf(dic, dic.length);
      for (; i < word.length(); i++) {
        if(--temp[word.charAt(i)] < 0) {
          break;
        }
      }
      if( i == word.length()) {
        ans += word.length();
      }
    }
    return ans;
  }
}
