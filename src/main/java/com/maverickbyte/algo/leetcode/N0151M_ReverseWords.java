package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0151M_ReverseWords {


  /* =============================== comment ==================================*/
  // TODO string.split
  // TODO string.trim
  public String reverseWords1(String s) {
    String white = " ";
    String[] tokens = s.split(white); //TODO 这一步该自己实现
    StringBuffer sb = new StringBuffer();
    for (int i = tokens.length - 1; i >= 0; i--) {
      if (!tokens[i].equals("")) {
        sb.append(tokens[i]).append(white);
      }
    }
    return sb.toString().trim();
  }


  /* =============================== comment ==================================*/
  public String reverseWords2(String s) {
    StringBuffer sb = new StringBuffer();
    s = s.trim(); // delete leading or trailing spaces.
    int i = s.length() - 1, j = s.length();
    while (i > 0) {
      if (s.charAt(i) == ' ') {
        sb.append(s, i + 1, j);
        sb.append(' ');

        while (s.charAt(i) == ' ') {
          i--; // ignore extra spaces between words.
        }
        j = i + 1;
      }
      i--;
    }
    return sb.append(s, 0, j).toString();
  }
}
