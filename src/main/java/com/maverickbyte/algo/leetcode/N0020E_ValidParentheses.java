package com.maverickbyte.algo.leetcode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0020E_ValidParentheses {


  public boolean isValid(String s) {
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        Character cmp = stack.pop();
        if (ch == ')' && !cmp.equals('(')
          || ch == ']' && !cmp.equals('[')
          || ch == '}' && !cmp.equals('{')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
