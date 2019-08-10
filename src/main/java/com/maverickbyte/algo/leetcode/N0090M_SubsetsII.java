package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0090M_SubsetsII {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (null == nums || nums.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> pre = new LinkedList<>();
    Arrays.sort(nums); //warn: sort
    backtrack1(nums, 0, pre, ans);
    return ans;
  }

  private void backtrack1(int[] nums, int start, LinkedList<Integer> pre, List<List<Integer>> ans) {
    ans.add(new ArrayList<>(pre));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue; // warn: not return
      }
      pre.addLast(nums[i]);
      backtrack1(nums, i + 1, pre, ans);
      pre.removeLast();
    }
  }


}
