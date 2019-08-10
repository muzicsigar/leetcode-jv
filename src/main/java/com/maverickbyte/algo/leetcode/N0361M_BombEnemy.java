package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0361M_BombEnemy {


  /*
   首先声明两个二维数组 horizontalECounts 和 verticalECounts 分别保存当前位置(i, j) 能够炸到的横向的敌人数量和纵向的敌人数量
以计算数组前缀和的方式初始化两个数组，例如对于某一行 ["0", "E", "0", "E"] 对应的 horizontalECounts 为 [0, 1, 1, 2]。
反向遍历两个数组，使左侧/上方元素的值等于右侧/下方元素的值，除非右侧/下方为"W"。对于上面的例子而言，该行变为 [2, 2, 2, 2]。
遍历原矩阵，对于每个"0"位置(i,j)，将 horizontalECounts[i][j] 和 verticalECounts[i][j] 相加即可得到该位置能够炸到的最大敌人数量。
   */

  public int maxKilledEnemies1(char[][] grid) {
    if (null == grid || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;

    int[][] rowGrid = new int[m][n];
    int[][] colGrid = new int[m][n];
    // fill with row values
    for (int i = 0; i < m; i++) {
      if (grid[i][0] == 'E') {
        rowGrid[i][0] = 1;
      }
      for (int j = 1; j < n; j++) {
        if (grid[i][j] == 'E') {
          rowGrid[i][j] = rowGrid[i][j - 1] + 1;
        } else if (grid[i][j] == 'W') {
          rowGrid[i][j] = 0;
        } else {
          rowGrid[i][j] = rowGrid[i][j - 1];
        }
      }
      for (int j = n - 2; j >= 0; j--) {
        if (grid[i][j + 1] != 'W') {
          rowGrid[i][j] = rowGrid[i][j + 1];
        }
      }
    }

    // fill with column values
    for (int j = 0; j < n; j++) {
      if (grid[0][j] == 'E') {
        colGrid[0][j] = 1;
      }
      for (int i = 1; i < m; i++) {
        if (grid[i][j] == 'E') {
          colGrid[i][j] = colGrid[i - 1][j] + 1;
        } else if (grid[i][j] == 'W') {
          colGrid[i][j] = 0;
        } else {
          colGrid[i][j] += colGrid[i - 1][j];
        }
      }
      for (int i = m - 2; i >= 0; i--) {
        if (grid[i + 1][j] != 'W') {
          colGrid[i][j] = colGrid[i + 1][j];
        }
      }
    }

    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int temp = colGrid[i][j] + rowGrid[i][j];
        // warn: bomb can only be placed at '0'；
        if (grid[i][j] == 'E' || grid[i][j] == 'W') {
          continue;
        }
        max = Math.max(max, temp);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    N0361M_BombEnemy runner = new N0361M_BombEnemy();
    char[][] grid = {
      {'0', 'E', '0', '0'},
      {'E', '0', 'W', 'E'},
      {'0', 'E', '0', '0'}};
    int max = runner.maxKilledEnemies1(grid);
    System.out.println(max);
  }
}


