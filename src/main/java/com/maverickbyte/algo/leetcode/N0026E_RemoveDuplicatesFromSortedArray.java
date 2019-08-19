package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0026E_RemoveDuplicatesFromSortedArray {


  public int removeDuplicates(int[] nums) {
    if (null == nums || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    int cur = 1;
    int walk = 1;
    while (walk < nums.length) {
      if (nums[walk] != nums[walk - 1]) {
        nums[cur] = nums[walk];
        cur++;
        walk++;
      } else {
        walk++;
      }
    }
    return cur;
  }

  public static void main(String[] args) {
    N0026E_RemoveDuplicatesFromSortedArray runner = new N0026E_RemoveDuplicatesFromSortedArray();
    int ans = runner.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    System.out.println(ans);
  }
}
