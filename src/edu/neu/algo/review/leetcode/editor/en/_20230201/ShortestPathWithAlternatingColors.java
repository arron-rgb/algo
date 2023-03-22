package edu.neu.algo.review.leetcode.editor.en._20230201;

import edu.neu.util.InputUtil;

import java.util.*;

public class ShortestPathWithAlternatingColors {
  // 1129
  // You are given an integer n, the number of nodes in a directed graph where the
  // nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and
  // there could be self-edges and parallel edges.
  //
  // You are given two arrays redEdges and blueEdges where:
  //
  //
  // redEdges[i] = [ai, bi] indicates that there is a directed red edge from node
  // ai to node bi in the graph, and
  // blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from
  // node uj to node vj in the graph.
  //
  //
  // Return an array answer of length n, where each answer[x] is the length of
  // the shortest path from node 0 to node x such that the edge colors alternate along
  // the path, or -1 if such a path does not exist.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
  // Output: [0,1,-1]
  //
  //
  // Example 2:
  //
  //
  // Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
  // Output: [0,1,-1]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 100
  // 0 <= redEdges.length, blueEdges.length <= 400
  // redEdges[i].length == blueEdges[j].length == 2
  // 0 <= ai, bi, uj, vj < n
  //
  //
  // Related Topics Breadth-First Search Graph 👍 1727 👎 82

  public static void main(String[] args) {
    Solution solution = new ShortestPathWithAlternatingColors().new Solution();

    String[] data = """
      3
      [[0,1],[1,2]]
      []
      3
      [[0,1]]
      [[2,1]]
      5
      [[0,1],[1,2],[2,3],[3,4]]
      [[1,2],[2,3],[3,1]]
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[][], int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.shortestAlternatingPaths((int)params[1 - 1 + i * paramTypes.length],
        (int[][])params[2 - 1 + i * paramTypes.length], (int[][])params[3 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
      Map<Integer, List<List<Integer>>> adj = new HashMap<>();
      for (int[] redEdge : redEdges) {
        adj.computeIfAbsent(redEdge[0], k -> new ArrayList<>()).add(Arrays.asList(redEdge[1], 0));
      }

      for (int[] blueEdge : blueEdges) {
        adj.computeIfAbsent(blueEdge[0], k -> new ArrayList<>()).add(Arrays.asList(blueEdge[1], 1));
      }

      int[] answer = new int[n];
      Arrays.fill(answer, -1);
      boolean[][] visit = new boolean[n][2];
      Queue<int[]> q = new LinkedList<>();

      // Start with node 0, with number of steps as 0 and undefined color -1.
      q.offer(new int[] {0, 0, -1});
      answer[0] = 0;
      visit[0][1] = visit[0][0] = true;

      while (!q.isEmpty()) {
        int[] element = q.poll();
        int node = element[0], steps = element[1], prevColor = element[2];

        for (List<Integer> nei : adj.getOrDefault(node, List.of())) {
          int neighbor = nei.get(0);
          int color = nei.get(1);
          if (!visit[neighbor][color] && color != prevColor) {
            if (answer[neighbor] == -1)
              answer[neighbor] = 1 + steps;
            visit[neighbor][color] = true;
            q.offer(new int[] {neighbor, 1 + steps, color});
          }
        }
      }
      return answer;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)
}
