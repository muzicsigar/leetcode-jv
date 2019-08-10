package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0206E_ReverseLinkedList {

  /* =============================================================================================
      solution: 双指针 cur, pre
     ============================================================================================= */
  public ListNode reverseList1(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }
    return pre;
  }


  /* =============================================================================================
      solution 2: recursive (神奇， 注意理解)
     ============================================================================================= */
  public ListNode reverseList2(ListNode head) {
    // base case
    if (head == null || head.next == null) {
      return head;
    }
    // making progress
    ListNode newHead = reverseList1(head.next); // 新的head是原来的尾巴
    head.next.next = head;
    // reverseList(head) 之后， 原来的head为null
    head.next = null;
    return newHead;
  }

}
