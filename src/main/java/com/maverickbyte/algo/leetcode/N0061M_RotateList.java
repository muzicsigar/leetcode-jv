package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0061M_RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if (null == head || head.next == null || k < 1) {
      return head;
    }
    // 获取链表长度，变成环形链表，pre指到head
    int len = 1;
    ListNode pre = head;
    while (head.next != null) {
      len++;
      head = head.next;
    }
    int m = k % len;
    if(m == 0) { // 短路特殊情况，这一步其实可以不要
      return pre;
    }
    head.next = pre;
    /*  m
        1  -> 3 1 2  pre -> 1 移动到3之之前 pre -> 2: 需要移动 len - 1 - m = 3 - 1 - 1 = 1 次
        2  -> 2 1 3  pre -> 1 移动到2之之前 pre -> 1: 需要移动 len - 1 - m = 3 - 1 - 2 = 0 次
        */
    int cnt = len - 1 - m;
    while (cnt > 0) {
      pre = pre.next;
      cnt--;
    }
    head = pre.next;
    pre.next = null;
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
