package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0046M_Permutations {

  public List<List<Integer>> permute(int[] nums) {
    if (null == nums || nums.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> permutation = new LinkedList<>();
    boolean[] used = new boolean[nums.length];

    backtrack(nums, used, permutation, ans);
    return ans;
  }

  private void backtrack(int[] nums, boolean[] used,
                         LinkedList<Integer> permutation,
                         List<List<Integer>> ans) {
    if (nums.length == permutation.size()) {
      ans.add(new ArrayList<>(permutation));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if(!used[i]) {
        permutation.add(nums[i]);
        used[i] = true;
        backtrack(nums, used, permutation, ans);
        permutation.removeLast();
        used[i] = false;
      }
    }
  }
}
