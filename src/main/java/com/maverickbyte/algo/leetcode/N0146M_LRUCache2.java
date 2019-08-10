package com.maverickbyte.algo.leetcode;

import java.util.HashMap;

/**
 * Not thread safe
 *
 * @author Alan Li
 * @since 1.0
 */
public class N0146M_LRUCache2 {

  class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
  }

  /**
   * Always add the new node right after head.
   */
  private void add2Head(DLinkedNode node) {
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
  }

  /**
   * Remove an existing node from the linked list.
   */
  private void removeNode(DLinkedNode node) {
    DLinkedNode prev = node.prev;
    DLinkedNode next = node.next;

    prev.next = next;
    next.prev = prev;

    node.next = null;
    node.prev = null;
  }

  /**
   * Move certain node in between to the head.
   */
  private void move2Head(DLinkedNode node) {
    removeNode(node);
    add2Head(node);
  }

  private DLinkedNode popTail() {
    /**
     * Pop the current tail.
     */
    DLinkedNode res = tail.prev;
    removeNode(res);
    return res;
  }

  private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
  private int size;
  private int capacity;
  private DLinkedNode head, tail;

  public N0146M_LRUCache2(int capacity) {
    this.size = 0;
    this.capacity = capacity;

    head = new DLinkedNode();
    // head.prev = null;

    tail = new DLinkedNode();
    // tail.next = null;

    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if (node == null)
      return -1;

    // move the accessed node to the head;
    move2Head(node);

    return node.value;
  }

  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);

    if (node == null) {
      DLinkedNode newNode = new DLinkedNode();
      newNode.key = key;
      newNode.value = value;

      cache.put(key, newNode);
      add2Head(newNode);

      ++size;

      if (size > capacity) {
        // pop the tail
        DLinkedNode tail = popTail();
        cache.remove(tail.key);
        --size;
      }
    } else {
      // update the value.
      node.value = value;
      move2Head(node);
    }
  }

}
