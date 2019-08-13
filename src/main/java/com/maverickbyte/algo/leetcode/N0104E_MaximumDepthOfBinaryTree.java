package com.maverickbyte.algo.leetcode;


import com.maverickbyte.algo.leetcode.util.Pair;
import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0104E_MaximumDepthOfBinaryTree {



  /* =============================================================================================
       recursive version
     ============================================================================================= */
  public int maxDepth1(TreeNode root) {
    if (null == root) {
      return 0;
    }
    preordor(root, 0);
    return maxDepth1;
  }

  private int maxDepth1;

  private void preordor(TreeNode root, int depth) {
    if (root != null) {
      depth++;
    } else {
      maxDepth1 = Math.max(depth, maxDepth1);
      return;
    }
    preordor(root.left, depth);
    preordor(root.right, depth);
  }


  public int maxDepth2(TreeNode root) {
    if (null == root) {
      return 0;
    }
    int left = maxDepth2(root.left);
    int right = maxDepth2(root.right);
    return 1 + Math.max(right, left);
  }

  public int maxDepth3(TreeNode root) {
    if (null == root) {
      return 0;
    }

    LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();

    queue.addLast(Pair.of(root, 1));
    int maxDepth = 1;
    while (!queue.isEmpty()) {
      Pair<TreeNode, Integer> pair = queue.removeFirst();
      TreeNode node = pair.getKey();
      Integer depth = pair.getValue();
      if (null != node) {
        maxDepth = depth;
        queue.addLast(Pair.of(node.left, depth + 1));
        queue.addLast(Pair.of(node.right, depth + 1));
      }
    }
    return maxDepth;
  }



}


