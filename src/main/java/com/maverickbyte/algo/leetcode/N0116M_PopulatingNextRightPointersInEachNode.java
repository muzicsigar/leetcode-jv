package com.maverickbyte.algo.leetcode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0116M_PopulatingNextRightPointersInEachNode {


  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    LinkedList<Node> queue = new LinkedList<>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      Node pre = null;
      for (int i = 0; i < size; i++) {
        Node p = queue.removeFirst();
        if (p.right != null) {
          queue.addLast(p.right);
        }
        if (p.left != null) {
          queue.addLast(p.left);
        }
        if (pre == null) {
          pre = p;
        } else {
          p.next = pre;
          pre = p;
        }
      }
    }
    return root;
  }

  public Node connect2(Node root) {
    if (root == null) {
      return null;
    }
    if (root.left != null) {
      root.left.next = root.right;
      if (root.next != null) {
        root.right.next = root.next.left;
      }
    }
    connect2(root.left);
    connect2(root.right);
    return root;
  }

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

}

