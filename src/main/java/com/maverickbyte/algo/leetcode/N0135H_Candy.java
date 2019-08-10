package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0135H_Candy {

  // brutal-force
  // time -> O(n^2), space -> O(n)
  public int candy1(int[] ratings) {
    int size = ratings.length;
    int[] candies = new int[ratings.length];
    Arrays.fill(candies, 1);
    boolean needProgress = true;
    while (needProgress) {
      needProgress = false;
      for (int i = 0; i < size; i++) {
        // check right
        if (i != size - 1 && candies[i] <= candies[i + 1] && ratings[i] > ratings[i + 1]) {
          candies[i] = candies[i + 1] + 1;
          needProgress = true;
        }
        // check left
        if (i != 0 && candies[i] <= candies[i - 1] && ratings[i] > ratings[i - 1]) {
          candies[i] = candies[i - 1] + 1;
          needProgress = true;
        }
      }
    }
    int candyTotal = 0;
    for (int candy : candies) {
      candyTotal += candy;
    }
    return candyTotal;
  }


  // using two arrays: left2right[], right2left
  public int candy2(int[] ratings) {
    // npe check, bound check
    int size = ratings.length;
    int[] left2right = new int[size];
    int[] right2left = new int[size];
    Arrays.fill(left2right, 1);
    Arrays.fill(right2left, 1);

    // left -> right
    for (int i = 1; i < size; i++) {
      // if (left2right[i] <= left2right[i - 1] && ratings[i] > ratings[i - 1]) {
      // 天然满足 left2right[i] <= left2right[i - 1]
      if (ratings[i] > ratings[i - 1]) {
        left2right[i] = left2right[i - 1] + 1;
      }
    }

    // right -> left
    for (int i = size - 2; i >= 0; i--) {
      // if(right2left[i] <= right2left[i + 1] && ratings[i] > ratings[i + 1]) {
      // 天然满足  right2left[i] <= right2left[i + 1]
      if (ratings[i] > ratings[i + 1]) {
        right2left[i] = right2left[i + 1] + 1;
      }
    }

    int candyTotal = 0;
    for (int i = 0; i < size; i++) {
      candyTotal += Math.max(left2right[i], right2left[i]);
    }
    return candyTotal;
  }


  // using one array
  public int candy3(int[] ratings) {
    int size = ratings.length;
    int[] candies = new int[size];
    Arrays.fill(candies, 1);

    for (int i = 1; i < size; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candies[i] = candies[i - 1] + 1;
      }
    }

    int candyTotal = candies[size - 1];
    for (int i = size - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        // 注意这里
        candies[i] = Math.max(candies[i], candies[i + 1] + 1);
      }
      candyTotal += candies[i];
    }
    return candyTotal;
  }

  // TODO: https://leetcode-cn.com/problems/candy/solution/fen-fa-tang-guo-by-leetcode/
  public int candy4(int[] ratins) {
    return 0;
  }

  public static void main(String[] args) {
    int[] ratings = new int[]{1, 2, 87, 87, 87, 2, 1};
    int sum = new N0135H_Candy().candy1(ratings);
  }
}
