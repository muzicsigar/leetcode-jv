package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0056M_MergeIntervals {

  public int[][] merge(int[][] intervals) {
    // check
    if (null == intervals || intervals.length == 0) {
      return new int[0][];
    }
    // sort interval, Arrays.sort uses quicksort.
    Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

    List<int[]> ans = new ArrayList<>();
    // [left, right]
    int i = 0;
    while (i < intervals.length) {
      int left = intervals[i][0];
      int right = intervals[i][1];

      while (i + 1 < intervals.length) {
        int nextLeft = intervals[i + 1][0];
        int nextRight = intervals[i + 1][1];
        if (nextLeft <= right) {
          right = Math.max(right, nextRight);
          i++;
        } else {
          break;
        }
      }
      ans.add(new int[]{left, right});

      i++;
    }


    return ans.toArray(new int[ans.size()][]);
  }


}
