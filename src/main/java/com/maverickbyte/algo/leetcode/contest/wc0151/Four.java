package com.maverickbyte.algo.leetcode.contest.wc0151;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class Four {

  public List<String> invalidTransactions(String[] transactions) {
    if (transactions == null || transactions.length <= 1) {
      return new ArrayList<>();
    }


    List<String> ans = new ArrayList<>();
    int len = transactions.length;
    for (int i = 0; i < len; i++) {
      String[] tokens = transactions[i].split(",");
      if (Integer.valueOf(tokens[2]) > 1000) {
        ans.add(transactions[i]);
        continue;
      }

      int next = i + 1;
      boolean added = false;
      while (next < len) {
        String[] nextTokens = transactions[next].split(",");
        if (Math.abs(Integer.valueOf(tokens[1]) - Integer.valueOf(nextTokens[1])) > 60) {
          next++;
          continue;
        }
        if (tokens[0].equals(nextTokens[0]) && !tokens[3].equals(nextTokens[3])) {
          ans.add(transactions[i]);
          added =true;
          break;
        }
        next++;
      }

      if(added) {
        continue;
      }

      int pre = i - 1;
      while (pre >= 0) {
        String[] preTokens = transactions[pre].split(",");
        if (Math.abs(Integer.valueOf(tokens[1]) - Integer.valueOf(preTokens[1])) > 60) {
          pre--;
          continue;
        }
        if (tokens[0].equals(preTokens[0]) && !tokens[3].equals(preTokens[3])) {
          ans.add(transactions[i]);
          break;
        }
        pre--;
      }
    }
    return ans;
  }

}
