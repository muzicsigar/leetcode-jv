package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0092M_ReverseLinkedListII {

  /* =============================================================================================
      tail-insertion : 非一趟
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
      head-insertion： 最佳答案
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

  public static void main(String[] args) {
    N0092M_ReverseLinkedListII runner = new N0092M_ReverseLinkedListII();
    ListNode head = ListNode.newList(new int[]{1, 2, 3, 4, 5});
    ListNode ans = runner.reverseBetween(head, 2, 4);
    ListNode.print(ans);
  }
}
