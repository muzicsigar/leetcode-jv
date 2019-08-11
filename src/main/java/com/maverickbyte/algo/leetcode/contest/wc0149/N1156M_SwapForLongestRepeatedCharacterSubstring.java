package com.maverickbyte.algo.leetcode.contest.wc0149;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N1156M_SwapForLongestRepeatedCharacterSubstring {



  public int maxRepOpt1(String text) {
    Map<Character, Integer> charCountMap = new HashMap<>();
    int len = text.length();
    for (int i = 0; i < len; i++) {
      char key = text.charAt(i);
      if (charCountMap.containsKey(key)) {
        charCountMap.put(key, charCountMap.get(key) + 1);
      } else {
        charCountMap.put(key, 1);
      }
    }
    if (charCountMap.size() == 1) {
      return len;
    }

    int max = 0;
    for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
      Character ch = entry.getKey();
      Integer total = entry.getValue();
      for (int i = 0; i < len; i++) {
        int count = 0;
        for (int j = i; j < len; j++) {
          char cur = text.charAt(j);
          if (ch != cur && count + 1 == j - i) {
            break;
          }
          if (ch == cur && (count == j - i || count + 1 == j - i)) {
            count++;
          }
        }
        if (count < total) {
          count++;
        }
        max = Math.max(max, count);
      }
    }
    return max;
  }
}
