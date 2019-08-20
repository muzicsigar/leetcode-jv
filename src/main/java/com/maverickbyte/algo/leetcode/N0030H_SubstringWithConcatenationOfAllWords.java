package com.maverickbyte.algo.leetcode;

import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0030H_SubstringWithConcatenationOfAllWords {

  /* =============================================================================================
      comment
     ============================================================================================= */
  public List<Integer> findSubstring(String s, String[] words) {
    int len = 0;
    for (String word : words) {
      len += word.length();
    }
    for (int i = 0; i <= s.length() - len; i++) {

      boolean[] used = new boolean[words.length];
      for (int j = 0; j < words.length; j++) {
        String word = words[j];
        if (used[j] || word.charAt(0) != s.charAt(i)) {
          continue;
        }
        int cur = i;
        for (int k = 0; k < word.length(); k++) {
          if (s.charAt(cur) == word.charAt(k)) {
            cur++;
            k++;
          } else {
            break;
          }
        }
        if (cur - i == word.length()) {
          i = cur;
        } else {
          i++;
        }
      }
    }
    return null;
  }

}
