package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0040M_CombinationSumII {


  public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
    if (null == candidates || candidates.length == 0) {
      return new ArrayList<>();
    }
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    backtrack1(candidates, target, 0, new LinkedList<>(), ans);
    return ans;
  }

  private void backtrack1(int[] candidates, int residue, int start, LinkedList<Integer> pre,
                          List<List<Integer>> ans) {
    if (residue < 0) {
      return;
    }
    if (residue == 0) {
      ans.add(new ArrayList<>(pre));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      // pruning duplicates
      if (i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }
      pre.addLast(candidates[i]);
      backtrack1(candidates, residue - candidates[i], i + 1, pre, ans);
      pre.removeLast();
    }
  }
}
