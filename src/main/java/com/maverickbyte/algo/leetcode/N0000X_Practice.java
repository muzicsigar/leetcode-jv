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


}
