package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0143M_ReorderList {


  /* =============================================================================================
      solution 1:
      1. 遍历原链表L获取长度 len
      2. (len + 1) / 2之后的node都是需要前插的， 我们将（len + 1）/ 2之后的链表Reverse构成链表L2， （len + 1）/ 2 到L头结点
         的sub list当做L2。
      3. 将L1, L2顺序merge就行了。
      Time: O(N), Space: O(1)
     ============================================================================================= */
  public void reorderList1(ListNode head) {
    if (null == head || head.next == null || head.next.next == null) {
      return;
    }
    // get L's length
    ListNode cur = head;
    int len = 1;
    while (cur != null) {
      len++;
      cur = cur.next;
    }
    // get L2
    int split = (len + 1) / 2 - 1; // 找中点其实可以用快慢指针, 都不需要求长度了。
    cur = head;
    while (split > 0) {
      cur = cur.next;
      split--;
    }
    ListNode h = cur.next;
    cur.next = null;

    // reverse L2
    ListNode pre = null;
    cur = h;
    while (cur != null) {
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }
    // merge L1, L2
    cur = head;
    while (pre != null) {
      ListNode nextCur = cur.next;
      ListNode nextPre = pre.next;
      cur.next = pre;
      pre.next = nextCur;
      cur = nextCur;
      pre = nextPre;
    }
  }

  /* =============================================================================================
      solution 2: solution 1的优化， 通过快慢指针找中点。
     ============================================================================================= */
  public void reorderList2(ListNode head) {
    if(head == null || head.next == null || head.next.next == null){
      return;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode h = slow.next;
    slow.next = null;
    // reverse
    ListNode pre = null;
    ListNode cur = h;
    while (cur != null) {
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }
    // merge L1(cur-> head), L2(pre -> h)
    cur = head;
    while (pre != null) {
      ListNode nextCur = cur.next;
      ListNode nextPre = pre.next;
      cur.next = pre;
      pre.next = nextCur;
      cur = nextCur;
      pre = nextPre;
    }
  }

}
