package com.maverickbyte.algo.leetcode.template;

import com.maverickbyte.algo.leetcode.util.ListNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class T0025H {


  /* =============================================================================================
      solution 1：硬做， 不建议这么做
     ============================================================================================= */
  public ListNode reverseKGroup1(ListNode head, int k) {
    if (head == null || k < 2) {
      return head;
    }

    ListNode[] group = new ListNode[k];

    int cnt = 0;
    ListNode todo = null;
    while (cnt < k && head != null) {
      group[cnt++] = head;
      head = head.next;
    }
    if (cnt < k) {
      return group[0];
    }
    for (int i = k - 1; i > 0; i--) {
      group[i].next = group[i - 1];
    }
    group[0].next = null;
    todo = group[0];
    ListNode ans = group[k - 1];

    while (true) {
      cnt = 0;
      while (cnt < k && head != null) {
        group[cnt++] = head;
        head = head.next;
      }
      if (cnt == 0) {
        return ans;
      }
      if (cnt < k) {
        todo.next = group[0];
        return ans;
      }
      for (int i = k - 1; i > 0; i--) {
        group[i].next = group[i - 1];
      }
      todo.next = group[k - 1];
      group[0].next = null;
      todo = group[0];
    }
  }


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
