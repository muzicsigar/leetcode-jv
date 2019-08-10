package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0161M_OneEditDistance {

  public boolean isOneEditDistance1(String s, String t) {
    if (null == s || null == t) {
      throw new NullPointerException();
    }
    int sLen = s.length();
    int tLen = t.length();
    if (sLen == 0) {
      return tLen == 1;
    }
    if (tLen == 0) {
      return sLen == 1;
    }
    // insert
    if (sLen + 1 == tLen) {
      int j = 0;
      int i = 0;
      for (; i < sLen; i++) {
        if (s.charAt(i) != t.charAt(i)) {
          j = i + 1;
          break;
        }
      }
      if (i == sLen) {
        return true;
      }
      for (; j < tLen; j++) {
        if (s.charAt(j - 1) != t.charAt(j)) {
          return false;
        }
      }
      return true;
    }
    // delete
    if (sLen - 1 == tLen) {
      int j = 0;
      int i = 0;
      for (; i < tLen; i++) {
        if (t.charAt(i) != s.charAt(i)) {
          j = i + 1;
          break;
        }
      }
      if (i == tLen) {
        return true;
      }
      for (; j < sLen; j++) {
        if (t.charAt(j - 1) != s.charAt(j)) {
          return false;
        }
      }
      return true;
    }
    // replace
    if (sLen == tLen) {
      int count = 0;
      for (int i = 0; i < sLen; i++) {
        if (s.charAt(i) != t.charAt(i)) {
          count++;
        }
        if (count > 1) {
          return false;
        }
      }
      return count != 0;
    }
    // 代码可以通过subtring进行下简化，但思路就是这样的。
    // if (ns == nt)
    //  return s.substring(i + 1).equals(t.substring(i + 1));
    return false;
  }

  public static void main(String[] args) {
    String s = "abdf";
    String t = "abdef";
    N0161M_OneEditDistance runner = new N0161M_OneEditDistance();
    System.out.println(runner.isOneEditDistance1(s, t));
    ;
  }
}
