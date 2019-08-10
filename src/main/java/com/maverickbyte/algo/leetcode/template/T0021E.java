package com.maverickbyte.algo.leetcode.template;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class T0021E {

  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      // cur.next.next = null;
      cur = cur.next;
    }
    cur.next = l1 == null ? l2 : l1;
    return dummy.next;
  }
}
