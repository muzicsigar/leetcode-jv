package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0105M_ConstructBinaryTreeFromPreorderAndInorderTraversal {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode build(int[] preorder, int lPre, int rPre,
                         int[] inorder, int lIn, int rIn) {
    if (lPre > rPre) {
      return null;
    }
    int rootVal = preorder[lPre];
    TreeNode root = new TreeNode(rootVal);
    int len = 0;
    for (int i = lIn; i <= rIn; i++) {
      if (inorder[i] == rootVal) {
        break;
      }
      len++;
    }
    root.left = build(preorder, lPre + 1, lPre + len, inorder, lIn, lIn + len - 1);
    root.right = build(preorder, lPre + len + 1, rPre, inorder, lIn + len + 1, rIn);
    return root;
  }

}
