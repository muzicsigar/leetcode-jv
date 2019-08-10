package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0203E_RemoveLinkedListElements {

  public ListNode removeElements1(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    while (head != null) {
      ListNode headNext = head.next;
      if (head.val == val) {
        pre.next = head.next;
        head.next = null;
      } else {
        pre = pre.next;
      }
      head = headNext;
    }
    return dummy.next;
  }

  public ListNode removeElements2(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    head.next = removeElements2(head.next, val);
    return head.val == val ? head.next : head;
  }
}
