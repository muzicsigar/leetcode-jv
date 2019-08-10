package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0276E_PaintFence {


  // math: 这个解答是错的，别看
  public int numWays1(int n, int k) {
    int total = 1;
    int cnt = n;
    while (cnt > 0) {
      total *= k;
      cnt--;
    }

    if (n < 3) {
      return total;
    }
    if (n == 3) {
      return total - k;
    }

    if (k == 1) {
      return 0;
    }
    // wrong !! comment out
    /*cnt = n - 3;
    int temp = 1;
    while (cnt > 0) {
      temp *= k;
      cnt--;
    }
    int bad = temp * k * (n - 2);
    return total - bad;*/
    return 0;
  }

  /* =============================== 2. backtrack ==================================*/
  public int numWays2(int n, int k) {
    if (n < 1 || k < 1) {
      return 0;
    }
    int[] states = new int[n];
    this.k_2 = k;
    backtrack(0, states);
    return count;
  }

  private int count = 0;
  private int k_2;

  // Time: O(k ^ n)
  private void backtrack(int depth, int[] states) {
    if (depth == states.length) {
      System.out.println(Arrays.toString(states));
      count++;
      return;
    }
    for (int i = 1; i <= k_2; i++) {
      if (depth >= 2 && i == states[depth - 1] && states[depth - 1] == states[depth - 2]) {
        continue;
      }
      states[depth] = i;
      backtrack(depth + 1, states);
      states[depth] = 0;
    }
  }

  /* =============================== 3. dp recursive ==================================*/
  // 存在重复调用
  public int numWays3(int n, int k) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }
    if (n == 3) {
      return k * k * k - k;
    }
    return numWays3(n - 1, k) * k - numWays3(n - 3, k) * (k - 1);
  }


  /* ========================= 4. dp recursive with state memorization ===========================*/
  private int[] states_4;
  private int k_4;

  public int numWays4(int n, int k) {
    if (n < 1 || k < 1) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }
    if (n == 3) {
      return k * k * k - k;
    }
    states_4 = new int[n];
    Arrays.fill(states_4, -1);
    states_4[0] = 0;
    states_4[1] = k;
    states_4[2] = k * k;
    states_4[3] = k * k * k - k;
    k_4 = k;
    return dp4(n);
  }

  private int dp4(int n) {
    if (n < 4) {
      return states_4[n];
    }
    if(states_4[n] >= 0) {
      return states_4[n];
    }
    int ans = k_4 * dp4(n - 1) - dp4(n - 3) * (k_4 - 1);
    states_4[n] = ans;
    return ans;
  }


  /* =============================== 5. dp iteration ==================================*/





  public static void main(String[] args) {
    N0276E_PaintFence runner = new N0276E_PaintFence();
    //runner.numWays(3, 2);
    runner.numWays2(400, 2);// timeout
  }
}
