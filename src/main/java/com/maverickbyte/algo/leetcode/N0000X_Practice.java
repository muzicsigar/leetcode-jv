package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0000X_Practice {


  public String multiply(String num1, String num2) {
    if (num1.length() > num2.length()) {
      String tmp = num1;
      num1 = num2;
      num2 = tmp;
    }

    List<List<Integer>> lists = new ArrayList<>();
    for (int i = num1.length() - 1; i >= 0; i--) {
      int num = num1.charAt(i) - '0';
      int zeros = num1.length() - i - 1;
      while (num > 0) {
        List<Integer> l = toList(num2);
        while (zeros > 0) {
          l.add(0, 0);
          zeros--;
        }
        lists.add(l);
        num--;
      }
    }
    if (lists.isEmpty()) {
      return "0";
    }
    List<Integer> sum = add(lists, 0, lists.size() - 1);
    StringBuilder sb = new StringBuilder();
    for (int i = sum.size() - 1; i >= 0; i--) {
      sb.append(sum.get(i));
    }
    return sb.toString();
  }

  private List<Integer> add(List<List<Integer>> lists, int left, int right) {
    if (left == right) {
      return lists.get(left);
    }

    int mid = (left + right) / 2;
    List<Integer> l1 = add(lists, left, mid);
    List<Integer> l2 = add(lists, mid + 1, right);

    List<Integer> ans = new ArrayList<>();
    int len = l1.size() > l2.size() ? l1.size() : l2.size();

    int carry = 0;
    for (int i = 0; i < len; i++) {
      int x = l1.size() <= i ? 0 : l1.get(i);
      int y = l2.size() <= i ? 0 : l2.get(i);
      int sum = x + y + carry;

      carry = sum / 10;
      ans.add(sum % 10);
    }
    if (carry > 0) {
      ans.add(carry);
    }
    return ans;
  }

  private List<Integer> toList(String num2) {
    List<Integer> l = new ArrayList<>();
    for (int i = num2.length() - 1; i >= 0; i--) {
      l.add(num2.charAt(i) - '0');
    }
    return l;
  }


  public static void main(String[] args) {
    N0000X_Practice r = new N0000X_Practice();
    String multiply = r.multiply("21231231212312412342142134123"
      , "1");
    System.out.println(multiply);
  }
}



