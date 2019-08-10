package com.maverickbyte.algo.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0215M_KthLargestElementInAnArray {

  /* =============================== selection sort k ==================================*/
  public int findKthLargest1(int[] nums, int k) {
    int marker;
    int maxIdx;
    int temp;
    for (marker = 0; marker < k; marker++) {
      maxIdx = marker;
      for (int pos = marker; pos < nums.length; pos++) {
        if (nums[pos] > nums[maxIdx]) {
          maxIdx = pos;
        }
      }
      temp = nums[maxIdx];
      nums[maxIdx] = nums[marker];
      nums[marker] = temp;
    }
    return nums[k - 1];
  }

  /* =============================== k-MinHeap ==================================*/
  public int findKthLargest2(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.naturalOrder());
    for (int i = 0; i < nums.length; i++) {
      minHeap.add(nums[i]);
      while (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }

  /* =============================== quick selection ==================================*/
  public int findKthLargest3(int[] nums, int k) {
    int left = 0;
    int right = nums.length - 1;
    while (true) {
      int position = partition(nums, left, right);
      if (position == k - 1)
        return nums[position]; //每一轮返回当前pivot的最终位置，它的位置就是第几大的，如果刚好是第K大的数
      else if (position > k - 1)
        right = position - 1; //二分的思想
      else
        left = position + 1;
    }
  }

  private int partition(int[] nums, int left, int right) {
    int pivot = left;
    int l = left + 1; //记住这里l是left + 1
    int r = right;
    while (l <= r) {
      while (l <= r && nums[l] >= nums[pivot]) {
        l++; //从左边找到第一个小于nums[pivot]的数
      }
      while (l <= r && nums[r] <= nums[pivot]) {
        r--; //从右边找到第一个大于nums[pivot]的数
      }
      if (l <= r && nums[l] < nums[pivot] && nums[r] > nums[pivot]) {
        swap(nums, l++, r--);
      }
    }
    swap(nums, pivot, r); //交换pivot到它所属的最终位置，也就是在r的位置，因为此时r的左边都比r大，右边都比r小
    return r; //返回最终pivot的位置
  }

  // same as qucik sort
  public int partition2(int[] nums, int left, int right) {
    if (left == right) {
      return left;
    }
    int pivot = nums[left];
    while (left < right) {
      // find first smaller element from right
      while (left < right && nums[right] >= pivot) {
        right--;
      }
      nums[left] = nums[right];

      // find first larger element from left
      while (left < right && nums[left] <= pivot) {
        left++;
      }
      nums[right] = nums[left];
    }
    nums[left] = pivot;
    return left;
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  /* =============================== quick selection ==================================*/
  public int findKthLargest4(int[] nums, int k) {
    int left = 0;
    int right = nums.length - 1;
    while (true) {
      int position = partition3(nums, left, right);
      if (position == k - 1) {
        return nums[position];
      } else if (position > k - 1) {
        right = position - 1;
      } else {
        left = position + 1;
      }
    }
  }

  private static int median3pivot(int[] nums, int left, int right) {
    int center = (left + right) / 2;
    if (nums[left] > nums[center]) {
      swap(nums, left, center);
    }
    if (nums[left] > nums[right]) {
      swap(nums, left, right);
    }
    if (nums[center] > nums[right]) {
      swap(nums, center, right);
    }
    swap(nums, center, right - 1);
    return nums[right - 1];
  }

  private static final int QUICKSORT_CUTOFF = 10;

  private int partition3(int[] nums, int left, int right) {
    int size = right - left + 1;
    if (size > QUICKSORT_CUTOFF) {
      int i = left;
      int j = right - 1;
      int pivot = median3pivot(nums, left, right);
      while (true) {
        while (nums[++i] > pivot) {
        }
        while (nums[--j] < pivot) {
        }
        if (i < j) {
          swap(nums, i, j);
        } else {
          break;
        }
      }
      nums[i] = pivot;
      return i;
    } else {
      int pos;
      int temp;
      for (int marker = left + 1; marker <= right; marker++) {
        temp = nums[marker];
        for (pos = marker; pos > left && nums[pos - 1] > temp; pos--) {
          nums[pos] = nums[pos - 1];
        }
        nums[pos] = temp;
      }
      return (left + right) / 2;
    }
  }

}
