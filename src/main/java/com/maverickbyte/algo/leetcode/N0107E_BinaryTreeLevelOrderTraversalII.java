package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0107E_BinaryTreeLevelOrderTraversalII {

  /* =============================================================================================
      solution 1: recursive
     ============================================================================================= */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (null == root) {
      return new ArrayList<>();
    }
    LinkedList<List<Integer>> visit = new LinkedList<>();
    levelOrder(root, 0, visit);
    List<List<Integer>> ans = new ArrayList<>();
    Iterator<List<Integer>> iterator = visit.descendingIterator();
    while (iterator.hasNext()) {
      ans.add(iterator.next());
    }
    return ans;
  }

  private void levelOrder(TreeNode root, int level, List<List<Integer>> ans) {
    // base case
    if (null == root) {
      return;
    }

    // making progress
    while (ans.size() <= level) {
      ans.add(new ArrayList<>());
    }
    ans.get(level).add(root.val);
    levelOrder(root.left, level + 1, ans);
    levelOrder(root.right, level + 1, ans);
  }

  /* =============================== iteration ver. ==================================*/
  public List<List<Integer>> levelOrder2(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    LinkedList<List<Integer>> ans = new LinkedList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> levelList = new ArrayList<>();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.pollFirst();
        levelList.add(node.val);
        if (node.left != null) {
          queue.addLast(node.left);
        }
        if (node.right != null) {
          queue.addLast(node.right);
        }
      }
      ans.addFirst(levelList);
    }
    return ans;
  }

}
