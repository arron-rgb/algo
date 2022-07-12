package edu.neu.algo.dp.leetcode.editor.en._20220712;

import java.util.*;
import edu.neu.util.InputUtil;

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
  // Related Topics Dynamic Programming Bit Manipulation Breadth-First Search
  // Graph Bitmask 👍 2595 👎 125

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
      int q = solution.shortestPathLength((int[][])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    /**
     * leetcode: 状态压缩 + 广度优先搜索 path 是一个长度为 n 的二进制数，表示每一个节点是否经过。 如果 path 的第 i 位是 1，则表示节点 i 已经过，否则表示节点 i 未经过；
     * bfs先到达的一定更优,这个常识,因为水波式扩散 save[v][mask_v]记录的是跑到v节点时状态为mask_v(通过状压记录状态,如果某个节点跑到过就让mask_v对应二进制位为1),
     * 而!save[v][mask_v]则是看对于跑到当前节点v状态为mask_v的情况之前是否发生过,根据性质1,
     * 如果之前发生过,那么肯定之前的更优(准确说是不会更劣),那么用之前那个就可以,那当前这个情况就可以忽略了(这个也保证了不会绕圈圈)
     */
    public int shortestPathLength(int[][] graph) {
      int n = graph.length;
      boolean[][] visited = new boolean[n][1 << n];
      Deque<int[]> deque = new ArrayDeque<>();
      for (int i = 0; i < n; ++i) {
        deque.add(new int[] {i, 1 << i, 0});
        visited[i][1 << i] = true;
      }
      int res = 0;
      while (!deque.isEmpty()) {
        int[] poll = deque.remove();
        int u = poll[0], path = poll[1], dist = poll[2];
        if (path == (1 << n) - 1) {
          res = dist;
          break;
        }
        for (int v : graph[u]) {
          // todo 将 path 的第 v 位置为 1,即将v加入path，看是否已经有过这种情况
          int pathV = path | (1 << v);
          if (!visited[v][pathV]) {
            visited[v][pathV] = true;
            deque.add(new int[] {v, pathV, dist + 1});
          }
        }
      }
      return res;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
