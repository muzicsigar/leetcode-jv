package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;
import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0109M_ConvertSortedListToBinarySearchTree {

  public TreeNode sortedListToBST(ListNode head) {
    if(null == head) {
      return null;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(head.val);
    queue.addLast(root);
    head = head.next;
    while (head != null) {
      TreeNode cur = queue.getFirst();
      if (cur.left == null) {
        cur.left = new TreeNode(head.val);
        queue.addLast(cur.left);
      } else{
        cur.right = new TreeNode(head.val);
        queue.addLast(cur.right);
        queue.pollFirst();
      }
      head = head.next;
    }
    return root;
  }

  private void convert(TreeNode root, ListNode head) {
  }
}
