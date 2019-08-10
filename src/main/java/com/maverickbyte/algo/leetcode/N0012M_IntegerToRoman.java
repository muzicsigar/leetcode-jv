package com.maverickbyte.algo.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0012M_IntegerToRoman {


  /* =============================================================================================
      solution 1: 自己写的，太复杂了。
     ============================================================================================= */
  private static final Map<Integer, String> map = new HashMap<>();

  static {
    map.put(1, "I");
    map.put(5, "V");
    map.put(10, "X");
    map.put(50, "L");
    map.put(100, "C");
    map.put(500, "D");
    map.put(1000, "M");
    map.put(5000, "Bad");
    map.put(10000, "Bad");
  }

  public String intToRoman(int num) {

    int base = 1;
    LinkedList<String> tokens = new LinkedList<>();
    while (num > 0) {
      String b = map.get(base * 10);
      String m = map.get(base * 5);
      String s = map.get(base);
      int digit = num % 10;

      StringBuilder sb = new StringBuilder();
      if (digit == 0) {
        // do nothing
      } else if (digit < 4) {
        while (digit > 0) {
          sb.append(s);
          digit--;
        }
        tokens.addFirst(sb.toString());
      } else if (digit == 4) {
        tokens.addFirst(sb.append(s).append(m).toString());
      } else if (digit < 9) {
        sb.append(m);
        digit = digit - 5;
        while (digit > 0) {
          sb.append(s);
          digit--;
        }
        tokens.addFirst(sb.toString());
      } else {
        tokens.addFirst(sb.append(s).append(b).toString());
      }
      num = num / 10;
      base *= 10;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tokens.size(); i++) {
      sb.append(tokens.get(i));
    }
    return sb.toString();
  }


  /* =============================================================================================
      solution 2: 优化solution 1；
     ============================================================================================= */
  private static final Map<Integer, String> lookup = new HashMap<>();

  static {
    lookup.put(1, "I");
    lookup.put(4, "IV");
    lookup.put(5, "V");
    lookup.put(9, "IX");
    lookup.put(10, "X");
    lookup.put(40, "XL");
    lookup.put(50, "L");
    lookup.put(90, "XC");
    lookup.put(100, "C");
    lookup.put(400, "CD");
    lookup.put(500, "D");
    lookup.put(900, "CM");
    lookup.put(1000, "M");
  }

  public String intToRoman2(int num) {
    StringBuilder sb = new StringBuilder();
    for (Integer key :
      lookup.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
      int n = num / key;
      if (n == 0) {
        continue;
      }
      String val = lookup.get(key);
      int temp = n;
      while (temp > 0) {
        sb.append(val);
        temp--;
      }
      num -= n * key;
      if (num == 0) {
        break;
      }
    }
    return sb.toString();
  }


  /* =============================================================================================
      solution 3:  
      将可能的值用map全部映射出来：
      map.keys: 3000, 2000, 1000, 900, 800, 700, 600, 500, 400, 300, 200, 100, 90, 80, 70, 60, 50,
                40, 30, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
     ============================================================================================= */
  private static final String[] digit1 =
    {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
  private static final String[] digit10 =
    {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
  private static final String[] digit100 =
    {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
  private static final String[] digit1000 =
    {"", "M", "MM", "MMM"};

  public String intToRoman3(int num) {
    return new StringBuilder()
      .append(digit1000[(num % 10000) / 1000])
      .append(digit100[(num % 1000) / 100])
      .append(digit10[(num % 100) / 10])
      .append(digit1[(num % 10)]).toString();
  }

  public static void main(String[] args) {
    N0012M_IntegerToRoman runner = new N0012M_IntegerToRoman();
//    String s = runner.intToRoman(3);
    String s = runner.intToRoman2(3990);
    System.out.println(s);
  }
}
