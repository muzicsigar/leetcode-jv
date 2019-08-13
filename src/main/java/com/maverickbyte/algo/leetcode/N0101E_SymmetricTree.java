package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0101E_SymmetricTree {


  public boolean isSymmetric1(TreeNode root) {
    if (root == null || root.left == null && root.right == null) {
      return true;
    }
    return mirror(root.left, root.right);
  }

  private boolean mirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return true;
    }
    if (t2 == null || t1 == null) {
      return false;
    }
    return t1.val == t2.val && mirror(t1.left, t2.right) && mirror(t1.right, t2.left);
  }


  public boolean isSymmetric2(TreeNode root) {
    if (root == null || root.left == null && root.right == null) {
      return true;
    }
    LinkedList<TreeNode> dequeP = new LinkedList<>();
    LinkedList<TreeNode> dequeQ = new LinkedList<>();
    dequeP.addLast(root.left);
    dequeQ.addLast(root.right);
    while (!dequeP.isEmpty()) {
      TreeNode p = dequeP.removeFirst();
      TreeNode q = dequeQ.removeFirst();
      if(!isEqual(p, q)) {
        return false;
      }
      if(p != null) {
        if(!isEqual(p.left, q.right) || !isEqual(p.right, q.left)) {
          return false;
        }
        dequeP.addLast(p.left);
        dequeP.addLast(p.right);
        dequeQ.addLast(q.right);
        dequeQ.addLast(q.left);
      }
    }
    return true;
  }

  private boolean isEqual(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (q == null || p == null) {
      return false;
    }
    return q.val == p.val;
  }

}
