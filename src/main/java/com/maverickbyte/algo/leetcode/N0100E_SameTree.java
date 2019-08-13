package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0100E_SameTree {


  public boolean isSameTree1(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
  }


  public boolean isSameTree2(TreeNode p, TreeNode q) {
    if (!check(p, q)) {
      return false;
    }
    LinkedList<TreeNode> dequeP = new LinkedList<>();
    LinkedList<TreeNode> dequeQ = new LinkedList<>();
    dequeP.addLast(p);
    dequeQ.addLast(q);
    while (!dequeP.isEmpty()){
      p = dequeP.removeFirst();
      q = dequeQ.removeFirst();
      if(!check(p, q)){
        return false;
      }
      if( p != null){
        if(!check(p.left, q.left) || !check(p.right, q.right)) {
          return false;
        }
        dequeP.addLast(p.left);
        dequeQ.addLast(q.left);
        dequeP.addLast(p.right);
        dequeQ.addLast(q.right);
      }
    }
    return true;
  }

  private boolean check(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    LinkedList<Object> list = new LinkedList<>();
    list.addLast(null);
    System.out.println(list);
  }
}
