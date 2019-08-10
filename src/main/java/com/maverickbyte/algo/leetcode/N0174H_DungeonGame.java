package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0174H_DungeonGame {

  public int calculateMinimumHP1(int[][] dungeon) {
    if (null == dungeon || dungeon.length == 0 || dungeon[0].length == 0) {
      return 1;
    }
    int rowLen = dungeon.length;
    int colLen = dungeon[0].length;
    // init boarder values
    if (dungeon[rowLen - 1][colLen - 1] > 0) {
      dungeon[rowLen - 1][colLen - 1] = 0;
    }
    for (int i = colLen - 2; i >= 0; i--) {
      dungeon[rowLen - 1][i] += dungeon[rowLen - 1][i + 1];
      if (dungeon[rowLen - 1][i] > 0) {
        dungeon[rowLen - 1][i] = 0;
      }
    }
    for (int i = rowLen - 2; i >= 0; i--) {
      dungeon[i][colLen - 1] +=  dungeon[i + 1][colLen - 1];
      if (dungeon[i][colLen - 1] > 0) {
        dungeon[i][colLen - 1] = 0;
      }
    }
    // iterative dp
    for (int i = rowLen - 2; i >= 0; i--) {
      for (int j = colLen - 2; j >= 0; j--) {
        dungeon[i][j] += Math.max(dungeon[i + 1][j], dungeon[i][j + 1]);
        if (dungeon[i][j] > 0) {
          dungeon[i][j] = 0;
        }
      }
    }
    return 1 - dungeon[0][0];
  }

}
