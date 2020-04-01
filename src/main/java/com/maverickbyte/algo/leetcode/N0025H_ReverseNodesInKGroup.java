package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0025H_ReverseNodesInKGroup {


  /* =============================================================================================
      solution 1: stack
     ============================================================================================= */
  public ListNode reverseKGroup(ListNode head, int k) {
    if (null == head || k < 2) {
      return head;
    }
    LinkedList<ListNode> deque = new LinkedList<>();
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (true) {
      int count = 0;
      while (head != null && count < k) {
        deque.addLast(head);
        head = head.next;
        count++;
      }
      if (count < k) {
        cur.next = deque.peek();
        break;
      }
      while (!deque.isEmpty()) {
        cur.next = deque.pollLast();
        cur = cur.next;
      }
    }
    return dummy.next;
  }


  /* =============================================================================================
      solution 2: tail-insertion
     ============================================================================================= */
  public ListNode reverseKGroup2(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode tail = dummy;
    while (true) {
      int count = 0;
      while (tail != null && count != k) {
        count++;
        tail = tail.next;
      }
      if (tail == null) {
        break;
      }
      ListNode nextPre = pre.next;
      while (pre.next != tail) {
        ListNode cur = pre.next;
        pre.next = cur.next;
        cur.next = tail.next;
        tail.next = cur;
      }
      pre = nextPre;
      tail = nextPre;
    }
    return dummy.next;
  }

  /* =============================================================================================
      solution 3: recursion
     ============================================================================================= */
  public ListNode reverseKGroup3(ListNode head, int k) {
    ListNode cur = head;
    int count = 0;
    while (cur != null && count != k) {
      cur = cur.next;
      count++;
    }
    if (count == k) {
      cur = reverseKGroup3(cur, k);
      while (count != 0) {
        ListNode tmp = head.next;
        head.next = cur;
        cur = head;
        head = tmp;
        count--;
      }
      head = cur; //WARN: don't skip this!
    }
    return head;
  }


}
