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
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for(int k = 0; k < nums.length - 2; k++){
      if(nums[k] > 0) break;
      if(k > 0 && nums[k] == nums[k - 1]) continue;
      int i = k + 1, j = nums.length - 1;
      while(i < j){
        int sum = nums[k] + nums[i] + nums[j];
        if(sum < 0){
          while(i < j && nums[i] == nums[++i]);
        } else if (sum > 0) {
          while(i < j && nums[j] == nums[--j]);
        } else {
          res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
          while(i < j && nums[i] == nums[++i]);
          while(i < j && nums[j] == nums[--j]);
        }
      }
    }
    return res;
  }
}
