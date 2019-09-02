package com.maverickbyte.algo.leetcode.contest.wc0152;

/**
 * @author Alan Li
 * @since 1.0
 */
public class One {


  private static final int mod = 1000000007;

  public int numPrimeArrangements(int n) {
    if (n == 1) {
      return 0;
    }
    int cnt = 0;
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        ++cnt;
      }
    }
    int rest = n - cnt;
    long ans = 1;
    while (cnt > 0) {
      ans = ((ans % mod) * cnt) % mod;
      cnt--;
    }
    while (rest > 0){
      ans = ((ans%mod) * rest) % mod;
      rest--;
    }
    return (int) ans;
  }

  private boolean isPrime(int n) {
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
