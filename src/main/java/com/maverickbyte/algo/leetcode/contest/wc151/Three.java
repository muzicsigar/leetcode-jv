package com.maverickbyte.algo.leetcode.contest.wc151;

import com.maverickbyte.algo.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Alan Li
 * @since 1.0
 */
public class Three {


  public ListNode removeZeroSumSublists(ListNode head) {
    if (null == head) {
      return head;
    }
    ArrayList<Integer> array = new ArrayList<>();
    while (head != null) {
      array.add(head.val);
      head = head.next;
    }

    boolean[] removed = new boolean[array.size()];
    for (int i = 0; i < array.size(); i++) {
      if (removed[i] || array.get(i) > 0) {
        continue;
      }
      if (array.get(i) == 0) {
        removed[i] = true;
        continue;
      }

      Integer target = array.get(i);

      boolean finded = false;
      for (int left = i; left >= 0 && !finded; left--) {
        int tmp = target;
        for (int j = left; j < i; j++) {
          if(removed[j]) {
            break;
          }
          tmp += array.get(j);
        }
        if (tmp > 0) {
          break;
        }
        if (tmp == 0) {
          for (int j = left; j <= i; j++) {
            removed[j] = true;
          }
          break;
        }

        int right = i + 1;
        while (right < array.size()) {
          if(removed[right]) {
            break;
          }
          tmp += array.get(right);
          if (tmp > 0) {
            break;
          }
          if (tmp == 0) {
            for (int k = left; k <= right; k++) {
              removed[k] = true;
            }
            finded = true;
            break;
          }
          right++;
        }
      }
    }

    System.out.println(Arrays.toString(removed));
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    for (int i = 0; i < array.size(); i++) {
      if (!removed[i]) {
        cur.next = new ListNode(array.get(i));
        cur = cur.next;
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Three runner = new Three();
    ListNode head = runner.removeZeroSumSublists(ListNode.newList(new int[]{5, -3, -4, 1, 6,
      -2, -5}));
    System.out.println(head);
  }
}
