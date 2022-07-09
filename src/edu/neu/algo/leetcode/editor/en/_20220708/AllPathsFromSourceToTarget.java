package edu.neu.algo.leetcode.editor.en._20220708;

import java.util.*;

import edu.neu.util.InputUtil;

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
  // Related Topics Backtracking Depth-First Search Breadth-First Search Graph 👍
  // 4463 👎 119

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
      int n = graph.length;
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < graph.length; i++) {
        for (int i1 : graph[i]) {
          map.computeIfAbsent(i, t -> new ArrayList<>()).add(i1);
        }
      }
      // 存结果
      List<List<Integer>> res = new ArrayList<>();
      // 存中间
      List<List<Integer>> paths = new ArrayList<>();
      Deque<Integer> deque = new ArrayDeque<>();
      deque.add(0);
      paths.add(new ArrayList<>(List.of(0)));
      while (!deque.isEmpty()) {
        int size = deque.size();
        List<List<Integer>> next = new ArrayList<>();
        // size = 1
        for (int i = 0; i < size; i++) {
          List<Integer> tmp = paths.get(i);
          // 0
          Integer remove = deque.remove();
          // 遍历remove能到的点
          // 1, 2
          for (int target : map.getOrDefault(remove, new ArrayList<>())) {
            tmp.add(target);
            if (target == n - 1) {
              res.add(new ArrayList<>(tmp));
              tmp.remove(tmp.size() - 1);
              continue;
            }
            deque.add(target);
            next.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
          }
        }
        paths = next;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
