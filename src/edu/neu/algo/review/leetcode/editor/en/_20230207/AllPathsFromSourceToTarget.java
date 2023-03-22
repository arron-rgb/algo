package edu.neu.algo.review.leetcode.editor.en._20230207;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class AllPathsFromSourceToTarget {
  // 797
  // Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find
  // all possible paths from node 0 to node n - 1 and return them in any order.
  //
  // The graph is given as follows: graph[i] is a list of all nodes you can visit
  // from node i (i.e., there is a directed edge from node i to node graph[i][j]).
  //
  //
  // Example 1:
  //
  //
  // Input: graph = [[1,2],[3],[3],[]]
  // Output: [[0,1,3],[0,2,3]]
  // Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
  //
  //
  // Example 2:
  //
  //
  // Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
  // Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
  //
  //
  //
  // Constraints:
  //
  //
  // n == graph.length
  // 2 <= n <= 15
  // 0 <= graph[i][j] < n
  // graph[i][j] != i (i.e., there will be no self-loops).
  // All the elements of graph[i] are unique.
  // The input graph is guaranteed to be a DAG.
  //
  //
  // Related Topics Backtracking Depth-First Search Breadth-First Search Graph 👍
  // 6229 👎 131

  public static void main(String[] args) {
    Solution solution = new AllPathsFromSourceToTarget().new Solution();
    String[] data = """
                  [[1,2],[3],[3],[]]
      [[4,3,1],[3,2,4],[3],[4],[]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.allPathsSourceTarget((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      List<List<Integer>> res = new ArrayList<>();
      if (graph.length == 0)
        return res;
      List<Integer> path = new ArrayList<>();
      path.add(0);// adding starting 0th node initially
      dfs(graph, 0, path, res);
      return res;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
      if (node == graph.length - 1) { // node is index in graph i.e. each row or individual sub list
        res.add(new ArrayList<>(path));// when it reaches to end(graph.lenght-1) then add that path to res
        return;
      }
      for (int n : graph[node]) {// traversing on each sublist or and finding path from that again
        path.add(n);
        dfs(graph, n, path, res);
        path.remove(path.size() - 1);// backtracking
      }

    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
