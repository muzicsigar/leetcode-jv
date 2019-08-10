package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0200M_NumberOfIslands {


  /*========================== DFS ==========================*/
  // dfs, time -> O(m * n), space -> worst case: O(m * n)
  public int numIslands1(char[][] grid) {
    if (null == grid || grid.length == 0) {
      return 0;
    }

    int rowSize = grid.length;
    int columnSize = grid[0].length;

    int ans = 0;
    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < columnSize; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          ans++;
        }
      }
    }
    return ans;
  }


  // 按照DFS的方式去标记属于一座岛屿的格点
  private void dfs(char[][] grid, int i, int j) {
    int row = grid.length;
    int col = grid[0].length;

    if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
      return;
    }

    // 按照 E, S, W, N的方向遍历
    grid[i][j] = '0'; // visited. 很巧的是 water和visited都是'0'。
    dfs(grid, i, j + 1);
    dfs(grid, i + 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i - 1, j);
  }



  /*========================== BFS ==========================*/
  // TODO




  /*========================== Union Find ==========================*/
  // TODO



}
