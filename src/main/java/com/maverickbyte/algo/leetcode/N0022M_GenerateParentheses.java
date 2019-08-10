package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0022M_GenerateParentheses {


  public List<String> generateParenthesis(int n) {
    if (n < 1) {
      return new ArrayList<>();
    }
    this.n = n;
    ArrayList<String> ans = new ArrayList<>();
    backtrack(0, 0, 0, new LinkedList<>(), new char[n * 2], ans);
    return ans;
  }

  private int n;

  private void backtrack(int left, int right, int depth,
                         LinkedList<Character> stack, char[] pre,
                         List<String> ans) {
    if (depth == pre.length) {
      ans.add(new String(pre));
      return;
    }

    if (left < n) { // cutoff condition
      pre[depth] = '(';
      stack.push('(');
      backtrack(left + 1, right, depth + 1, stack, pre, ans);
      pre[depth] = 0;
      stack.pop();
    }

    if (right < n) { // cutoff condition
      pre[depth] = ')';
      if (stack.peek() == null) { // cutoff condition
        return;
      } else {
        stack.pop();
      }
      backtrack(left, right + 1, depth + 1, stack, pre, ans);
      pre[depth] = 0;
      stack.push('(');
    }
  }


}
