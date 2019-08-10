package com.maverickbyte.algo.leetcode;

import java.util.HashMap;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0001E_TwoSum {

  // brutal-force
  public int[] twoSum1(int[] nums, int target) {
    if (null == nums || nums.length < 2) {
      return null;
    }
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    throw new IllegalArgumentException();
  }


  // two-round hash
  public int[] twoSum2(int[] nums, int target) {
    if (null == nums || nums.length < 2) {
      return null;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i); //重复值取一个就行，因为题干指出只可能存在一组解；
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      Integer idx = map.get(complement);
      if (null != idx && i != idx) {
        return new int[]{i, idx};
      }
    }

    throw new IllegalArgumentException();
  }

  // best solution: one-round hash
  public int[] twoSum3(int[] nums, int target) {
    if (null == nums || nums.length < 2) {
      return null;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int expectedComplement = target - nums[i];
      Integer idx = map.get(expectedComplement);
      if (idx != null && i != idx) {
        return new int[]{i, idx};
      }
      map.put(nums[i], i);
    }

    throw new IllegalArgumentException();
  }
}
