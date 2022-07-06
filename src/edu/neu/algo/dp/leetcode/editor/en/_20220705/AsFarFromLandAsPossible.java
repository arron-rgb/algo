package edu.neu.algo.dp.leetcode.editor.en._20220705;

import java.util.ArrayDeque;
import java.util.Deque;

import edu.neu.util.InputUtil;

public class AsFarFromLandAsPossible {
  // 1162
  // Given an n x n grid containing only values 0 and 1, where 0 represents water
  // and 1 represents land, find a water cell such that its distance to the nearest
  // land cell is maximized, and return the distance. If no land or water exists in
  // the grid, return -1.
  //
  // The distance used in this problem is the Manhattan distance: the distance
  // between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
  //
  //
  // Example 1:
  //
  //
  // Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
  // Output: 2
  // Explanation: The cell (1, 1) is as far as possible from all the land with
  // distance 2.
  //
  //
  // Example 2:
  //
  //
  // Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
  // Output: 4
  // Explanation: The cell (2, 2) is as far as possible from all the land with
  // distance 4.
  //
  //
  //
  // Constraints:
  //
  //
  // n == grid.length
  // n == grid[i].length
  // 1 <= n <= 100
  // grid[i][j] is 0 or 1
  //
  // Related Topics Array Dynamic Programming Breadth-First Search Matrix 👍 1964
  // 👎 63

  public static void main(String[] args) {
    Solution solution = new AsFarFromLandAsPossible().new Solution();
    String[] data = """
          [[1,0,1],[0,0,0],[1,0,1]]
      [[1,0,0],[0,0,0],[0,0,0]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxDistance((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxDistance(int[][] grid) {
      // 求某个海洋块 到它最近的陆地的最大值
      // 朴素方法: 遍历每个海洋块 找到最近的陆地 求最大值
      // 从每个陆地出发: 每次往外走一层, 当所有的海洋都被访问过, 即为结束. 因为bfs的特性, 能够保证遇到的海是从他最近的岛出发的
      // 0 water
      // 1 land
      // find a water cell that its distance to the nearest land cell is maximized
      Deque<int[]> deque = new ArrayDeque<>();
      int m = grid.length;
      int n = grid[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 1) {
            deque.offerLast(new int[] {i, j});
          }
        }
      }
      if (deque.size() == 0 || deque.size() == m * n) {
        return -1;
      }

      int max = -1;
      while (!deque.isEmpty()) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
          int[] poll = deque.pollFirst();
          for (int[] direction : directions) {
            int nextI = direction[0] + poll[0];
            int nextJ = direction[1] + poll[1];
            int[] ints = new int[] {nextI, nextJ};
            if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= m || grid[nextI][nextJ] != 0) {
              continue;
            }
            grid[nextI][nextJ] = grid[poll[0]][poll[1]] + 1;
            deque.offerLast(ints);
          }
        }
        max++;
      }
      return max;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
