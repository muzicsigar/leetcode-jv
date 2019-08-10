package com.maverickbyte.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0013E_RomanToInteger {

  /* =============================================================================================
      字符          数值
      I             1
      V             5
      X             10
      L             50
      C             100
      D             500
      M             1000


     ============================================================================================= */

  private static final Map<String, Integer> map = new HashMap<>();

  static {
    map.put("I", 1);
    map.put("IV", 4);
    map.put("V", 5);
    map.put("IX", 9);
    map.put("X", 10);
    map.put("XL", 40);
    map.put("L", 50);
    map.put("XC", 90);
    map.put("C", 100);
    map.put("CD", 400);
    map.put("D", 500);
    map.put("CM", 900);
    map.put("M", 1000);
  }

  public int romanToInt(String s) {
    int ans = 0;
    int i = 0;
    while (i < s.length()) {
      if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
        ans += map.get(s.substring(i, i + 2));
        i += 2;
      } else {
        ans += map.get(s.substring(i, i + 1));
        i++;
      }
    }
    return ans;
  }


  public static void main(String[] args) {
    N0013E_RomanToInteger runner = new N0013E_RomanToInteger();
    System.out.println(runner.romanToInt("MCMXCIV"));
  }
}
