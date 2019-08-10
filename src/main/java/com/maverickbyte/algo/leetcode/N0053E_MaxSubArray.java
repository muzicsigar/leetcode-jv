package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0053E_MaxSubArray {

  // brutal-force: T -> O(n ^ 3) , leetcode timeout
  public int maxSubArray(int[] nums) {
    // npe check, bound check
    int maxSum = nums[0]; // 注意这里， 因为最终结果可能为负数, e.g. [-1]
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        int temp = 0;
        for (int k = i; k <= j; k++) {
          temp += nums[k];
        }
        maxSum = Math.max(maxSum, temp);
      }
    }
    return maxSum;
  }

  // brutal-force: T -> O(n ^ 2)
  public int maxSubArray1(int[] nums) {
    // npe check, bound check
    int size = nums.length;
    if (null == nums || size == 0) {
      throw new IllegalArgumentException();
    }

    int maxSum = nums[0]; // e.g. [-1], 不能 int maxSum = 0;
    for (int i = 0; i < size; i++) {
      int tempSum = 0;
      for (int j = i; j < size; j++) {
        tempSum += nums[j];
        maxSum = Math.max(maxSum, tempSum);
      }
    }

    return maxSum;
  }

  // divide-and-conquer & recursive: T - > O(nlogn)
  public int maxSubArray2(int[] nums) {
    return maxSequenceSum(nums, 0, nums.length - 1);
  }

  public int maxSequenceSum(int[] nums, int left, int right) {
    if (left == right) {
      return nums[left];
    }

    int leftMaxSum = nums[left];
    int rightMaxSum = nums[right];
    int mid = (left + right) / 2;
    int leftBorderMaxSum = nums[mid];
    int rightBorderMaxSum = nums[mid + 1];

    leftMaxSum = maxSequenceSum(nums, left, mid);
    rightMaxSum = maxSequenceSum(nums, mid + 1, right);

    int leftBorderSum = 0;
    for (int i = mid; i >= left; i--) {
      leftBorderSum += nums[i];
      leftBorderMaxSum = Math.max(leftBorderMaxSum, leftBorderSum);
    }

    int rightBorderSum = 0;
    for (int i = mid + 1; i <= right; i++) {
      rightBorderSum += nums[i];
      rightBorderMaxSum = Math.max(rightBorderMaxSum, rightBorderSum);
    }

    return max3(leftMaxSum, rightMaxSum, leftBorderMaxSum + rightBorderMaxSum);
  }

  private static int max3(int i, int j, int k) {
    return Math.max(i, Math.max(j, k));
  }


  // dynamic programming: T -> O(n)
  public int maxSubArray3(int[] nums) {
    if (null == nums || nums.length == 0) {
      throw new IllegalArgumentException();
    }

    int maxSum = nums[0];
    int tempMaxSum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (tempMaxSum > 0) {
        tempMaxSum += nums[i];
      } else {
        tempMaxSum = nums[i];
      }
      maxSum = Math.max(maxSum, tempMaxSum);
    }
    return maxSum;
  }


}
