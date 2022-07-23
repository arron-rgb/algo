package edu.neu.algo.review.leetcode.editor.en._20220720;

import java.util.*;
import edu.neu.util.InputUtil;

public class FindEventualSafeStates {
  // 802
  // There is a directed graph of n nodes with each node labeled from 0 to n - 1.
  // The graph is represented by a 0-indexed 2D integer array graph where graph[i] is
  // an integer array of nodes adjacent to node i, meaning there is an edge from
  // node i to each node in graph[i].
  //
  // A node is a terminal node if there are no outgoing edges. A node is a safe
  // node if every possible path starting from that node leads to a terminal node (or
  // another safe node).
  //
  // Return an array containing all the safe nodes of the graph. The answer
  // should be sorted in ascending order.
  //
  //
  // Example 1:
  //
  //
  // Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
  // Output: [2,4,5,6]
  // Explanation: The given graph is shown above.
  // Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either
  // of them.
  // Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
  //
  // Example 2:
  //
  //
  // Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
  // Output: [4]
  // Explanation:
  // Only node 4 is a terminal node, and every path starting at node 4 leads to
  // node 4.
  //
  //
  //
  // Constraints:
  //
  //
  // n == graph.length
  // 1 <= n <= 10⁴
  // 0 <= graph[i].length <= n
  // 0 <= graph[i][j] <= n - 1
  // graph[i] is sorted in a strictly increasing order.
  // The graph may contain self-loops.
  // The number of edges in the graph will be in the range [1, 4 * 10⁴].
  //
  // Related Topics Depth-First Search Breadth-First Search Graph Topological
  // Sort 👍 2424 👎 330

  public static void main(String[] args) {
    Solution solution = new FindEventualSafeStates().new Solution();
    String[] data = """
          [[1,2],[2,3],[5],[0],[5],[],[]]
      [[1,2,3,4],[1,2],[3,4],[0,4],[]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.eventualSafeNodes((int[][])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
      int n = graph.length;
      List<List<Integer>> map = new ArrayList<>();
      for (int i = 0; i < n; ++i) {
        map.add(new ArrayList<>());
      }
      int[] ingress = new int[n];
      for (int x = 0; x < n; ++x) {
        for (int y : graph[x]) {
          map.get(y).add(x);
        }
        ingress[x] = graph[x].length;
      }

      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < n; ++i) {
        if (ingress[i] == 0) {
          queue.offer(i);
        }
      }
      while (!queue.isEmpty()) {
        int y = queue.poll();
        for (int x : map.get(y)) {
          if (--ingress[x] == 0) {
            queue.offer(x);
          }
        }
      }

      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < n; ++i) {
        if (ingress[i] == 0) {
          res.add(i);
        }
      }
      return res;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
