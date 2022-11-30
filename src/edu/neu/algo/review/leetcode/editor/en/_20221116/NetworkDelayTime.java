package edu.neu.algo.review.leetcode.editor.en._20221116;

import edu.neu.util.InputUtil;

import java.util.Arrays;

public class NetworkDelayTime {

  // You are given a network of n nodes, labeled from 1 to n. You are also given
  // times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui
  // is the source node, vi is the target node, and wi is the time it takes for a
  // signal to travel from source to target.
  //
  // We will send a signal from a given node k. Return the minimum time it takes
  // for all the n nodes to receive the signal. If it is impossible for all the n
  // nodes to receive the signal, return -1.
  //
  //
  // Example 1:
  //
  //
  // Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
  // Output: 2
  //
  //
  // Example 2:
  //
  //
  // Input: times = [[1,2,1]], n = 2, k = 1
  // Output: 1
  //
  //
  // Example 3:
  //
  //
  // Input: times = [[1,2,1]], n = 2, k = 2
  // Output: -1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= k <= n <= 100
  // 1 <= times.length <= 6000
  // times[i].length == 3
  // 1 <= ui, vi <= n
  // ui != vi
  // 0 <= wi <= 100
  // All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
  //
  // Related Topics Depth-First Search Breadth-First Search Graph Heap (Priority
  // Queue) Shortest Path 👍 5770 👎 323

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
                  """
      // [[0,11,16],[0,12,22],[0,13,18],[11,21,8],[12,21,12],[13,22,11],[12,22,13],[13,21,15],[21,31,7],[21,32,21],[22,31,17],[22,32,13],[22,33,19],[31,4,9],[32,4,18],[33,4,20]]
      // 0
      // 4
      .trim().replaceAll("\n", "|").split("\\|");
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
    int N = 110, M = 6010;
    // 邻接矩阵数组：w[a][b] = c 代表从 a 到 b 有权重为 c 的边
    int[][] w = new int[N][N];
    // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
    int[] dist = new int[N];
    // 记录哪些点已经被更新过
    boolean[] vis = new boolean[N];
    int INF = 0x3f3f3f3f;
    int n, k;

    public int networkDelayTime(int[][] ts, int _n, int _k) {
      n = _n;
      k = _k;
      // 初始化邻接矩阵
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          w[i][j] = w[j][i] = i == j ? 0 : INF;
        }
      }
      // 存图
      for (int[] t : ts) {
        int u = t[0], v = t[1], c = t[2];
        w[u][v] = c;
      }
      // 最短路
      dijkstra();
      // 遍历答案
      int ans = 0;
      for (int i = 1; i <= n; i++) {
        ans = Math.max(ans, dist[i]);
      }
      return ans > INF / 2 ? -1 : ans;
    }

    void dijkstra() {
      // 起始先将所有的点标记为「未更新」和「距离为正无穷」
      Arrays.fill(vis, false);
      Arrays.fill(dist, INF);
      // 只有起点最短距离为 0
      dist[k] = 0;
      // 迭代 n 次
      for (int p = 1; p <= n; p++) {
        // 每次找到「最短距离最小」且「未被更新」的点 t
        int t = -1;
        for (int i = 1; i <= n; i++) {
          if (!vis[i] && (t == -1 || dist[i] < dist[t]))
            t = i;
        }
        // 标记点 t 为已更新
        vis[t] = true;
        // 用点 t 的「最小距离」更新其他点
        for (int i = 1; i <= n; i++) {
          dist[i] = Math.min(dist[i], dist[t] + w[t][i]);
        }
      }
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
