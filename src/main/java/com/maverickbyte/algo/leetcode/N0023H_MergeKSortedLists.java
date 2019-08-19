package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Alan Li
 * @since 1.0
 */
// https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by
// -leetcode/
public class N0023H_MergeKSortedLists {



  // brutal-force ver1
  public ListNode mergeKList(ListNode[] lists) {
    // 先采集数据
    List<Integer> datas = new ArrayList<>();
    for(int i = 0; i < lists.length; i ++) {
      ListNode cur = lists[i];
      while(cur != null) {
        datas.add(cur.val);
        cur = cur.next;
      }
    }

    // 自然排序（升序）
    Collections.sort(datas);

    // 重新组装链表
    ListNode dummyNode = new ListNode(0);
    ListNode current = dummyNode;
    for(int i = 0; i < datas.size(); i ++) {
      current.next = new ListNode(datas.get(i));
      current = current.next;
    }

    return dummyNode.next;
  }

  /* =============================================================================================
     solution 1: div-and-conquer
     hints: like merge-sort
     time: Nlogk
     space: logk
    ============================================================================================= */
  public ListNode mergeKLists1(ListNode[] lists) {
    if (null == lists || lists.length == 0) {
      return null;
    }
    return mergeRange(lists, 0, lists.length - 1);
  }

  private ListNode mergeRange(ListNode[] lists, int left, int right) {
    if (left == right) {
      return lists[left];
    }
    int mid = (left + right) / 2;
    ListNode l1 = mergeRange(lists, left, mid);
    ListNode l2 = mergeRange(lists, mid + 1, right);
    return merge0(l1, l2);
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    cur.next = l1 == null ? l2 : l1;
    return dummy.next;
  }

  private ListNode merge0(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = merge0(l1.next, l2);
      return l1;
    } else {
      l2.next = merge0(l1, l2.next);
      return l2;
    }
  }

  /* =============================================================================================
      solution 2: brutal-force
      k = lists.length, N = lists[0].length
      time: O(k*N)
      space: O(1)
     ============================================================================================= */
  public ListNode mergeKLists2(ListNode[] lists) {
    if (null == lists || lists.length == 0) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    ListNode smallest = smallest(lists);
    while (smallest != null && this.left > 1) {
      cur.next = smallest;
      smallest = smallest(lists);
      cur = cur.next;
    }
    if (smallest != null && this.left == 1) {
      cur.next = smallest;
    }

    return dummy.next;
  }

  private int left;

  private ListNode smallest(ListNode[] lists) {
    this.left = lists.length;
    int minIdx = -1;
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] == null) {
        this.left--;
      } else {
        if (minIdx < 0 || lists[i].val < lists[minIdx].val) {
          minIdx = i;
        }
      }
    }
    if (minIdx < 0) {
      return null;
    }
    ListNode smallest = lists[minIdx];
    lists[minIdx] = smallest.next; // 注意这一步
    return smallest;
  }


  /* =============================================================================================
      solution 3:  用优先队列优化 solution 2
      记住这个
     ============================================================================================= */
  public ListNode mergeKLists3(ListNode[] lists) {
    if (null == lists || lists.length == 0) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    for (ListNode list : lists) {
      if (list != null) {
        pq.add(list);
      }
    }
    while (pq.peek() != null) {
      ListNode smallest = pq.poll();
      cur.next = smallest;
      cur = cur.next;
      smallest = smallest.next;
      if (smallest != null) {
        pq.add(smallest);
      }
    }
    return dummy.next;
  }


  public static void main(String[] args) {
    int[][] array = {
      {1, 4, 5},
      {1, 3, 4},
      {2, 6}
    };
    ListNode[] currs = new ListNode[array.length];
    ListNode[] lists = new ListNode[array.length];
    for (int i = 0; i < array.length; i++) {
      currs[i] = new ListNode(array[i][0]);
      lists[i] = currs[i];
      for (int j = 1; j < array[i].length; j++) {
        currs[i].next = new ListNode(array[i][j]);
        currs[i] = currs[i].next;
      }
    }

    N0023H_MergeKSortedLists runner = new N0023H_MergeKSortedLists();
    ListNode head = runner.mergeKLists1(lists);
    // ListNode head = runner.mergeKLists2(lists);
    // ListNode head = runner.mergeKLists3(lists);

    StringBuilder sb = new StringBuilder("[");
    while (head != null) {
      sb.append(head.val).append(", ");
      head = head.next;
    }
    sb.deleteCharAt(sb.length() - 2).append("]");
    System.out.println(sb.toString());
  }

}
