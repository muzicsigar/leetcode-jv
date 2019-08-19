package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0082M_RemoveDuplicatesFromSortedListII {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      ListNode temp = cur.next;
      while (cur.next != null && cur.val == cur.next.val) {
        temp = cur.next;
        cur.next = cur.next.next;
      }
      if (cur.next != temp) {
        pre.next = cur.next;
        temp.next = null;
      } else {
        pre = cur;
      }
      cur = cur.next;
    }
    return dummy.next;
  }


  public static void main(String[] args) {
    N0082M_RemoveDuplicatesFromSortedListII runner =
      new N0082M_RemoveDuplicatesFromSortedListII();
    ListNode head = ListNode.newList(new int[]{1, 2, 3, 3, 4, 4, 5});
    ListNode.print("input: ", head);
    ListNode ans = runner.deleteDuplicates(head);
    ListNode.print("output: ", ans);
  }
}
