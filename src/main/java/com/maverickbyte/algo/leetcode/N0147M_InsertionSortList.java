package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0147M_InsertionSortList {

  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur != null) {
      ListNode curNext = cur.next;
      if (cur.val >= pre.val) {
        pre = cur;
        cur = curNext;
        continue;
      }
      if (head.val >= cur.val) { // 处理加到头结点
        cur.next = head;
        head = cur;
        pre.next = curNext;
        cur = curNext;
        continue;
      }
      ListNode tmp = head;
      while (tmp.next.val < cur.val) {
        tmp = tmp.next;
      }
      cur.next = tmp.next;
      tmp.next = cur;
      pre.next = curNext;
      cur = curNext;
    }
    return head;
  }

  public static void main(String[] args) {
    N0147M_InsertionSortList runner = new N0147M_InsertionSortList();
    ListNode ans = runner.insertionSortList(ListNode.newList(new int[]{4, 2, 1, 3}));
    ListNode.print("result: " , ans);
  }
}
