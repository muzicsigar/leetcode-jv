package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0017M_LetterCombinationsOfAPhoneNumber {

  private static final Map<Integer, char[]> map = new HashMap<>();

  // 其实这里可以用数组: char[][] dic = new char[10][];
  static {
    map.put(2, new char[]{'a', 'b', 'c'});
    map.put(3, new char[]{'d', 'e', 'f'});
    map.put(4, new char[]{'g', 'h', 'i'});
    map.put(5, new char[]{'j', 'k', 'l'});
    map.put(6, new char[]{'m', 'n', 'o'});
    map.put(7, new char[]{'p', 'q', 'r', 's'});
    map.put(8, new char[]{'t', 'u', 'v'});
    map.put(9, new char[]{'w', 'x', 'y', 'z'});
  }

  /*Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};*/

  /*
  private static final char[][] dic = new char[10][];
  static {
    dic[2] = new char[]{'a', 'b', 'c'};
    dic[3] = new char[]{'d', 'e', 'f'};
    dic[4] = new char[]{'g', 'h', 'i'};
    dic[5] = new char[]{'j', 'k', 'l'};
    dic[6] = new char[]{'m', 'n', 'o'};
    dic[7] = new char[]{'p', 'q', 'r', 's'};
    dic[8] = new char[]{'t', 'u', 'v'})
    dic[9] = new char[]{'w', 'x', 'y', 'z'};
  }*/

  public List<String> letterCombinations(String digits) {
    if (null == digits || digits.length() == 0) {
      return new ArrayList<>();
    }

    this.digits = digits;
    List<String> ans = new ArrayList<>();
    char[] pre = new char[digits.length()];

    backtrack(0, pre, ans);
    return ans;
  }

  private String digits;

  private void backtrack(int depth, char[] pre, List<String> ans) {
    if (depth == digits.length()) {
      ans.add(new String(pre));
      return;
    }
    // warn: map.get((int) digits.charAt(depth)) 是大错特错的。
    char[] chars = map.get(digits.charAt(depth) - '0');
    for (int i = 0; i < chars.length; i++) {
      pre[depth] = chars[i];
      backtrack(depth + 1, pre, ans);
      pre[depth] = 0;
    }
  }

  public static void main(String[] args) {
    N0017M_LetterCombinationsOfAPhoneNumber runner =
      new N0017M_LetterCombinationsOfAPhoneNumber();
    List<String> strings = runner.letterCombinations("23");
    System.out.println(strings);
  }
}
