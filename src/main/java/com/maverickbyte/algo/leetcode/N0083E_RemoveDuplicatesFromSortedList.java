package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0083E_RemoveDuplicatesFromSortedList {

  public ListNode deleteDuplicates(ListNode head) {
    if (null == head || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode a = head;
    ListNode b = head.next;

    while (a != null && b != null) {
      while (b != null && a.val == b.val) {
        b = b.next;
      }
      a.next = b;
      a = b;
      b = a == null ? null : a.next;
    }
    return dummy.next;
  }


  /* =============================================================================================
       solution 1:
       缺点： 去除掉的重复Node还存在引用，不能被gc回收
     ============================================================================================= */
  public ListNode deleteDuplicates2(ListNode head) {
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      if(cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else{
        cur = cur.next;
      }
    }
    return head;
  }

  /* =============================================================================================
      solution 3:
      把这个当最终答案吧
     ============================================================================================= */
  public ListNode deleteDuplicates3(ListNode head) {
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      if(cur.val == cur.next.val) {
        ListNode temp = cur.next;
        cur.next = cur.next.next;
        temp.next = null; // clear refs, gc
      } else{
        cur = cur.next;
      }
    }
    return head;
  }


}
