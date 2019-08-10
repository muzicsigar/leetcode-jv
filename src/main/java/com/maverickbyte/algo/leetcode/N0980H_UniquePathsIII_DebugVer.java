package com.maverickbyte.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0980H_UniquePathsIII_DebugVer {

  public int uniquePathsIII(int[][] grid) {
    if (null == grid || grid.length == 0) {
      return 0;
    }
    int validSquareCount = 0;
    int rowLen = grid.length;
    int colLen = grid[0].length;
    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        if (grid[i][j] == 0) {
          validSquareCount++;
          continue;
        }
        if (grid[i][j] == 1) {
          this.endSquare = new int[]{i, j};
          continue;
        }
        if (grid[i][j] == 2) {
          this.startSquare = new int[]{i, j};
        }
      }
    }
    this.roads = new ArrayList<>();
    this.roadTracker = new LinkedList<>();
    backtrack(grid, validSquareCount + 1, this.startSquare[0], this.startSquare[1]);
    return this.roadCount;
  }

  private List<List<int[]>> roads;
  private LinkedList<int[]> roadTracker;
  private int[] startSquare;
  private int[] endSquare;
  private int roadCount;

  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private void backtrack(int[][] grid, int rest, int i, int j) {
    if (rest == 0 && i == endSquare[0] && j == endSquare[1]) {
      roads.add(new ArrayList<>(roadTracker));
      roadCount++;
      return;
    }
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length // index bound
      || grid[i][j] == -1 // invalid square not allowed
      || grid[i][j] == 1) { // end square not allowed when rest != 0
      return;
    }
    for (int[] DIRECTION : DIRECTIONS) {
      int newX = i + DIRECTION[0];
      int newY = j + DIRECTION[1];
      grid[i][j] = -1;
      roadTracker.add(new int[]{i, j});
      backtrack(grid, rest - 1, newX, newY);
      roadTracker.removeLast();
      grid[i][j] = 0;
    }
  }


  public static void main(String[] args) {
    N0980H_UniquePathsIII_DebugVer runner = new N0980H_UniquePathsIII_DebugVer();
    int[][] grid = {
      {1, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 2, -1}
    };
    runner.uniquePathsIII(grid);
    int count = 1;
    for (List<int[]> road : runner.roads) {
      StringBuilder sb = new StringBuilder("road ").append(count++).append(": [ ");
      for (int[] point : road) {
        sb.append("(").append(point[0]).append(", ").append(point[1]).append(") -> ");
      }
      sb.append("(").append(runner.endSquare[0]).append(", ").append(runner.endSquare[1]).append(
        ") ]");
      System.out.println(sb);
    }

  }
}
