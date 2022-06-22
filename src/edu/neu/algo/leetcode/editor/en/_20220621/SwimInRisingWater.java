package edu.neu.algo.leetcode.editor.en._20220621;

import java.util.Comparator;
import java.util.PriorityQueue;

import edu.neu.util.InputUtil;

public class SwimInRisingWater {

  // You are given an n x n integer matrix grid where each value grid[i][j]
  // represents the elevation at that point (i, j).
  //
  // The rain starts to fall. At time t, the depth of the water everywhere is t.
  // You can swim from a square to another 4-directionally adjacent square if and
  // only if the elevation of both squares individually are at most t. You can swim
  // infinite distances in zero time. Of course, you must stay within the boundaries of
  // the grid during your swim.
  //
  // Return the least time until you can reach the bottom right square (n - 1, n -
  // 1) if you start at the top left square (0, 0).
  //
  //
  // Example 1:
  //
  //
  // Input: grid = [[0,2],[1,3]]
  // Output: 3
  // Explanation:
  // At time 0, you are in grid location (0, 0).
  // You cannot go anywhere else because 4-directionally adjacent neighbors have a
  // higher elevation than t = 0.
  // You cannot reach point (1, 1) until time 3.
  // When the depth of water is 3, we can swim anywhere inside the grid.
  //
  //
  // Example 2:
  //
  //
  // Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[
  // 10,9,8,7,6]]
  // Output: 16
  // Explanation: The final route is shown.
  // We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
  //
  //
  //
  // Constraints:
  //
  //
  // n == grid.length
  // n == grid[i].length
  // 1 <= n <= 50
  // 0 <= grid[i][j] < n²
  // Each value grid[i][j] is unique.
  //
  // Related Topics Array Binary Search Depth-First Search Breadth-First Search
  // Union Find Heap (Priority Queue) Matrix 👍 2141 👎 150

  public static void main(String[] args) {
    Solution solution = new SwimInRisingWater().new Solution();
    String[] data = """
          [[0,2],[1,3]]
      [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]""".trim().replaceAll("\n", "|")
      .split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.swimInWater((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      boolean[][] visited = new boolean[m][n];
      int res = Integer.MIN_VALUE;
      // 从小到大排列，每次拿出高度最小的元素
      PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
      queue.offer(new int[] {0, 0});
      visited[0][0] = true;
      while (!queue.isEmpty()) {
        int[] pos = queue.poll();
        res = Math.max(res, grid[pos[0]][pos[1]]);
        if (pos[0] == m - 1 && pos[1] == n - 1) {
          return res;
        }
        for (int[] dir : directions) {
          int x = pos[0] + dir[0];
          int y = pos[1] + dir[1];
          if (x < 0 || y < 0 || x > m - 1 || y > n - 1 || visited[x][y]) {
            continue;
          }
          queue.offer(new int[] {x, y});
          visited[x][y] = true;
        }
      }
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
