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

  // brutal-force ver2
  // Time: O(k * N)
  public ListNode mergeKLists1(ListNode[] lists) {
    if (null == lists || lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }

    int k = lists.length;
    ListNode dummyNode = new ListNode(0);
    ListNode current = dummyNode;

    while (true) {
      // choose minIdx
      int minIdx = -1;
      for (int i = 0; i < k; i++) {
        if (lists[i] != null && (minIdx < 0 || lists[minIdx].val > lists[i].val)) {
          minIdx = i;
        }
      }
      if (minIdx < 0) {
        break;
      }
      // append to current sorted list
      current.next = lists[minIdx];
      current = current.next;
      lists[minIdx] = lists[minIdx].next;
    }

    return dummyNode.next;
  }

  // using heap sort( array heap), timeout...
  public ListNode mergeKLists2(ListNode[] lists) {
    if (null == lists || lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }

    // O(N)
    int size = 0;
    for (int i = 0; i < lists.length; i++) {
      ListNode walker = lists[i];
      while (null != walker) {
        walker = walker.next;
        size++;
      }
    }
    if (size == 0) {
      return null;
    }
    ListNode[] array = new ListNode[size];

    int j = 0;
    for (int i = 0; i < lists.length; i++) {
      ListNode walker = lists[i];
      while (null != walker) {
        array[j++] = walker;
        walker = walker.next;
      }
    }
    return heapSort(array);
  }

  // 除了这种heap， 还可以构造 size 固定等于 lists.length = k的heap。
  public ListNode heapSort(ListNode[] array) {
    // build min heap
    for (int i = array.length / 2; i >= 0; i--) {
      shiftDown(array, i, array.length);
    }
    // swap in-place
    ListNode dummyNode = new ListNode(0);
    ListNode current = dummyNode;
    for (int endIdx = array.length - 1; endIdx >= 0; endIdx--) {
      // swap
      ListNode temp = array[endIdx];
      array[endIdx] = array[0];
      array[0] = temp;
      current.next = array[endIdx];
      current = current.next;

      // percolate down
      shiftDown(array, 0, endIdx);
    }
    return dummyNode.next;
  }

  private int leftChild(int pos) {
    return (pos * 2) + 1;
  }

  private void shiftDown(ListNode[] array, int pos, int size) {
    int child;
    ListNode temp = array[pos];
    while (leftChild(pos) < size) {
      child = leftChild(pos);
      if (child != size - 1 && array[child + 1].val < array[child].val) {
        child++;
      }
      if (array[child].val < temp.val) {
        array[pos] = array[child];
        pos = child;
      } else {
        break;
      }
    }
    array[pos] = temp;
  }


  // using heap: 使用JDK实现的heap类
  public ListNode mergeKLists3(ListNode[] lists) {
    int len = lists.length;
    if (len == 0) {
      return null;
    }
    PriorityQueue<ListNode> priorityQueue =
      new PriorityQueue<>(len, Comparator.comparingInt(a -> a.val));

    ListNode dummyNode = new ListNode(-1);
    ListNode current = dummyNode;
    for (ListNode list : lists) {
      if (list != null) {
        priorityQueue.add(list); // 这一步很关键，不能也没有必要将空对象添加到优先队列中
      }
    }
    while (!priorityQueue.isEmpty()) {
      ListNode node = priorityQueue.poll(); // 优先队列非空才能出队
      current.next = node; // 当前节点的 next 指针指向出队元素
      current = current.next; // 当前指针向前移动一个元素，指向了刚刚出队的那个元素
      if (current.next != null) {
        priorityQueue.add(current.next);  // 只有非空节点才能加入到优先队列中
      }
    }
    return dummyNode.next;
  }

  // divide and conquer

}
