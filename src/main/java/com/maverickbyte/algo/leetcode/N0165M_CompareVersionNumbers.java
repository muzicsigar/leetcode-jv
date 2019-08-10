package com.maverickbyte.algo.leetcode;

import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0165M_CompareVersionNumbers {

  public int compareVersion(String version1, String version2) {
    String[] ver1 = version1.split("\\.");
    String[] ver2 = version2.split("\\.");
    int i = 0;
    while (i < ver1.length && i < ver2.length) {
      Integer v1 = Integer.valueOf(ver1[i]);
      Integer v2 = Integer.valueOf(ver2[i]);
      if (v1 > v2) {
        return 1;
      } else if (v1 < v2) {
        return -1;
      }
      i++;
    }
    while (i < ver1.length) {
      if (Integer.valueOf(ver1[i]) > 0) {
        return 1;
      }
      i++;
    }
    while (i < ver2.length) {
      if (Integer.valueOf(ver2[i]) > 0) {
        return -1;
      }
      i++;
    }
    return 0;
  }

  /* =============================================================================================
        solution 2
        solution 1这种格式都可以简化成下面这种方式。
     ============================================================================================= */
  public int compareVersion2(String version1, String version2) {
    String[] a1 = version1.split("\\.");
    String[] a2 = version2.split("\\.");

    for (int n = 0; n < Math.max(a1.length, a2.length); n++) {
      int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
      int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
      if (i < j)
        return -1;
      else if (i > j)
        return 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    String[] split = "12.0.1".split("\\.");
    Integer integer = Integer.valueOf("001");
    System.out.println(integer);
    System.out.println(Arrays.toString(split));
  }
}
