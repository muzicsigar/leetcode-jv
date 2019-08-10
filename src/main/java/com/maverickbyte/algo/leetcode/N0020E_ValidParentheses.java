package com.maverickbyte.algo.leetcode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0020E_ValidParentheses {


  public boolean isValid(String s) {
    if (null == s) {
      throw new NullPointerException();
    }
    if (s.length() == 0) {
      return true;
    }
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        Character last = stack.peek();
        if (last == null) {
          return false;
        }
        if ((last.equals('(') && c == ')')
          || (last.equals('[') && (c == ']'))
          || (last.equals('{') && c == '}')) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.size() == 0;
  }
}
