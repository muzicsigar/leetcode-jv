package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0047M_PermutationsII {

  public List<List<Integer>> permuteUnique(int[] nums) {
    if (null == nums || nums.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> permutation = new LinkedList<>();
    boolean[] used = new boolean[nums.length];
    // warn: sort array
    Arrays.sort(nums);
    backtrack(nums, used, permutation, ans);
    return ans;
  }

  private void backtrack(int[] nums, boolean[] used,
                         LinkedList<Integer> permutation,
                         List<List<Integer>> ans) {
    if (permutation.size() == nums.length) {
      ans.add(new ArrayList<>(permutation));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      //剪枝
      if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
        continue;
      }
      if (!used[i]) {
        permutation.addLast(nums[i]);
        used[i] = true;
        backtrack(nums, used, permutation, ans);
        permutation.removeLast();
        used[i] = false;
      }
    }
  }
}
