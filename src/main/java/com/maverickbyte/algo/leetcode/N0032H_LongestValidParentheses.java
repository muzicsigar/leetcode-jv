package com.maverickbyte.algo.leetcode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0032H_LongestValidParentheses {

  /* =============================================================================================
      solution 1: brutal-force
     ============================================================================================= */
  public int longestValidParentheses1(String s) {
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j += 2) {
        if (isValid(s.substring(i, j + 1))) {
          max = Math.max(max, j - i + 1);
        }
      }
    }
    return max;
  }

  private boolean isValid(String s) {
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (stack.isEmpty() || stack.pop().equals(')')) {
          return false;
        }
      } else {
        stack.push('(');
      }
    }
    return stack.isEmpty();
  }


  /* =============================================================================================
      solution 2: dp
      state: dp[i]: 以0开始，以i结束的子串中的最长有效括号长度
      STE:
        when s[i-1, i] == "()": dp[i] = dp[i - 2] + 2;
        when s[i-1, i] == "))" && dp[i - dp[i - 1] - 1] == '(':
          dp[i] = dp[i - 1] + dp[ i - dp[i- 1] - 2] + 2

     ============================================================================================= */
  public int longestValidParentheses2(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    int len = s.length();
    int[] dp = new int[len];
    int max = 0;
    for (int i = 1; i < len; i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
          max = Math.max(max, dp[i]);
          continue;
        }
        if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
          max = Math.max(max, dp[i]);
        }
      }
    }
    return max;
  }


  /* =============================================================================================
      solution 3: 使用栈
      与找到每个可能的子字符串后再判断它的有效性不同，我们可以用栈在遍历给定字符串的过程中去判断到目前为止扫描的
      子字符串的有效性，同时能的都最长有效字符串的长度。我们首先将 -1 放入栈顶。

      对于遇到的每个 ‘(’ ，我们将它的下标放入栈中。
      对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与弹出元素下标作差，得出当前有效括号字符串的长度。
      通过这种方法，我们继续计算有效子字符串的长度，并最终返回最长有效子字符串的长度。
     ============================================================================================= */
  public int longestValidParentheses3(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    LinkedList<Integer> stack = new LinkedList<>();
    stack.push(-1);
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          max = Math.max(max, i - stack.peek());
        }
      }
    }
    return max;
  }

  public int longestValidParentheses4(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    int left = 0, right = 0, max = 0;
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '(') {
        left++;
      }else {
        right ++;
      }

      if(left == right) {
        max = Math.max(max, left * 2);
      }
      if(right > left) {
        left = right = 0;
      }
    }

    left = right = 0;
    for(int i = s.length() - 1; i >= 0; i--) {
      if(s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if(left == right) {
        max = Math.max(max, left * 2);
      }
      if(left > right) {
        left = right = 0;
      }
    }
    return max;
  }
}
