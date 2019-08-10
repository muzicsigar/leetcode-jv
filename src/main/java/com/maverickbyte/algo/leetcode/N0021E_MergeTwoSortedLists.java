package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

public class N0021E_MergeTwoSortedLists {


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


  // using recursion: time: -> O(n + m), space -> O(n + m). from tail to head.
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    // base case
    if(l1 == null) {
      return l2;
    }
    if(l2 == null) {
      return l1;
    }

    // making progress
    // supposing l1.next and l2.next are both processed
    if(l1.val < l2.val) {
      // l1 to be the head
      l1.next = mergeTwoLists2(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists2(l1, l2.next);
      return l2;
    }

  }

}
