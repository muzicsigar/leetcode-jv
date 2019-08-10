package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0043M_MultiplyStrings_Bad {



  public String multiply(String num1, String num2) {
    if ("0".equals(num1) || "0".equals(num2)) {
      return "0";
    }

    // let num1 >= num2
    if (num1.length() < num2.length()) {
      String temp = num1;
      num1 = num2;
      num2 = temp;
    }


    ListNode[] array = new ListNode[num2.length()];
    for (int i = 0; i < num2.length(); i++) {
      array[i] = digitMultiply(num1, num2.charAt(i), num2.length() - i - 1);
    }


    // divide and conquer
    ListNode head = mergeAdd(array, 0, array.length - 1);
    String ans = getString(head);
    return ans;
  }

  private String getString(ListNode head) {
    String ans = "";
    while (head != null) {
      ans = head.val + ans;
      head = head.next;
    }
    return ans;
  }

  private ListNode mergeAdd(ListNode[] array, int left, int right) {
    if (left == right) {
      return array[left];
    }
    int mid = (left + right) / 2;
    ListNode l1 = mergeAdd(array, left, mid);
    ListNode l2 = mergeAdd(array, mid + 1, right);

    ListNode dummyNode = new ListNode(-1);
    ListNode current = dummyNode;

    int carry = 0;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      carry = sum / 10;
      int res = sum % 10;
      current.next = new ListNode(res);
      current = current.next;
      l1 = l1.next;
      l2 = l2.next;
    }

    while (l1 != null) {
      int sum = l1.val + carry;
      carry = sum / 10;
      int res = sum % 10;
      current.next = new ListNode(res);
      current = current.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      int sum = l2.val + carry;
      carry = sum / 10;
      int res = sum % 10;
      current.next = new ListNode(res);
      current = current.next;
      l2 = l2.next;
    }

    if (carry > 0) {
      current.next = new ListNode(carry);
    }
    return dummyNode.next;
  }


  private ListNode digitMultiply(String s, char digit, int zeroCount) {
    int m = Integer.valueOf(digit + "");

    ListNode dummyNode = new ListNode(-1);
    ListNode current = dummyNode;
    while (zeroCount > 0) {
      current.next = new ListNode(0);
      current = current.next;
      zeroCount--;
    }
    int carry = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      int n = Integer.valueOf(s.charAt(i) + "");
      int res = n * m + carry;
      carry = res / 10;
      current.next = new ListNode(res % 10);
      current = current.next;
    }
    if (carry > 0) {
      current.next = new ListNode(carry);
    }
    return dummyNode.next;
  }
}
