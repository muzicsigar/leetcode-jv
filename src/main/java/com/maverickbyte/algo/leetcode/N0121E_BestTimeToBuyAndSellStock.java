package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0121E_BestTimeToBuyAndSellStock {

  // brutal-force
  public int maxProfit1(int[] prices) {
    if (null == prices || prices.length < 2) {
      return 0;
    }
    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      for (int j = i + 1; j < prices.length && prices[j] > prices[i]; j++) {
        maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
      }
    }
    return maxProfit;
  }


  // 一次遍历
  public int maxProfit2(int[] prices) {
    if(null == prices || prices.length < 2) {
      return 0;
    }

    int maxProfit = 0;
    int minPrice = prices[0];
    for(int i = 1; i < prices.length; i++) {
      if(prices[i] < minPrice) {
        minPrice = prices[i];
      } else {
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
      }
    }
    return maxProfit;
  }

}
