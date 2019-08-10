package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0002M_AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyNode = new ListNode(0);
    ListNode cur = dummyNode;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int x = l1 == null ? 0 : l1.val;
      int y = l2 == null ? 0 : l2.val;

      int sum = x + y + carry;
      int digit = sum % 10;
      carry = sum / 10;

      cur.next = new ListNode(digit);
      cur = cur.next;
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }
    if (carry > 0) {
      cur.next = new ListNode(carry);
    }
    return dummyNode.next;
  }


}
