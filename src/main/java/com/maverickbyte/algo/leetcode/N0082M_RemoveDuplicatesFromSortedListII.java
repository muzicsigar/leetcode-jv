package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0082M_RemoveDuplicatesFromSortedListII {

  /* =============================================================================================
     solution：normal
     ============================================================================================= */
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


  /* =============================================================================================
      方法二是错误解答，当重复数字的个数是奇数时，会出错。
     ============================================================================================= */
  public ListNode deleteDuplicates2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    head.next = deleteDuplicates2(head.next);
    if (head.next != null && head.val == head.next.val) {
      head = head.next.next;
    }
    return head;
  }

  /* =============================================================================================
      方法三的递归解决了，当重复数字的个数是奇数时会出错的问题。
     ============================================================================================= */
  public ListNode deleteDuplicates3(ListNode head) {
    if (head == null) {
      return head;
    }
    if (head.next != null && head.val == head.next.val) {
      while (head.next != null && head.val == head.next.val) {
        head = head.next;
      }
      return deleteDuplicates3(head.next);
    } else {
      head.next = deleteDuplicates3(head.next);
    }
    return head;
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
