package edu.neu.algo.review.leetcode.editor.en._20230219;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class ShortestPathVisitingAllNodes {
  // 847
  // You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
  // You are given an array graph where graph[i] is a list of all the nodes connected
  // with node i by an edge.
  //
  // Return the length of the shortest path that visits every node. You may start
  // and stop at any node, you may revisit nodes multiple times, and you may reuse
  // edges.
  //
  //
  // Example 1:
  //
  //
  // Input: graph = [[1,2,3],[0],[0],[0]]
  // Output: 4
  // Explanation: One possible path is [1,0,2,0,3]
  //
  //
  // Example 2:
  //
  //
  // Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
  // Output: 4
  // Explanation: One possible path is [0,1,4,2,3]
  //
  //
  //
  // Constraints:
  //
  //
  // n == graph.length
  // 1 <= n <= 12
  // 0 <= graph[i].length < n
  // graph[i] does not contain i.
  // If graph[a] contains b, then graph[b] contains a.
  // The input graph is always connected.
  //
  //
  // Related Topics Dynamic Programming Bit Manipulation Breadth-First Search
  // Graph Bitmask 👍 3086 👎 138

  public static void main(String[] args) {
    Solution solution = new ShortestPathVisitingAllNodes().new Solution();
    String[] data = """
                  [[1,2,3],[0],[0],[0]]
      [[1],[0,2,4],[1,3,4],[2],[1,2]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.shortestPathLength((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int INF = 0x3f3f3f3f;

    public int shortestPathLength(int[][] graph) {
      int n = graph.length;
      int mask = 1 << n;
      // 初始化所有的 (state, u) 距离为正无穷
      int[][] dist = new int[mask][n];
      for (int i = 0; i < mask; i++)
        Arrays.fill(dist[i], INF);
      // 因为可以从任意起点出发，先将起始的起点状态入队，并设起点距离为 0
      Deque<int[]> d = new ArrayDeque<>(); // state, u
      for (int i = 0; i < n; i++) {
        dist[1 << i][i] = 0;
        d.addLast(new int[] {1 << i, i});
      }
      // BFS 过程，如果从点 u 能够到达点 i，则更新距离并进行入队
      while (!d.isEmpty()) {
        int[] poll = d.pollFirst();
        int state = poll[0], u = poll[1], step = dist[state][u];
        if (state == mask - 1)
          return step;
        for (int i : graph[u]) {
          if (dist[state | (1 << i)][i] == INF) {
            dist[state | (1 << i)][i] = step + 1;
            d.addLast(new int[] {state | (1 << i), i});
          }
        }
      }
      return -1; // never
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
