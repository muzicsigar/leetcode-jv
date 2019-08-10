package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0567M_PremutationInString {

  public boolean checkInclusion(String s1, String s2) {
    if (null == s1 || null == s2
      || s1.length() == 0
      || s2.length() == 0
      || s1.length() > s2.length()) {
      return false;
    }

    int[] record = new int[128];
    for (char c : s1.toCharArray()) {
      record[c]++;
    }

    char[] arr = s2.toCharArray();
    int l = 0, r = 0;
    int len = s1.length();


    // s1:  abcabc
    // s2:  abcbccaab
    while (r < s2.length()) {
      if (record[arr[r]] > 0) {
        record[arr[r]]--;
        r++;
        if ((r - l) == len) {
          return true;
        }
      } else {
        // 这一步牛逼了， 把以前record数组中减去的记录又给加回来了. l 滑动到 s2的 abcb, c被减去一个，r又开始走了。
        record[arr[l]]++;
        l++;
      }

    }
    return false;
  }


  public boolean checkInclusion1(String s1, String s2) {
    if (null == s1 || null == s2 || s1.length() == 0 || s2.length() == 0) {
      return false;
    }

    int[] buckets = new int[256];
    for (int i = 0; i < s1.length(); i++) {
      buckets[s1.charAt(i)]++;
    }
    for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
      int[] tempBuckets = Arrays.copyOf(buckets, buckets.length);
      for (int j = i; j < s2.length(); j++) {
        if (tempBuckets[s2.charAt(j)] == 0) {
          break;
        } else {
          tempBuckets[s2.charAt(j)]--;
        }
      }
      int sum = 0;
      for (int k = 0; k < tempBuckets.length; k++) {
        sum += tempBuckets[k];
      }
      if (sum == 0) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {

    // s1:  abcabc
    // s2:  abcbccaab
    String s1 = "abcabc";
    String s2 = "abcbccaab";
    boolean b = new N0567M_PremutationInString().checkInclusion(s1, s2);
    System.out.println(b);
  }
}
