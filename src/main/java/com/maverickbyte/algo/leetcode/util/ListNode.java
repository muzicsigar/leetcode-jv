package com.maverickbyte.algo.leetcode.util;

/**
 * @author Alan Li
 * @since 1.0
 */
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }


  public static ListNode factory(int[] values) {
    if (values == null || values.length == 0) {
      return null;
    }
    ListNode head = new ListNode(values[0]);
    ListNode cur = head;
    for (int i = 1; i < values.length; i++) {
      cur.next = new ListNode(values[i]);
      cur = cur.next;
    }
    return head;
  }

  public static void print(ListNode head) {
    print("", head);
  }

  public static void print(String prefix, ListNode head) {
    StringBuilder sb = new StringBuilder(prefix).append("[");
    ListNode cur = head;
    while (cur != null) {
      sb.append(cur.val).append(", ");
      cur = cur.next;
    }
    if(head != null){
      sb.delete(sb.length() - 2, sb.length());
    }
    sb.append("]");
    System.out.println(sb.toString());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder().append("[");
    ListNode cur = this;
    while (cur != null) {
      sb.append(cur.val).append(", ");
      cur = cur.next;
    }
    sb.delete(sb.length() - 2, sb.length());
    sb.append("]");
    return sb.toString();
  }
}
