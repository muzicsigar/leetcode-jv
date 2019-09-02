package com.maverickbyte.algo.leetcode.contest.wc0152;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class Three {

  /* =============================================================================================
      输入：
      "hunu"
      [[1,1,1],[2,3,0],[3,3,1],[0,3,2],[1,3,3],[2,3,1],[3,3,1],[0,3,0],[1,1,1],[2,3,0],[3,3,1],[0,3,1],[1,1,1]]
      输出：
      [true,false,true,true,true,true,true,false,true,false,true,false,true]
      预期：
      [true,false,true,true,true,true,true,false,true,false,true,true,true]
     ============================================================================================= */

  public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    List<Boolean> ans = new ArrayList<>();
    for (int[] query : queries) {
      int len = query[1] - query[0] + 1;
      int left = (len - 1) / 2 + query[0];
      int right = len / 2 + query[0];

      boolean flag = true;
      while (left >= query[0]) {
        if (s.charAt(left) != s.charAt(right)) {
          query[2]--;
          if(query[2] < 0) {
            flag = false;
            break;
          }
        }
        left--;
        right++;
      }
      ans.add(flag);
    }
    return ans;
  }
}

