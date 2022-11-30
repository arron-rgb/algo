package edu.neu.algo.review.leetcode.editor.en._20221117;

import edu.neu.util.InputUtil;

public class NetworkDelayTime {

  //// You are given a network of n nodes, labeled from 1 to n. You are also given
  //
  //// times, a list of travel times as directed edges times[i] = (ui, vi, wi),
  // where ui
  //// is the source node, vi is the target node, and wi is the time it takes for
  // a
  //// signal to travel from source to target.
  ////
  //// We will send a signal from a given node k. Return the minimum time it
  // takes
  //// for all the n nodes to receive the signal. If it is impossible for all the
  // n
  //// nodes to receive the signal, return -1.
  ////
  ////
  //// Example 1:
  ////
  ////
  //// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
  //// Output: 2
  ////
  ////
  //// Example 2:
  ////
  ////
  //// Input: times = [[1,2,1]], n = 2, k = 1
  //// Output: 1
  ////
  ////
  //// Example 3:
  ////
  ////
  //// Input: times = [[1,2,1]], n = 2, k = 2
  //// Output: -1
  ////
  ////
  ////
  //// Constraints:
  ////
  ////
  //// 1 <= k <= n <= 100
  //// 1 <= times.length <= 6000
  //// times[i].length == 3
  //// 1 <= ui, vi <= n
  //// ui != vi
  //// 0 <= wi <= 100
  //// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
  ////
  //// Related Topics Depth-First Search Breadth-First Search Graph Heap (
  // Priority
  //// Queue) Shortest Path 👍 5770 👎 323
  //

  public static void main(String[] args) {
    Solution solution = new NetworkDelayTime().new Solution();
    String[] data = """
                  [[2,1,1],[2,3,1],[3,4,1]]
      4
      2
      [[1,2,1]]
      2
      1
      [[1,2,1]]
      2
      2
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.networkDelayTime((int[][])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
