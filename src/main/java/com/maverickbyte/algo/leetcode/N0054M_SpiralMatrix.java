package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0054M_SpiralMatrix {


  public List<Integer> spiralOrder1(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (null == matrix || matrix.length == 0) {
      return ans;
    }
    LinkedList<int[]> deque = new LinkedList<>();
    deque.add(new int[]{0, 1});
    deque.add(new int[]{1, 0});
    deque.add(new int[]{0, -1});
    deque.add(new int[]{-1, 0});

    int rLen = matrix.length;
    int cLen = matrix[0].length;
    boolean[][] visited = new boolean[rLen][cLen];
    int i = 0, j = 0;
    while (true) {
      ans.add(matrix[i][j]);
      visited[i][j] = true;

      int countDown = 1;
      while (countDown >= 0) {
        int[] direction = deque.getFirst();
        int x = i + direction[0];
        int y = j + direction[1];
        if (x < 0 || x == rLen || y < 0 || y == cLen || visited[x][y]) {
          deque.addLast(deque.removeFirst());
          countDown--;
        } else {
          i = x;
          j = y;
          break;
        }
      }
      if (countDown < 0) {
        break;
      }
    }
    return ans;
  }

  public List<Integer> spiralOrder2(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (null == matrix || matrix.length == 0) {
      return ans;
    }
    int u = 0; //赋值上下左右边界
    int d = matrix.length - 1;
    int l = 0;
    int r = matrix[0].length - 1;

    while (true) {
      for (int i = l; i <= r; ++i) {
        ans.add(matrix[u][i]); //向右移动直到最右
      }
      if (++u > d) {
        break; //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
      }
      for (int i = u; i <= d; ++i) {
        ans.add(matrix[i][r]); //向下
      }
      if (--r < l) {
        break; //重新设定有边界
      }
      for (int i = r; i >= l; --i) {
        ans.add(matrix[d][i]); //向左
      }
      if (--d < u) {
        break; //重新设定下边界
      }
      for (int i = d; i >= u; --i) {
        ans.add(matrix[i][l]); //向上
      }
      if (++l > r) {
        break; //重新设定左边界
      }
    }
    return ans;
  }


}
