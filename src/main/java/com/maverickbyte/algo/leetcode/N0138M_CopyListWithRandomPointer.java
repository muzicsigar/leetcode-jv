package com.maverickbyte.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0138M_CopyListWithRandomPointer {

  /* =============================================================================================
      solution 1: graph traversal
      通过hash记忆，防止遍历random时产生的dead loop。
     ============================================================================================= */
  // <K, V> -> <original node, new node>
  private HashMap<Node, Node> visitedHash = new HashMap<>();

  public Node copyRandomList1(Node head) {
    if (head == null) {
      return null;
    }
    if (this.visitedHash.containsKey(head)) {
      return this.visitedHash.get(head);
    }
    Node node = new Node(head.val, null, null);
    this.visitedHash.put(head, node);
    node.next = copyRandomList1(head.next);
    node.random = copyRandomList1(head.random);
    return node;
  }


  /* =============================================================================================
      solution 2
      1. 先顺序clone新节点和赋值next，存储新旧节点map映射
      2. 再顺序更新clone链表的random值
     ============================================================================================= */
  private static final Map<Node, Node> lookup2 = new HashMap<>();

  public Node copyRandomList2(Node head) {
    Node cur = head;
    Node cloneDummy = new Node(0, null, null);
    Node cloneCur = cloneDummy;

    while (cur != null) {
      Node node = new Node(cur.val, null, null);
      cloneCur.next = node;
      lookup2.put(cur, node);
      cloneCur = node;
      cur = cur.next;
    }

    cloneCur = cloneDummy.next;
    cur = head;
    while (cloneCur != null) {
      if (cur.random != null && lookup2.containsKey(cur.random)) {
        cloneCur.random = lookup2.get(cur.random);
      }
      cloneCur = cloneCur.next;
      cur = cur.next;
    }
    return cloneDummy.next;
  }

  /* =============================================================================================
      solution 3: 新旧交叉链表
      input: A -> B -> C -> D
      mid-result: A -> A' -> B -> B' -> C -> C'
      更新 random
      分开新旧链表
     ============================================================================================= */
  public Node copyRandomList3(Node head) {
    return null;
  }


  public Node copyRandomList(Node head) {
    if (null == head) {
      return null;
    }

    Node cur = head;
    while (cur != null) {
      Node clone = new Node(cur.val, null, null);
      clone.next = cur.next;
      cur.next = clone;
      cur = clone.next;
    }

    cur = head;
    while (cur != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }

    cur = head;
    Node cloneDummy = new Node(0, cur.next, null);
    while (true) {
      if (cur.next.next == null) {
        cur.next = null;
        break;
      }
      Node nextCur = cur.next.next;
      cur.next.next = cur.next.next.next;
      cur.next = nextCur;
      cur = nextCur;
    }
    return cloneDummy.next;
  }


}


class Node {
  public int val;
  public Node next;
  public Node random;

  public Node() {
  }

  public Node(int _val, Node _next, Node _random) {
    val = _val;
    next = _next;
    random = _random;
  }
}
