package com.maverickbyte.algo.leetcode;

import com.maverickbyte.algo.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0129M_SumRootToLeafNumbers {

  public int sumNumbers1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int total = 0;
    List<Integer> sums = new ArrayList<>();
    dfs(root, 0, sums);
    for (Integer sum : sums) {
      total += sum;
    }
    return total;
  }

  private void dfs(TreeNode root, int sum, List<Integer> sums) {
    if (root.left == null && root.right == null) {
      sums.add(10 * sum + root.val);
      return;
    }
    if (root.left != null) {
      dfs(root.left, 10 * sum + root.val, sums);
    }
    if (root.right != null) {
      dfs(root.right, 10 * sum + root.val, sums);
    }
  }


  public int sumNumbers2(TreeNode root) {
    int sum = 0;
    if (root == null)
      return sum;
    Stack<TreeNode> nodeStack = new Stack<>();
    Stack<Integer> numStack = new Stack<>();
    nodeStack.add(root);
    numStack.add(0);
    while (!nodeStack.isEmpty()) {
      TreeNode current = nodeStack.pop();
      Integer currentNum = numStack.pop() * 10 + current.val;
      if (current.left == null && current.right == null) {
        sum += currentNum;
      }
      if (current.left != null) {
        nodeStack.add(current.left);
        numStack.add(currentNum);
      }
      if (current.right != null) {
        nodeStack.add(current.right);
        numStack.add(currentNum);
      }
    }
    return sum;
  }

  public int sumNumbers3(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    Queue<Integer> numQueue = new LinkedList<Integer>();
    if (root == null)
      return 0;
    int res = 0;
    queue.add(root);
    numQueue.add(0);
    while (!queue.isEmpty()) {
      int size = queue.size();
      // 把该层的都入队，同时如果遇到叶节点，计算更新
      while (size-- > 0) {
        root = queue.poll();
        int val = numQueue.poll() * 10 + root.val;
        if (root.left == null && root.right == null)
          res += val;
        if (root.left != null) {
          queue.add(root.left);
          numQueue.add(val);
        }
        if (root.right != null) {
          queue.add(root.right);
          numQueue.add(val);
        }
      }
    }
    return res;
  }

}
