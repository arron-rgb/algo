package edu.neu.algo.monotonic.leetcode.editor.en._20220729;

import java.util.*;

import edu.neu.algo.dp.leetcode.editor.en._20220704.MapOfHighestPeak;
import edu.neu.util.InputUtil;

public class ShortestPathInAGridWithObstaclesElimination {
  // 1293
  // You are given an m x n integer matrix grid where each cell is either 0 (empty)
  // or 1 (obstacle). You can move up, down, left, or right from and to an empty
  // cell in one step.
  //
  // Return the minimum number of steps to walk from the upper left corner (0, 0)
  // to the lower right corner (m - 1, n - 1) given that you can eliminate at most k
  // obstacles. If it is not possible to find such walk return -1.
  //
  //
  // Example 1:
  //
  //
  // Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
  // Output: 6
  // Explanation:
  // The shortest path without eliminating any obstacle is 10.
  // The shortest path with one obstacle elimination at position (3,2) is 6. Such
  // path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
  //
  //
  // Example 2:
  //
  //
  // Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
  // Output: -1
  // Explanation: We need to eliminate at least two obstacles to find such a walk.
  //
  //
  //
  // Constraints:
  //
  //
  // m == grid.length
  // n == grid[i].length
  // 1 <= m, n <= 40
  // 1 <= k <= m * n
  // grid[i][j] is either 0 or 1.
  // grid[0][0] == grid[m - 1][n - 1] == 0
  //
  // Related Topics Array Breadth-First Search Matrix 👍 2585 👎 46

  public static void main(String[] args) {
    Solution solution = new ShortestPathInAGridWithObstaclesElimination().new Solution();
    String[] data = """
          [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]]
      1
      [[0,1,1],[1,1,1],[1,0,0]]
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.shortestPath((int[][])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
      int m = grid.length;
      int n = grid[0].length;
      boolean[][][] visited = new boolean[m][n][k + 1];
      Deque<int[]> deque = new ArrayDeque<>();
      visited[0][0][0] = true;
      deque.add(new int[] {0, 0, 0});
      int res = 0;
      while (!deque.isEmpty()) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
          int[] poll = deque.poll();
          if (poll[0] == m - 1 && poll[1] == n - 1) {
            return res;
          }
          for (int[] direction : directions) {
            int nextI = direction[0] + poll[0];
            int nextJ = direction[1] + poll[1];
            int nextK = poll[2];
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
              if (grid[nextI][nextJ] == 1) {
                nextK++;
              }
              if (nextK <= k && !visited[nextI][nextJ][nextK]) {
                deque.add(new int[] {nextI, nextJ, nextK});
                visited[nextI][nextJ][nextK] = true;
              }
            }
          }
        }
        res++;
      }
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
