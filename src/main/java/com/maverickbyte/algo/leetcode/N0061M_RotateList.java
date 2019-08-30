package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0061M_RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if (null == head || head.next == null) {
      return head;
    }

    int mod = 1;
    ListNode cur = head;
    while (cur.next != null) {
      cur = cur.next;
      mod++;
    }
    cur.next = head;

    ListNode tail = cur;
    int cnt = mod - k % mod;
    while (cnt > 0 ) {
      tail = tail.next;
      cnt--;
    }
    head= tail.next;
    tail.next = null;
    return head;
  }

  public static void main(String[] args) {
    N0061M_RotateList runner = new N0061M_RotateList();
    int[] values = {1, 2, 3, 4, 5};
    ListNode head = new ListNode(values[0]);
    ListNode cur = head;
    for (int i = 1; i < values.length; i++) {
      cur.next = new ListNode(values[i]);
      cur = cur.next;
    }

    ListNode ans = runner.rotateRight(head, 1);

    StringBuilder sb = new StringBuilder("[");
    while (ans != null) {
      sb.append(ans.val).append(", ");
      ans = ans.next;
    }
    sb.deleteCharAt(sb.length() - 2).append("]");
    System.out.println(sb.toString());
  }
}
