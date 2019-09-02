package com.maverickbyte.algo.leetcode.contest.wc0152;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class Four_ {

  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    List<Integer> ans = new ArrayList<>();
    for (String word : words) {
      wordMap.put(word, bitMark(word));
    }
    for (String puzzle : puzzles) {
      puzzleMap.put(puzzle, bitMark(puzzle));
    }
    for (String puzzle : puzzles) {
      int cnt = 0;
      for (String word : words) {
        if (valid(puzzle, word)) {
          cnt++;
        }
      }
      ans.add(cnt);
    }
    return ans;
  }

  private int bitMark(String s) {
    int v = 0;
    for (int i = 0; i < s.length(); i++) {
      v = v | (1 << s.charAt(i) - 'a');
    }
    return v;
  }

  private HashMap<String, Integer> wordMap = new HashMap<>();
  private HashMap<String, Integer> puzzleMap = new HashMap<>();

  private boolean valid(String puzzle, String word) {
    int w = wordMap.get(word);
    int p = puzzleMap.get(puzzle);
    int shift = puzzle.charAt(0) - 'a';
    return (w & p) == w && (w & (1 << shift)) == 1;
  }

//    System.out.println(String.format("w: %30s, word: %s", Integer.toBinaryString(w), word));
//    System.out.println(String.format("w: %30s, puzzle: %s", Integer.toBinaryString(p), puzzle));
//    System.out.println(shift);
//    System.out.println(w & (1 << shift));
//["apple","pleas","please"]
//  ["aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"]
  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(1 << 18));

  }
}
