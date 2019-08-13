package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0095M_UniqueBinarySearchTreesII {


  /* =============================================================================================
      solution 1: DFS recursive
     ============================================================================================= */
  public List<TreeNode> generateTrees1(int n) {
    if(n == 0) {
      return new ArrayList<>();
    }
    return generate(1, n);
  }

  private List<TreeNode> generate(int start, int end) {
    List<TreeNode> trees = new ArrayList<>();
    if (start > end) {
      trees.add(null);
      return trees;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> left = generate(start, i - 1);
      List<TreeNode> right = generate(i + 1, end);
      for (int j = 0; j < left.size(); j++) {
        for (int k = 0; k < right.size(); k++) {
          TreeNode root = new TreeNode(i);
          root.left = left.get(j);
          root.right = right.get(k);
          trees.add(root);
        }
      }
    }
    return trees;
  }
}
