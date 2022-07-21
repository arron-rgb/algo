package edu.neu.algo.review.leetcode.editor.en._20220720;

import java.util.*;
import edu.neu.util.InputUtil;

public class GameOfLife {
  // 289
  // According to Wikipedia's article: "The Game of Life, also known simply as
  // Life, is a cellular automaton devised by the British mathematician John Horton
  // Conway in 1970."
  //
  // The board is made up of an m x n grid of cells, where each cell has an
  // initial state: live (represented by a 1) or dead (represented by a 0). Each cell
  // interacts with its eight neighbors (horizontal, vertical, diagonal) using the
  // following four rules (taken from the above Wikipedia article):
  //
  //
  // Any live cell with fewer than two live neighbors dies as if caused by under-
  // population.
  // Any live cell with two or three live neighbors lives on to the next
  // generation.
  // Any live cell with more than three live neighbors dies, as if by over-
  // population.
  // Any dead cell with exactly three live neighbors becomes a live cell, as if
  // by reproduction.
  //
  //
  // The next state is created by applying the above rules simultaneously to
  // every cell in the current state, where births and deaths occur simultaneously. Given
  // the current state of the m x n grid board, return the next state.
  //
  //
  // Example 1:
  //
  //
  // Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
  // Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
  //
  //
  // Example 2:
  //
  //
  // Input: board = [[1,1],[1,0]]
  // Output: [[1,1],[1,1]]
  //
  //
  //
  // Constraints:
  //
  //
  // m == board.length
  // n == board[i].length
  // 1 <= m, n <= 25
  // board[i][j] is 0 or 1.
  //
  //
  //
  // Follow up:
  //
  //
  // Could you solve it in-place? Remember that the board needs to be updated
  // simultaneously: You cannot update some cells first and then use their updated
  // values to update other cells.
  // In this question, we represent the board using a 2D array. In principle, the
  // board is infinite, which would cause problems when the active area encroaches
  // upon the border of the array (i.e., live cells reach the border). How would you
  // address these problems?
  //
  // Related Topics Array Matrix Simulation 👍 4931 👎 451

  public static void main(String[] args) {
    Solution solution = new GameOfLife().new Solution();
    String[] data = """
          [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
      [[1,1],[1,0]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      solution.gameOfLife((int[][])params[1 + i * paramTypes.length - 1]);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public void gameOfLife(int[][] board) {

      int m = board.length;
      int n = board[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          int live = 0;
          // 8 directions to search
          for (int[] d : dir) {
            // Array cannot out of bounds
            if (d[0] + i < 0 || d[0] + i >= m || d[1] + j < 0 || d[1] + j >= n)
              continue;
            // Count the number of living
            if (board[d[0] + i][d[1] + j] == 1 || board[d[0] + i][d[1] + j] == 2)
              live++;
          }
          // 4，dead cell resurrection
          if (board[i][j] == 0 && live == 3)
            board[i][j] = 3;
          // 1,3，living cell death
          if (board[i][j] == 1 && (live < 2 || live > 3))
            board[i][j] = 2;
          // 2, living cells are still alive
        }
      }

      /**
       * board[i][j]==0 died board[i][j]==1 lived board[i][j]==2 death board[i][j]==3 lived
       */
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          board[i][j] %= 2;
        }
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
