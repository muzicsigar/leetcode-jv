package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0078M_Subsets {

  /* =============================== backtrack1 ==================================*/
  public List<List<Integer>> subsets1(int[] nums) {
    if (null == nums || nums.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    backtrack1(nums, 0, new ArrayList<>(), ans);
    return ans;
  }

  private void backtrack1(int[] nums, int start, List<Integer> subset, List<List<Integer>> ans) {
    ans.add(new ArrayList<>(subset));
    for (int i = start; i < nums.length; i++) {
      subset.add(nums[i]);
      backtrack1(nums, start + 1, subset, ans);
      subset.remove(subset.size() - 1);
    }
  }

  /* =============================== bit ops & mask ==================================*/
  public List<List<Integer>> subsets2(int[] nums) {
    if (null == nums || nums.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    int length = nums.length;
    int maskCount = 1 << length;
    for (int mask = 0; mask < maskCount; mask++) {
      ArrayList<Integer> subset = new ArrayList<>();
      for(int i = 0; i < length; i++) {
        if(((mask >> i) & 1) == 1) {
          subset.add(nums[length - 1- i]);
        }
      }
      ans.add(subset);
    }
    return ans;
  }
}

