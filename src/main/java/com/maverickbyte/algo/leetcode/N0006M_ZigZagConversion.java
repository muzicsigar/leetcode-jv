package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0006M_ZigZagConversion {


  public String convert1(String s, int numRows) {
    if (null == s || s.length() == 0) {
      return "";
    }
    if (numRows <= 1) {
      return s;
    }
    StringBuilder[] sbs = new StringBuilder[Math.min(numRows, s.length())];
    for (int i = 0; i < sbs.length; i++) {
      sbs[i] = new StringBuilder();
    }
    int j = 0;
    boolean add = true;
    for (int i = 0; i < s.length(); i++) {
      sbs[j].append(s.charAt(i));

      if(j == numRows - 1) {
        add = false;
      } else if(j == 0) {
        add = true;
      }

      if(add) {
        j++;
      } else {
        j--;
      }
    }
    for (int i = 1; i < sbs.length; i++) {
      sbs[0].append(sbs[i]);
    }
    return sbs[0].toString();
  }

}
