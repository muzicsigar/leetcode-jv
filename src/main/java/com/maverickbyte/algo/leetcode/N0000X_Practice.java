package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0000X_Practice {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode nextHead = head;
    ListNode pre = dummy;
    int cnt = k;
    while (cnt > 0 && nextHead != null) {
      nextHead = nextHead.next;
      pre = pre.next;
      cnt--;
    }
    if (cnt > 0) {
      return head;
    }
    pre.next = null;
    ListNode newHead = reverse(dummy.next);
    head.next = reverseKGroup(nextHead, k);
    return newHead;

  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }


  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int rotateIndex = rotateIndex(nums);
    if (nums[rotateIndex] > target || (rotateIndex - 1 >= 0 && nums[rotateIndex - 1] < target)) {
      return -1;
    }

    if (rotateIndex == 0 || target <= nums[nums.length - 1]) {
      return binarySearch(nums, rotateIndex, nums.length - 1, target);
    }
    return binarySearch(nums, 0, rotateIndex - 1, target);
  }

  private int rotateIndex(int[] nums) {
    int idx = nums.length - 1;
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] > nums[idx]) {
        left = mid + 1;
      } else if (nums[mid] < nums[idx]) {
        idx = mid;
        right = mid - 1;
      } else {
        return idx;
      }
    }
    return idx;
  }

  private int binarySearch(int[] nums, int left, int right, int target) {
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
    // int[] nums = new int[]{3, 4, 5, 6, 7, 8, 9, 0, 1, 2};
    int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    N0000X_Practice runner = new N0000X_Practice();
    System.out.println(runner.rotateIndex(nums));
  }
}
