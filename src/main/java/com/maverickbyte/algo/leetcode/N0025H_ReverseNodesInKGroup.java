package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0025H_ReverseNodesInKGroup {


  /* =============================================================================================
      solution 2: 用现成的deque优化了solution 1
      练习这个写法
     ============================================================================================= */
  public ListNode reverseKGroup2(ListNode head, int k) {
    if(null == head || k < 2) {
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
      solution 3: 尾插法
      pre
      tail    head
      dummy    1     2     3     4     5

      # 我们用tail 移到要翻转的部分最后一个元素
      pre     head       tail
      dummy    1     2     3     4     5
               cur

      # 我们尾插法的意思就是,依次把cur移到tail后面
      pre          tail  head
      dummy    2     3    1     4     5
               cur

      # 依次类推
      pre     tail      head
      dummy    3     2    1     4     5
		  cur
     ============================================================================================= */
  public ListNode reverseKGroup3(ListNode head, int k) {
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
      if (tail == null) break;
      ListNode head1 = pre.next;
      while (pre.next != tail) {
        ListNode cur = pre.next;
        pre.next = cur.next;
        cur.next = tail.next;
        tail.next = cur;
      }
      pre = head1;
      tail = head1;
    }
    return dummy.next;
  }

  /* =============================================================================================
      solution 4: 递归
     ============================================================================================= */
  public ListNode reverseKGroup4(ListNode head, int k) {
    return null;
  }



}
