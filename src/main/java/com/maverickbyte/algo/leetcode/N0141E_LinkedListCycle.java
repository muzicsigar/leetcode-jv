package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0141E_LinkedListCycle {


  /* =============================================================================================
      solution 1: 存储以前遍历过的元素
     ============================================================================================= */
  private static final Set<ListNode> previous = new HashSet<>();

  public boolean hasCycle1(ListNode head) {
    while (head != null) {
      if (head.next == null) {
        return false;
      }
      previous.add(head);
      if (previous.contains(head.next)) {
        return true;
      }
      head = head.next;
    }
    return false;
  }


  /* =============================================================================================
      solution 2: two-pointers fast-slow-pointers
      fast指针每次走2步， slow指针每次走1步。 所以fast和slow之间的距离每次缩短1步，没有跳跃，存在环则必定
      相遇。 如果fast指针每次走3步，则可能永远不相遇了。
     ============================================================================================= */
  public boolean hasCycle2(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (slow != null && fast != null &&  fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if(slow == fast) {
        return true;
      }
    }
    return false;
  }

}
