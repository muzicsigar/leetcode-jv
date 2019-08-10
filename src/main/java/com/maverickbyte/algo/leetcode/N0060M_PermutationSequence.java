package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0060M_PermutationSequence {

  /* =============================== permutation backtrack ==================================*/
  public String getPermutation1(int n, int k) {
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    boolean[] used = new boolean[n]; // all default false
    int[] factorial = new int[n + 1];
    factorial[0] = 1;
    for (int i = 1; i <= n; i++) {
      factorial[i] = factorial[i - 1] * i;
    }
    LinkedList<Integer> permutation = new LinkedList<>();
    return backtrack(nums, used, k, permutation, factorial);
  }

  private String backtrack(int[] nums, boolean[] used, int k,
                           LinkedList<Integer> permutation,
                           int[] factorial) {
    if (permutation.size() == nums.length) {
      StringBuilder sb = new StringBuilder();
      for (Integer digit : permutation) {
        sb.append(digit);
      }
      return sb.toString();
    }

    // factorial[1, 1, 2, 6, 24]
    // let n = 4, n! = 24, k = 23;
    int permutationCount = factorial[nums.length - 1 - permutation.size()]; // warn
    for (int i = 0; i < nums.length; i++) {
//      //  注释掉的这坨方式有问题！！！
//      // 剪枝
//      if (permutationCount < k) {
//        k -= permutationCount;
//        continue;
//      }
//      if (!used[i]) {
//        permutation.addLast(nums[i]);
//        used[i] = true;
//        return backtrack(nums, used, k, permutation, factorial);
//      }
      // 第一个剪枝条件必须在第二个剪枝条件之前。
      if (used[i]) {
        continue;
      }
      if (permutationCount < k) {
        k -= permutationCount;
        continue;
      }
      permutation.addLast(nums[i]);
      used[i] = true;
      return backtrack(nums, used, k, permutation, factorial);

    }
    throw new IllegalStateException("should never reach here");
  }

  public static void main(String[] args) {
    String permutation1 = new N0060M_PermutationSequence().getPermutation1(3, 2);
    System.out.println(permutation1);
  }


  //TODO
  public String getPermutation(int n, int k) {
    /**
     直接用回溯法做的话需要在回溯到第k个排列时终止就不会超时了, 但是效率依旧感人
     可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
     算出来, 对于n=4, k=15 找到k=15排列的过程:

     1 + 对2,3,4的全排列 (3!个)
     2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
     3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
     4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

     确定第一位:
     k = 14(从0开始计数)
     index = k / (n-1)! = 2, 说明第15个数的第一位是3
     更新k
     k = k - index*(n-1)! = 2
     确定第二位:
     k = 2
     index = k / (n-2)! = 1, 说明第15个数的第二位是2
     更新k
     k = k - index*(n-2)! = 0
     确定第三位:
     k = 0
     index = k / (n-3)! = 0, 说明第15个数的第三位是1
     更新k
     k = k - index*(n-3)! = 0
     确定第四位:
     k = 0
     index = k / (n-4)! = 0, 说明第15个数的第四位是4
     最终确定n=4时第15个数为3214
     **/

    StringBuilder sb = new StringBuilder();
    // 候选数字
    List<Integer> nums = new ArrayList<>();
    // 分母的阶乘数
    int[] factorials = new int[n + 1];
    factorials[0] = 1;
    int fact = 1;
    for (int i = 1; i <= n; ++i) {
      nums.add(i);
      fact *= i;
      factorials[i] = fact;
    }
    k -= 1;
    for (int i = n - 1; i >= 0; --i) {
      // 计算候选数字的index
      int index = k / factorials[i];
      sb.append(nums.remove(index));
      k -= index * factorials[i];
    }
    return sb.toString();
  }
}
