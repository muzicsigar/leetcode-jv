package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0024M_SwapNodesInPairs {

  /* =============================================================================================
      solution 1: iterative
     ============================================================================================= */
  public ListNode swapPairs1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode a = head;
    ListNode b = head.next;
    ListNode c = b.next;
    ListNode d = c == null ? null : c.next;
    head = head.next;
    while (c != null && d != null) {
      // swap
      b.next = a;
      a.next = d;
      // shift right 2 nodes
      a = c;
      b = d;
      c = b.next;
      d = c == null ? null : c.next;
    }
    b.next = a;
    a.next = c;
    return head;
  }


  /* =============================================================================================
      solution 2: recursive
      记住
     ============================================================================================= */
  public ListNode swapPairs2(ListNode head) {
    if(head == null || head.next == null)  {
      return head;
    }
    ListNode ans = head.next;
    head.next = swapPairs2(ans.next);
    ans.next = head;
    return ans;
  }

  public static void main(String[] args) {
    // int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
    int[] values = {1, 2, 3};

    ListNode head = new ListNode(0);
    ListNode cur = new ListNode(values[0]);
    head.next = cur;
    for (int i = 1; i < values.length; i++) {
      cur.next = new ListNode(values[i]);
      cur = cur.next;
    }

    N0024M_SwapNodesInPairs runner = new N0024M_SwapNodesInPairs();
    ListNode ans = runner.swapPairs1(head);

    StringBuilder sb = new StringBuilder("[");
    while (ans != null) {
      sb.append(ans.val).append(", ");
      ans = ans.next;
    }
    sb.deleteCharAt(sb.length() - 2).append("]");
    System.out.println(sb.toString());
  }
}
