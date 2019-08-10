package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0216M_CombinationSumIII {

  public List<List<Integer>> combinationSum3(int k, int n) {
    if (k < 1 || n < 1) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> pre = new LinkedList<>();
    backtrack1(n, 1, k, pre, ans);
    return ans;
  }

  private void backtrack1(int residue, int start, int k,
                          LinkedList<Integer> pre,
                          List<List<Integer>> ans) {
    if (pre.size() == k && residue == 0) {
      ans.add(new ArrayList<>(pre));
      return;
    }
    // pruning: residue >= i, pre-condition: value i is sorted.
    for (int i = start; i < 9 && residue >= i; i++) {
      pre.addLast(i);
      backtrack1(residue - i, i + 1, k, pre, ans);
      pre.removeLast();
    }
  }

  public static void main(String[] args) {
    N0216M_CombinationSumIII runner = new N0216M_CombinationSumIII();
    System.out.println(runner.combinationSum3(3, 9));
  }
}
