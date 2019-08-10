package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0086M_PartitionList {


  public ListNode partition(ListNode head, int x) {

    ListNode bigDummy = new ListNode(0);
    bigDummy.next = head;
    ListNode bigCur = head;
    ListNode bigPre = bigDummy;
    ListNode smallDummy = new ListNode(0);
    ListNode smallCur = smallDummy;

    while (bigCur != null) {
      if(bigCur.val < x) {
        ListNode temp = bigCur;
        bigPre.next = bigCur.next;
        bigCur = bigCur.next;
        smallCur.next = temp;
        smallCur = smallCur.next;
      } else {
         bigPre = bigCur;
         bigCur = bigCur.next;
      }
    }
    smallCur.next = bigDummy.next;
    return smallDummy.next;
  }
}
