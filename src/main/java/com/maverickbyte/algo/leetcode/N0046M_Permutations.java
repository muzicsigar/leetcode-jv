package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0046M_Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    if (null == nums || nums.length == 0) {
      return ans;
    }
    Arrays.sort(nums); // 去除重复排列必须先排序
    this.nums = nums;
    this.visited = new boolean[nums.length];
    LinkedList<Integer> pre = new LinkedList<>();
    backtrack(0, pre, ans);
    return ans;
  }

  private boolean[] visited;
  private int[] nums;

  private void backtrack(int depth, LinkedList<Integer> pre, List<List<Integer>> ans) {
    if (depth == nums.length) {
      ans.add(new ArrayList<>(pre));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }
      if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) { // 重复排列剪枝
        continue;
      }
      pre.add(nums[i]);
      visited[i] = true;
      backtrack(depth + 1, pre, ans);
      pre.removeLast();
      visited[i] = false;
    }
  }
}
