package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0091M_DecodeWays {


  /* =============================================================================================
      solution 1: backtrack
      timeout.
      回溯应该应用于 路径长度能够估计，比较固定，不是特别长的地方。
      如这道题， s的长度不是固定的。 如果不进行剪枝，backtrack方法会被调用 2 ^ s.length 次， 指数级！！

      可以用回溯的地方： s.length 不能过长。

     ============================================================================================= */
  public int numDecodings1(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }
    this.source = s;
    backtrack(0);
    System.out.println(count);
    return ans;
  }

  private String source;
  private int ans;
  private int count;

  private void backtrack(int index) {
    count++;
    if (index == this.source.length()) {
      ans++;
      return;
    }
    if (source.charAt(index) - '0' > 0) {
      backtrack(index + 1);
    }
    if (index + 1 < source.length() &&
      source.charAt(index) != '0' &&
      Integer.valueOf(source.substring(index, index + 2)) <= 26) {
      backtrack(index + 2);
    }
  }


  /* =============================================================================================
      solution 2:
      dp(i): if s[i] > 0 dp(i - 1)  +  if s[i-2] > 0 && s[i -1, i - 2] < 26  dp(i - 2)
     ============================================================================================= */
  public int numDecodings2(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }
    if (s.charAt(0) == '0') {
      return 0;
    }

    int len = s.length();
    if (len == 1) {
      return 1;
    }

    //  算dp[1] 把我算死了， 特殊条件比较多。
    int[] dp = new int[len];
    dp[0] = 1;
    if (s.charAt(1) != '0') {
      dp[1] = Integer.valueOf(s.substring(0, 2)) <= 26 ? 2 : 1;
    } else {
      dp[1] = s.charAt(0) - '0' < 3 ? 1 : 0;
    }

    for (int i = 2; i < len; i++) {
      if (s.charAt(i) != '0') {
        dp[i] += dp[i - 1];
      }
      if (s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[len - 1];
  }

  public int numDecodings3(String s) {
    if (s.charAt(0) == '0')
      return 0;

    int[] dp = new int[s.length() + 1]; // 这一步特别优秀。
    dp[0] = dp[1] = 1;

    for (int i = 2; i <= s.length(); i++) {
      //如果该位不为'0'，说明该位单独成字母合法
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }
      //如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
      if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }



  public static void main(String[] args) {
    N0091M_DecodeWays runner = new N0091M_DecodeWays();
    String s =
      "1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565";
    runner.numDecodings1(s);
  }

}
