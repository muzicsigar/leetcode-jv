package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0077M_Combinations {

  public List<List<Integer>> combine1(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack1(n, k, 1, new ArrayList<>(), ans);
    return ans;
  }

  private void backtrack1(int n, int k, int start, List<Integer> pre,
                          List<List<Integer>> ans) {
    if (pre.size() == k) {
      ans.add(new ArrayList<>(pre));
      return;
    }
    for (int i = start; i <= n; i++) {
      pre.add(i);
      backtrack1(n, k, i + 1, pre, ans);
      pre.remove(pre.size() - 1);
    }
  }

}
