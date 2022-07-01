package edu.neu.algo.leetcode.editor.en._20220701;

import java.util.*;

import edu.neu.util.InputUtil;

public class ColoringABorder {
  // 1034
  // You are given an m x n integer matrix grid, and three integers row, col, and
  // color. Each value in the grid represents the color of the grid square at that
  // location.
  //
  // Two squares belong to the same connected component if they have the same
  // color and are next to each other in any of the 4 directions.
  //
  // The border of a connected component is all the squares in the connected
  // component that are either 4-directionally adjacent to a square not in the component,
  // or on the boundary of the grid (the first or last row or column).
  //
  // You should color the border of the connected component that contains the
  // square grid[row][col] with color.
  //
  // Return the final grid.
  //
  //
  // Example 1:
  // Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
  // Output: [[3,3],[3,2]]
  // Example 2:
  // Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
  // Output: [[1,3,3],[2,3,3]]
  // Example 3:
  // Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
  // Output: [[2,2,2],[2,1,2],[2,2,2]]
  //
  //
  // Constraints:
  //
  //
  // m == grid.length
  // n == grid[i].length
  // 1 <= m, n <= 50
  // 1 <= grid[i][j], color <= 1000
  // 0 <= row < m
  // 0 <= col < n
  //
  // Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 460 👎
  // 641

  public static void main(String[] args) {
    Solution solution = new ColoringABorder().new Solution();
    String[] data = """
          [[1,1],[1,2]]
      0
      0
      3
      [[1,2,2],[2,3,2]]
      0
      1
      3
      [[1,1,1],[1,1,1],[1,1,1]]
      1
      1
      2
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int, int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[][] q =
        solution.colorBorder((int[][])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length],
          (int)params[3 - 1 + i * paramTypes.length], (int)params[4 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.deepToString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
      int m = grid.length;
      int n = grid[0].length;
      boolean[][] visited = new boolean[grid.length][grid[0].length];
      Deque<int[]> deque = new ArrayDeque<>();
      deque.offerLast(new int[] {row, col});
      visited[row][col] = true;
      int source = grid[row][col];
      List<int[]> borders = new ArrayList<>();

      while (!deque.isEmpty()) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
          int[] poll = deque.pollLast();
          // grid[poll[0]][poll[1]] = color;
          visited[poll[0]][poll[1]] = true;
          boolean isBoarder = false;
          for (int[] direction : directions) {
            int nextI = poll[0] + direction[0];
            int nextJ = poll[1] + direction[1];
            if (!(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == source)) {
              isBoarder = true;
            } else if (!visited[nextI][nextJ]) {
              deque.offerLast(new int[] {nextI, nextJ});
            }
          }
          if (isBoarder) {
            borders.add(poll);
          }
        }
      }
      // grid[row][col] = source;
      for (int[] border : borders) {
        grid[border[0]][border[1]] = color;
      }
      return grid;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
