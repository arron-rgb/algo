package edu.neu.algo.review.leetcode.editor.en._20221030;

import java.util.*;
import edu.neu.util.InputUtil;

public class NumberOfEnclaves {
  // 1020
  // You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
  // represents a land cell.
  //
  // A move consists of walking from one land cell to another adjacent (4-
  // directionally) land cell or walking off the boundary of the grid.
  //
  // Return the number of land cells in grid for which we cannot walk off the
  // boundary of the grid in any number of moves.
  //
  //
  // Example 1:
  //
  //
  // Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
  // Output: 3
  // Explanation: There are three 1s that are enclosed by 0s, and one 1 that is
  // not enclosed because its on the boundary.
  //
  //
  // Example 2:
  //
  //
  // Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
  // Output: 0
  // Explanation: All 1s are either on the boundary or can reach the boundary.
  //
  // [
  // [0, 0, 0, -1, -1, -1, 0, -1, 0, 0],
  // [-1, -1, 0, 0, 0, -1, 0, -1, -1, -1],
  // [0, 0, 0, -1, -1, -1, 0, -1, 0, 0],
  // [0, 1, 1, 0, 0, 0, 1, 0, 1, 0],
  // [0, 1, 1, 1, 1, 1, 0, 0, 1, 0],
  // [0, 0, 1, 0, 1, 1, 1, 1, 0, 1],
  // [0, 1, 1, 0, 0, 0, 1, 1, 1, 1],
  // [0, 0, 1, 0, 0, 1, 0, 1, 0, 1],
  // [-1, 0, 1, 0, 1, 1, 0, 0, 0, 0],
  // [0, 0, 0, 0, 1, 1, 0, 0, 0, 1]]
  //
  // Constraints:
  //
  //
  // m == grid.length
  // n == grid[i].length
  // 1 <= m, n <= 500
  // grid[i][j] is either 0 or 1.
  //
  // Related Topics Array Depth-First Search Breadth-First Search Union Find
  // Matrix 👍 1830 👎 37

  public static void main(String[] args) {
    Solution solution = new NumberOfEnclaves().new Solution();
    String[] data =
      """
        [[0,0,0,1,1,1,0,1,0,0],[1,1,0,0,0,1,0,1,1,1],[0,0,0,1,1,1,0,1,0,0],[0,1,1,0,0,0,1,0,1,0],[0,1,1,1,1,1,0,0,1,0],[0,0,1,0,1,1,1,1,0,1],[0,1,1,0,0,0,1,1,1,1],[0,0,1,0,0,1,0,1,0,1],[1,0,1,0,1,1,0,0,0,0],[0,0,0,0,1,1,0,0,0,1]]
            """
        .trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numEnclaves((int[][])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numEnclaves(int[][] grid) {
      int m = grid.length, n = grid[0].length, ans = 0;

      // 沿着4条边界，将连通边界的陆地(1)全部感染成海洋(0)：
      for (int i = 0; i < n; i++) {
        infect(grid, 0, i);
        infect(grid, m - 1, i);
      }
      for (int i = 0; i < m; i++) {
        infect(grid, i, 0);
        infect(grid, i, n - 1);
      }

      for (int i = 1; i < m - 1; i++) {
        for (int j = 1; j < n - 1; j++) {
          ans += grid[i][j];
        }
      }

      return ans;
    }

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 上下左右4个方向

    // DFS：从(row, col)开始，将与之连通的陆地(1)全部感染成海洋(0)
    private void infect(int[][] grid, int row, int col) {
      if (grid[row][col] == 0) {
        return;
      }
      grid[row][col] = 0;
      for (int[] direction : directions) {
        int nextRow = row + direction[0], nextCol = col + direction[1];
        if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length) {
          infect(grid, nextRow, nextCol);
        }
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
