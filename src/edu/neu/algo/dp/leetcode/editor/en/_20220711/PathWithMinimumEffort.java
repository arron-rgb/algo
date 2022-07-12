package edu.neu.algo.dp.leetcode.editor.en._20220711;

import java.util.*;

import edu.neu.util.InputUtil;

public class PathWithMinimumEffort {
  // 1631
  // kruskal 求最小生成树
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
  // Union Find Heap (Priority Queue) Matrix 👍 3292 👎 135

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

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minimumEffortPath(int[][] heights) {
      row = heights.length;
      col = heights[0].length;
      for (int i = 0; i < row * col; i++) {
        p[i] = i;
      }
      List<int[]> edges = new ArrayList<>();
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          int idx = i * col + j;
          p[idx] = idx;
          if (i + 1 < row) {
            var b = idx + col;
            int w = Math.abs(heights[i][j] - heights[i + 1][j]);
            edges.add(new int[] {idx, b, w});
          }
          if (j + 1 < col) {
            var b = idx + 1;
            var w = Math.abs(heights[i][j] - heights[i][j + 1]);
            edges.add(new int[] {idx, b, w});
          }
        }
      }
      edges.sort(Comparator.comparingInt(o -> o[2]));
      int start = 0;
      int end = row * col - 1;
      for (int[] edge : edges) {
        union(edge[0], edge[1]);
        if (query(start, end)) {
          return edge[2];
        }
      }
      return 0;
    }

    int N = (int)(1e5 + 9);
    int[] p = new int[N];
    int row, col;

    void union(int a, int b) {
      p[find(a)] = p[find(b)];
    }

    boolean query(int a, int b) {
      return find(a) == find(b);
    }

    int find(int x) {
      if (p[x] != x) {
        p[x] = find(p[x]);
      }
      return p[x];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
