package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0039M_CombinationSum {

  /* =============================== backtrack 1 ==================================*/
  public List<List<Integer>> combinationSum1(int[] candidates, int target) {
    if (null == candidates || candidates.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack1(candidates, target, 0, new LinkedList<>(), ans);
    return ans;
  }

  private void backtrack1(int[] candidates, int residue, int start,
                          LinkedList<Integer> pre,
                          List<List<Integer>> ans) {
    if (residue == 0) {
      ans.add(new ArrayList<>(pre));
      return;
    }
    for (int i = start; i < candidates.length && candidates[i] <= residue; i++) {
      pre.addLast(candidates[i]);
      backtrack1(candidates, residue - candidates[i], i, pre, ans);
      pre.removeLast();
    }
  }


  /* =============================== backtrack 2 ==================================*/
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (null == candidates || candidates.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    backtrack2(candidates, target, 0, new LinkedList<>(), ans);
    return ans;
  }

  private void backtrack2(int[] candidates, int residue, int start, LinkedList<Integer> pre,
                          List<List<Integer>> ans) {
    if (residue < 0) {
      return;
    }
    if (residue == 0) {
      ans.add(new ArrayList<>(pre));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      pre.addLast(candidates[i]);
      backtrack2(candidates, residue - candidates[i], i, pre, ans);
      pre.removeLast();
    }
  }

}
