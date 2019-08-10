package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0784E_LetterCasePermutation {


  public List<String> letterCasePermutation1(String S) {
    if (null == S || S.length() == 0) {
      return new ArrayList<>();
    }

    char[] pre = new char[S.length()];
    List<String> ans = new ArrayList<>();
    backtrack1(S, 0, pre, ans);
    return ans;
  }

  private void backtrack1(String s, int depth, char[] pre, List<String> ans) {

    if (depth == s.length()) {
      ans.add(new String(pre));
      return;
    }

    pre[depth] = s.charAt(depth);
    backtrack1(s, depth + 1, pre, ans);
    pre[depth] = 0;

    if (Character.isLetter(s.charAt(depth))) {
      pre[depth] = (char) (s.charAt(depth) ^ (1 << 5));
      backtrack1(s, depth + 1, pre, ans);
      pre[depth] = 0;
    }
  }

  public List<String> letterCasePermutation2(String S) {
    if (null == S || S.length() == 0) {
      return new ArrayList<>();
    }
    List<String> ans = new ArrayList<>();
    backtrack2(S.toCharArray(), 0, ans);
    return ans;
  }

  @SuppressWarnings("InfiniteRecursion")
  private void backtrack2(char[] source, int depth, List<String> ans) {
    if (depth == source.length) {
      ans.add(new String(source));
    }
    backtrack2(source, depth + 1, ans);
    if (Character.isLetter(source[depth])) {
      source[depth] ^= 1 << 5;
      backtrack2(source, depth + 1, ans);
    }
  }
}
