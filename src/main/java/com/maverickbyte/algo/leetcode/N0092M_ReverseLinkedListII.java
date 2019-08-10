package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0092M_ReverseLinkedListII {

  /* =============================================================================================
      solution 1:  找到要翻转部分的链表,将其翻转,再与原链表拼接;
     ============================================================================================= */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode preStart = dummy;
    ListNode start = dummy;
    for (int i = 0; i < m; i++) {
      preStart = start;
      start = start.next;
    }
    ListNode end = start;
    for (int i = 0; i < n - m; i++) {
      end = end.next;
    }
    ListNode endNext = end.next;

    ListNode pre = null;
    ListNode cur = start;
    while (cur != endNext) {
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }

    start.next = endNext;
    preStart.next = pre;
    return dummy.next;
  }


  /* =============================================================================================
      Solution 2: 用三个指针,进行插入操作
      例如:
      1->2->3->4->5->NULL, m = 2, n = 4
      将节点3插入节点1和节点2之间
      变成: 1->3->2->4->5->NULL
      再将节点4插入节点1和节点3之间
      变成:1->4->3->2->5->NULL
     ============================================================================================= */
  public ListNode reverseBetween2(ListNode head, int m, int n) {
    return null;
  }


  public static void main(String[] args) {
    N0092M_ReverseLinkedListII runner = new N0092M_ReverseLinkedListII();
    ListNode head = ListNode.factory(new int[]{1, 2, 3, 4, 5});
    ListNode ans = runner.reverseBetween(head, 2, 4);
    ListNode.print(ans);
  }
}
