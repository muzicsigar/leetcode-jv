package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

import javax.annotation.Nonnull;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0000X_Practice {

  /* =============================================================================================
      tail-insertion
     ============================================================================================= */
  public ListNode reverseBetween1(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode tail = dummy;
    while (n > 0) {
      tail = tail.next;
      n--;
    }
    while (m > 1) {
      pre = pre.next;
      m--;
    }
    while (pre.next != tail) {
      ListNode cur = pre.next;
      pre.next = cur.next;
      cur.next = tail.next;
      tail.next = cur;
    }
    return dummy.next;
  }

  /* =============================================================================================
      head-insertion
     ============================================================================================= */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    for(int i = 0; i < m - 1; i++) {
      pre = pre.next;
    }
    ListNode h = pre.next;
    for (int i = 0; i < n - m; i++) {
      ListNode cur = h.next;
      h.next = cur.next;
      cur.next = pre.next;
      pre.next = cur;
    }
    return dummy.next;
  }
}




