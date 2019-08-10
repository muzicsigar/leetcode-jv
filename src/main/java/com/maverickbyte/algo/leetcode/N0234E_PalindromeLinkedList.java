package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0234E_PalindromeLinkedList {


  /* =============================================================================================
      solution 1: 快慢指针， 翻转后半部分
     ============================================================================================= */
  public boolean isPalindrome1(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }


    ListNode h1 = head;
    ListNode h2 = slow.next;
    slow.next = null;

    ListNode pre = null;
    ListNode cur = h2;
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    while (pre != null) {
      if (h1.val != pre.val) {
        return false;
      }
      h1 = h1.next;
      pre = pre.next;
    }
    return h1.next == null || h1.val == h1.next.val;
  }


  /* =============================================================================================
      solution 2: solution 1的改进， 快慢指针， 翻转前半部分，在走指针的时候实现了翻转。
     ============================================================================================= */
  public boolean isPalindrome2(ListNode head) {
    if (head == null || head.next == null)
      return true;
    ListNode slow = head, fast = head.next, pre = null, prepre = null;
    while (fast != null && fast.next != null) {
      //反转前半段链表
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
      //先移动指针再来反转
      pre.next = prepre;
      prepre = pre;
    }
    ListNode p2 = slow.next;
    slow.next = pre;
    ListNode p1 = fast == null ? slow.next : slow;
    while (p1 != null) {
      if (p1.val != p2.val)
        return false;
      p1 = p1.next;
      p2 = p2.next;
    }
    return true;
  }

}
