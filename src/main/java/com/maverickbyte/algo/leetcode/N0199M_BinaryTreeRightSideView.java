package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0199M_BinaryTreeRightSideView {

  /* =============================== level order recursive ver. ==================================*/
  public List<Integer> rightSideView1(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    recursiveLevelOrder(root, 0, ans);
    return ans;
  }

  private void recursiveLevelOrder(TreeNode root, int level, List<Integer> ans) {
    if (root == null) {
      return;
    }
    if(ans.size() == level){
      ans.add(root.val) ;
    }
    recursiveLevelOrder(root.right, level + 1, ans); // caution: first right, then left.
    recursiveLevelOrder(root.left, level + 1, ans);
  }


  /* =============================== level order iterative ver. ==================================*/
  public List<Integer> rightSideView2(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.pollFirst();
        if (i == levelSize - 1) {
          ans.add(node.val);
        }
        if (node.left != null) {
          queue.addLast(node.left);
        }
        if (node.right != null) {
          queue.addLast(node.right);
        }
      }
    }
    return ans;
  }

}
