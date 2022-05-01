package edu.neu.algo.leetcode.editor.en._20220426;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints {

  // You are given an array points representing integer coordinates of some points
  // on a 2D-plane, where points[i] = [xi, yi].
  //
  // The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan
  // distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute
  // value of val.
  //
  // Return the minimum cost to make all points connected. All points are
  // connected if there is exactly one simple path between any two points.
  //
  //
  // Example 1:
  //
  //
  // Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
  // Output: 20
  // Explanation:
  //
  // We can connect the points as shown above to get the minimum cost of 20.
  // Notice that there is a unique path between every pair of points.
  //
  //
  // Example 2:
  //
  //
  // Input: points = [[3,12],[-2,5],[-4,1]]
  // Output: 18
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= points.length <= 1000
  // -10⁶ <= xi, yi <= 10⁶
  // All pairs (xi, yi) are distinct.
  //
  // Related Topics Array Union Find Minimum Spanning Tree 👍 1440 👎 49

  public static void main(String[] args) {
    Solution solution = new MinCostToConnectAllPoints().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minCostConnectPoints(int[][] points) {
      Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
      int n = points.length;
      for (int i = 0; i < n; i++) {
        int d = getDistance(points[0], points[i]);
        queue.add(new int[] {0, i, d});
      }

      boolean[] visited = new boolean[n];
      int cost = 0;
      int count = n - 1;

      visited[0] = true;

      while (queue.size() > 0 && count > 0) {
        int[] current = queue.poll();
        int v2 = current[1];
        int distance = current[2];
        if (!visited[v2]) {
          cost += distance;
          visited[v2] = true;
          count--;
          for (int i = 0; i < n; i++) {
            if (!visited[i]) {
              int d = getDistance(points[current[1]], points[i]);
              queue.add(new int[] {v2, i, d});
            }
          }
        }
      }
      return cost;

    }

    private int getDistance(int[] p1, int[] p2) {
      return Math.abs(p2[0] - p1[0]) + Math.abs(p2[1] - p1[1]);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
