package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;
import com.maverickbyte.algo.leetcode.util.TreeNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0109M_ConvertSortedListToBinarySearchTree {

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if(head.next == null){
      return new TreeNode(head.val);
    }
    ListNode dummy= new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode slowPre = null;
    ListNode fast = dummy;
    while (fast != null && fast.next != null) {
      slowPre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    slowPre.next = null;
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(dummy.next);
    root.right = sortedListToBST(slow.next);
    return root;
  }

}
