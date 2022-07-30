package edu.neu.algo.monotonic.leetcode.editor.en._20220729;

import java.util.*;
import edu.neu.util.InputUtil;

public class PathWithMinimumEffort {
  // 1631
  // You are a hiker preparing for an upcoming hike. You are given heights, a 2D
  // array of size rows x columns, where heights[row][col] represents the height of
  // cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to
  // travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can
  // move up, down, left, or right, and you wish to find a route that requires the
  // minimum effort.
  //
  // A route's effort is the maximum absolute difference in heights between two
  // consecutive cells of the route.
  //
  // Return the minimum effort required to travel from the top-left cell to the
  // bottom-right cell.
  //
  //
  // Example 1:
  //
  //
  //
  //
  // Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
  // Output: 2
  // Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2
  // in consecutive cells.
  // This is better than the route of [1,2,2,2,5], where the maximum absolute
  // difference is 3.
  //
  //
  // Example 2:
  //
  //
  //
  //
  // Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
  // Output: 1
  // Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1
  // in consecutive cells, which is better than route [1,3,5,3,5].
  //
  //
  // Example 3:
  //
  //
  // Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
  //
  // Output: 0
  // Explanation: This route does not require any effort.
  //
  //
  //
  // Constraints:
  //
  //
  // rows == heights.length
  // columns == heights[i].length
  // 1 <= rows, columns <= 100
  // 1 <= heights[i][j] <= 10⁶
  // Related Topics Array Binary Search Depth-First Search Breadth-First Search
  // Union Find Heap (Priority Queue) Matrix 👍 3359 👎 138

  public static void main(String[] args) {
    Solution solution = new PathWithMinimumEffort().new Solution();
    String[] data = """
          [[1,2,2],[3,8,2],[5,3,5]]
      [[1,2,3],[3,8,4],[5,3,5]]
      [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minimumEffortPath((int[][])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
      int n = heights.length;
      int m = heights[0].length;
      Integer[][] minDist = new Integer[n][m];
      minDist[0][0] = 0;
      pq.offer(new int[] {0, 0, 0});
      while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        if (cur[0] == n - 1 && cur[1] == m - 1) {
          return cur[2];
        }
        for (int[] dir : DIRECTIONS) {
          int nx = cur[0] + dir[0];
          int ny = cur[1] + dir[1];
          if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            continue;
          }
          int effort = Math.max(cur[2], Math.abs(heights[cur[0]][cur[1]] - heights[nx][ny]));
          if (minDist[nx][ny] == null || minDist[nx][ny] > effort) {
            minDist[nx][ny] = effort;
            pq.offer(new int[] {nx, ny, minDist[nx][ny]});
          }
        }
      }

      return -1;

    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
