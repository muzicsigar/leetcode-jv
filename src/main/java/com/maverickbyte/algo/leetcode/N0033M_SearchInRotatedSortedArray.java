package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0033M_SearchInRotatedSortedArray {


  public int search(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) {
      return -1;
    }
    if (n == 1) {
      return nums[0] == target ? 0 : -1;
    }

    int rotateIndex = findRotateIndex(nums, 0, n - 1);
    if (rotateIndex == 0) {
      return binarySearch(target, nums, 0, n - 1);
    }

    if (target < nums[rotateIndex] || target > nums[rotateIndex - 1]) {
      return -1;
    } else if (nums[rotateIndex] <= target && target <= nums[n - 1]) {
      return binarySearch(target, nums, rotateIndex, n - 1);
    } else {
      return binarySearch(target, nums, 0, rotateIndex - 1);
    }
  }

  /**
   * 让右半边第一个元素作为rotateIndex， 找右半边第一个元素。 注意只有右半边的特殊情况，既 rotateIndex = 0；
   */
  private int findRotateIndex(int[] nums, int left, int right) {
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  private int binarySearch(int target, int[] nums, int left, int right) {
    while (left <= right) {
      int mid = (left + right) / 2;
      if (target < nums[mid]) {
        right = mid - 1;
      } else if (target > nums[mid]) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    // int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    int[] nums = new int[]{3, 1};
    int target = 3;
    int index = new N0033M_SearchInRotatedSortedArray().search(nums, target);
    System.out.println(index);
  }

}
