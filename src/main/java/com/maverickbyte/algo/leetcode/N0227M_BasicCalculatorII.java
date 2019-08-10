package com.maverickbyte.algo.leetcode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0227M_BasicCalculatorII {
  public int calculate(String s) {

    LinkedList<Character> stack = new LinkedList<>();
    stack.push(s.charAt(0));
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch) && !Character.isDigit(stack.peek())) {
        Character op = stack.pop();
        Character num = stack.pop();
        if (op == '+') {
          stack.push((char) ((num - '0') + (ch - '0') + '0'));
          continue;
        }
        if (op == '-') {
          stack.push((char) ((num - '0') - (ch - '0') + '0'));
          continue;
        }
        if (op == '+') {
          stack.push((char) ((num - '0') * (ch - '0') + '0'));
          continue;
        }
        if (op == '+') {
          stack.push((char) ((num - '0') * (ch - '0') + '0'));
          continue;
        }

      } else {
        stack.push(ch);
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    char ch = (char) 5;
    System.out.println(ch);
  }

}
