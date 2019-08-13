package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0103M_BinaryTreeZigzagLevelOrderTraversal {

  /* =============================================================================================
      solution 1: recursive
     ============================================================================================= */
  public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
    if (null == root) {
      return new ArrayList<>();
    }
    List<LinkedList<Integer>> visit = new ArrayList<>();
    zigzagLevel(root, 0, visit);

    List<List<Integer>> ans = new ArrayList<>();
    for (LinkedList<Integer> level : visit) {
      ans.add(new ArrayList<>(level));
    }
    return ans;
  }

  private void zigzagLevel(TreeNode root, int level, List<LinkedList<Integer>> ans) {
    if (root == null) {
      return;
    }
    while (ans.size() <= level) {
      ans.add(new LinkedList<>());
    }
    if (level % 2 == 0) {
      ans.get(level).addLast(root.val);
    } else {
      ans.get(level).addFirst(root.val);
    }
    zigzagLevel(root.left, level + 1, ans);
    zigzagLevel(root.right, level + 1, ans);
  }


  public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean flip = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      LinkedList<Integer> levelValues = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode parent = queue.removeFirst();
        if (flip) {
          levelValues.addLast(parent.val);
        } else {
          levelValues.addFirst(parent.val);
        }
        if (parent.left != null) {
          queue.addLast(parent.left);
        }
        if (parent.right != null) {
          queue.addLast(parent.right);
        }
      }
      flip = !flip;
      ans.add(levelValues);
    }
    return ans;
  }
}
