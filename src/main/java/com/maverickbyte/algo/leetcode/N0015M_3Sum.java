package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0015M_3Sum {


  // Bad! brutal-force, leetcode timeout.
  // 没有考虑 三元组元素相同顺序不同的情况. 比如 [-1, 0, 1], [1, -1, 0] 认为是一组还是两组。
  // 所有这个解答是有问题的， 不应该进行重复记录。[-1, 0, 1], [1, -1, 0] 只能算一组。
  // [1, 3, 2] 排序 [1, 2, 3] 转字符串 "1-2-3",存set用于去重；
  public List<List<Integer>> threeSum1(int[] nums) {
    int size = nums.length;
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < size - 2; i++) {
      for (int j = i + 1; j < size - 1; j++) {
        for (int k = j + 1; k < size; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
          }
        }
      }
    }
    return ans;
  }


  public List<List<Integer>> threeSum2(int[] nums) {

    // npe check, bound check
    List<List<Integer>> ans = new ArrayList<>();
    int size = nums.length;
    if (null == nums || size < 3) {
      return ans;
    }
    // sort array
    Arrays.sort(nums); // like quick-sort, O(nlogn)
    for (int i = 0; i < size - 2; i++) {

      // quick return condition
      if (nums[i] > 0) {
        break;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }


      int j = i + 1;
      int k = size - 1;
      while (j < k) {
        if (nums[i] + nums[j] > 0) {
          break;
        }
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
          // remove j, k duplicates
          while (j < k && nums[j] == nums[j + 1]) {
            ++j;
          }
          while (j < k && nums[k] == nums[k - 1]) {
            --k;
          }
          ++j;
          --k;
        } else if (sum < 0) {
          ++j;
        } else {
          --k;
        }
      }
    }

    return ans;
  }
}
