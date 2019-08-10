package com.maverickbyte.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0003M_LengthOfLongestSubstring {


  // brutal-force
  public int lengthOfLongestSubstring1(String s) {

    return 0;
  }


  // sliding window: better code
  public int lengthOfLongestSubstring2(String s) {
    int size = s.length();
    HashSet<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < size && j < size) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }

  // sliding window: jump i quickly
  /*
   * My Solution:
   * 这种解法比较难以理解。。。。
   *
   * 该方法中 i = Math.max(map.get(s.charAt(j)), i);是因为滑动窗口i时可能会跳过一些元素，而被跳过
   * 的元素还在hashSet中，即hashSet中放的不全是当前窗口里的元素，put只更新了重复元素的位置。
   * 这时containsKey()==true对当前窗口来说是错的，无需改变i。可用序列cbabcb分析
   *
   */
  public int lengthOfLongestSubstring3(String s) {
    int size = s.length();
    if (null == s || size == 0) {
      return 0;
    }

    int ans = 0;
    // char a -> the biggest idx of char a for now
    Map<Character, Integer> map = new HashMap<>();
    int i = 0;
    int j = 0;
    while (i <= j && j < size) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(i, map.get(s.charAt(j) + 1));
      }
      ans = Math.max(ans, j - i + 1);
      map.put(s.charAt(j), j);
      j++;
    }
    return ans;
  }

  //  map改为用编码的字典映射
  //  int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
  //  int [128] 用于ASCII码
  //  int [256] 用于扩展ASCII码
  public int lengthOfLongestSubstring4(String s) {
    int n = s.length(), ans = 0;
    // current index of character, the value is the latest index of char a.
    int[] index = new int[128];
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
      i = Math.max(index[s.charAt(j)], i);
      ans = Math.max(ans, j - i + 1);
      index[s.charAt(j)] = j + 1;
    }
    return ans;
  }
}
