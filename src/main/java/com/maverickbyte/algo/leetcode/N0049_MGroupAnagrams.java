package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0049_MGroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    if(null == strs || strs.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(s);
    }
    return new ArrayList<>(map.values());
  }


  public List<List<String>> groupAnagrams2(String[] strs) {
    if (strs.length == 0) return new ArrayList();
    Map<String, List> ans = new HashMap<>();
    int[] count = new int[26];
    for (String s : strs) {
      Arrays.fill(count, 0);
      for (char c : s.toCharArray()) count[c - 'a']++;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        sb.append('#');
        sb.append(count[i]);
      }
      String key = sb.toString(); // key: ＃1＃2＃3＃0＃0＃0 ...＃0
      if (!ans.containsKey(key)) {
        ans.put(key, new ArrayList());
      }
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

}
