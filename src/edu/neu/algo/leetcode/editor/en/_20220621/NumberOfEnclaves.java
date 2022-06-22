package edu.neu.algo.leetcode.editor.en._20220621;

import java.util.ArrayDeque;
import java.util.Queue;

import edu.neu.util.InputUtil;

public class NumberOfEnclaves {

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
  //
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
  // Matrix 👍 1349 👎 35

  public static void main(String[] args) {
    Solution solution = new NumberOfEnclaves().new Solution();
    String[] data = """
          [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
      [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // int q = solution.numEnclaves((int[][])params[1 - 1 + i * paramTypes.length]);
    // System.out.println(q);
    // }
    int q = solution.numEnclaves(InputUtil.stringToArrays(
      "[[0,0,0,1,1,1,0,1,0,0],[1,1,0,0,0,1,0,1,1,1],[0,0,0,1,1,1,0,1,0,0],[0,1,1,0,0,0,1,0,1,0],[0,1,1,1,1,1,0,0,1,0],[0,0,1,0,1,1,1,1,0,1],[0,1,1,0,0,0,1,1,1,1],[0,0,1,0,0,1,0,1,0,1],[1,0,1,0,1,1,0,0,0,0],[0,0,0,0,1,1,0,0,0,1]]"));
    System.out.println(q);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int numEnclaves(int[][] grid) {
      // 从边缘的1出发的能到达的1 必定是没问题的
      Queue<int[]> queue = new ArrayDeque<>();
      int m = grid.length;
      int n = grid[0].length;
      for (int i = 0; i < m; i++) {
        if (grid[i][0] == 1) {
          queue.add(new int[] {i, 0});
        }
        if (grid[i][n - 1] == 1) {
          queue.add(new int[] {i, n - 1});
        }
      }
      for (int i = 0; i < n; i++) {
        if (grid[0][i] == 1) {
          queue.add(new int[] {0, i});
        }
        if (grid[m - 1][i] == 1) {
          queue.add(new int[] {m - 1, i});
        }
      }
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          int[] poll = queue.poll();
          // visited
          grid[poll[0]][poll[1]] = 0;
          for (int[] direction : directions) {
            int nextI = direction[0] + poll[0];
            int nextJ = direction[1] + poll[1];
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == 1) {
              queue.add(new int[] {nextI, nextJ});
              grid[nextI][nextJ] = 0;
            }
          }

        }
      }

      int count = 0;
      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          if (grid[i][j] == 1) {
            count++;
          }
        }
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
