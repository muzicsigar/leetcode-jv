package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0106M_ConstructBinaryTreeFromInorderAndPostorderTraversal {

  private Map<Integer, Integer> inorderMap;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }
    return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private TreeNode build(int[] inorder, int lIn, int rIn, int[] postorder, int lPost, int rPost) {
    if (lPost > rPost) {
      return null;
    }
    int rootVal = postorder[rPost];
    TreeNode root = new TreeNode(rootVal);
    int len = inorderMap.get(rootVal) - lIn;
    root.left = build(inorder, lIn, lIn + len - 1, postorder, lPost, lPost + len - 1);
    root.right = build(inorder, lIn + len + 1, rIn, postorder, lPost + len, rPost - 1);
    return root;
  }
}
