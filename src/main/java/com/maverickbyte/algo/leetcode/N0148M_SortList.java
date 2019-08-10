package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0148M_SortList {


  public ListNode sortList(ListNode head) {
    if(head == null){
      return null;
    }
    return sort(head);
  }


  private ListNode sort(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode pivot = head;
    ListNode cur = head.next;
    head.next = null;

    ListNode smallDummy = new ListNode(0);
    ListNode bigDummy = new ListNode(0);

    ListNode small = smallDummy;
    ListNode big = bigDummy;
    while (cur != null) {
      ListNode curNext = cur.next;
      if (pivot.val > cur.val) {
        small.next = cur;
        small = small.next;
        small.next =null;
      } else {
        big.next = cur;
        big = big.next;
        big.next = null;
      }
      cur = curNext;
    }

    ListNode sh = null;
    if (smallDummy.next != null) {
      sh = sort(smallDummy.next);
    }
    ListNode bh = null;
    if (bigDummy.next != null) {
      bh = sort(bigDummy.next);
    }




    if(sh != null){
      head = sh;
      ListNode temp = sh;
      while (temp.next != null){
        temp = temp.next;
      }
      temp.next = pivot;
    } else {
      head = pivot;
    }
    pivot.next = bh;
    return head;
  }

  public static void main(String[] args) {
    N0148M_SortList runner = new N0148M_SortList();
    System.out.println(runner.sortList(ListNode.factory(new int[]{-1,5,3,4,0})));
  }
}
