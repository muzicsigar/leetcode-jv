package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0019M_RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode cur = head;
    int len = 0;
    while (cur != null) {
      len++;
      cur = cur.next;
    }

    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;
    ListNode prev = dummyNode;
    int prevCount = len - n;
    while (prevCount> 0) {
      prev= prev.next;
      prevCount--;
    }

    prev.next = prev.next.next;
    return dummyNode.next;
  }


  /* =============================================================================================
      solution 2: two-pointers
     ============================================================================================= */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode end = dummy;
    while (n > 0) {
      end = end.next;
      n--;
    }
    while (end.next != null) {
      pre = pre.next;
      end = end.next;
    }
    ListNode temp = pre.next;
    pre.next = pre.next.next;
    temp.next = null; // gc
    return dummy.next;
  }
}
