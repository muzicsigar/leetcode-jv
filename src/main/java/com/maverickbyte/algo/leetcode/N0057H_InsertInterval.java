package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0057H_InsertInterval {


  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();
    int left = newInterval[0];
    int right = newInterval[1];
    int i = 0;
    while (i < intervals.length && left > intervals[i][1]) {
      ans.add(intervals[i]);
      i++;
    }
    while (i < intervals.length && intervals[i][0] <= right) {
      left = Math.min(left, intervals[i][0]);
      right = Math.max(right, intervals[i][1]);
      i++;
    }
    ans.add(new int[]{left, right});
    while (i < intervals.length) {
      ans.add(intervals[i]);
      i++;
    }
    return ans.toArray(new int[ans.size()][]);
  }
}
