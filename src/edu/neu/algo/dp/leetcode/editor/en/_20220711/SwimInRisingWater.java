package edu.neu.algo.dp.leetcode.editor.en._20220711;

import java.util.*;
import edu.neu.util.InputUtil;

public class SwimInRisingWater {
  // 778
  // kruskal 求最小生成树
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
  // Union Find Heap (Priority Queue) Matrix 👍 2251 👎 157

  public static void main(String[] args) {
    Solution solution = new SwimInRisingWater().new Solution();
    String[] data = """
          [[0]]
          [[0,2],[1,3]]
      [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.swimInWater((int[][])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    int n;
    int[] p;

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

    public int swimInWater(int[][] grid) {
      n = grid.length;
      if (n == 1) {
        return grid[0][0];
      }
      p = new int[n * n];
      for (int i = 0; i < n * n; i++) {
        p[i] = i;
      }
      List<int[]> edges = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          int idx = i * n + j;
          p[idx] = idx;
          if (i + 1 < n) {
            var b = idx + n;
            int w = Math.max(grid[i][j], grid[i + 1][j]);
            edges.add(new int[] {idx, b, w});
          }
          if (j + 1 < n) {
            var b = idx + 1;
            var w = Math.max(grid[i][j], grid[i][j + 1]);
            edges.add(new int[] {idx, b, w});
          }
        }
      }
      edges.sort(Comparator.comparingInt(o -> o[2]));
      int start = 0;
      // (n-1)*n+(n-1)
      int end = n * n - 1;
      for (int[] edge : edges) {
        union(edge[0], edge[1]);
        if (query(start, end)) {
          return edge[2];
        }
      }
      return -1;
    }

    private int bfsSolution(int[][] grid) {
      int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
      int m = grid.length;
      int n = grid[0].length;
      boolean[][] visited = new boolean[m][n];
      queue.add(new int[] {0, 0});
      visited[0][0] = true;
      int max = -1;
      while (!queue.isEmpty()) {
        int[] poll = queue.poll();
        // System.out.println(Arrays.toString(poll));
        max = Math.max(max, grid[poll[0]][poll[1]]);
        if (poll[0] == m - 1 && poll[1] == n - 1) {
          return max;
        }
        for (int[] direction : directions) {
          int nextI = direction[0] + poll[0];
          int nextJ = direction[1] + poll[1];
          if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !visited[nextI][nextJ]) {
            queue.add(new int[] {nextI, nextJ});
            visited[nextI][nextJ] = true;
          }
        }
      }
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
