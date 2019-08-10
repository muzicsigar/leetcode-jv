package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0160E_IntersectionOfTwoLinkedLists {


  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    if (null == headA || null == headB) {
      return null;
    }
    ListNode p1 = headA;
    ListNode p2 = headB;
    while (p1 != null && p2 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    ListNode a = headA;
    while (p1 != null) {
      a = a.next;
      p1 = p1.next;
    }
    ListNode b = headB;
    while (p2 != null) {
      b = b.next;
      p2 = p2.next;
    }
    while (a != null || b != null) {
      if (a == b) {
        return a;
      }
      a = a.next;
      b = b.next;
    }
    return null;
  }

  /* =============================================================================================
      solution 2: solution 1的优化版
     ============================================================================================= */
  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    while (a != b) { // a = b = node or a = b = null
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }
    return a;
  }
}
