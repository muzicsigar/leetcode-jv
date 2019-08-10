package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0237E_DeleteNodeInALinkedList {

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
