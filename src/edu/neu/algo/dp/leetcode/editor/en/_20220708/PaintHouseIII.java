package edu.neu.algo.dp.leetcode.editor.en._20220708;

import java.util.*;
import edu.neu.util.InputUtil;

public class PaintHouseIII {
  // 1473
  // There is a row of m houses in a small city, each house must be painted with
  // one of the n colors (labeled from 1 to n), some houses that have been painted
  // last summer should not be painted again.
  //
  // A neighborhood is a maximal group of continuous houses that are painted with
  // the same color.
  //
  //
  // For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2},
  // {3,3}, {2}, {1,1}].
  //
  //
  // Given an array houses, an m x n matrix cost and an integer target where:
  //
  //
  // houses[i]: is the color of the house i, and 0 if the house is not painted
  // yet.
  // cost[i][j]: is the cost of paint the house i with the color j + 1.
  //
  //
  // Return the minimum cost of painting all the remaining houses in such a way
  // that there are exactly target neighborhoods. If it is not possible, return -1.
  //
  //
  // Example 1:
  //
  //
  // Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5
  // , n = 2, target = 3
  // Output: 9
  // Explanation: Paint houses of this way [1,2,2,1,1]
  // This array contains target = 3 neighborhoods, [{1}, {2,2}, {1,1}].
  // Cost of paint all houses (1 + 1 + 1 + 1 + 5) = 9.
  //
  //
  // Example 2:
  //
  //
  // Input: houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5
  // , n = 2, target = 3
  // Output: 11
  // Explanation: Some houses are already painted, Paint the houses of this way [2,
  // 2,1,2,2]
  // This array contains target = 3 neighborhoods, [{2,2}, {1}, {2,2}].
  // Cost of paint the first and last house (10 + 1) = 11.
  //
  //
  // Example 3:
  //
  //
  // Input: houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n
  // = 3, target = 3
  // Output: -1
  // Explanation: Houses are already painted with a total of 4 neighborhoods [{3},{
  // 1},{2},{3}] different of target = 3.
  //
  //
  //
  // Constraints:
  //
  //
  // m == houses.length == cost.length
  // n == cost[i].length
  // 1 <= m <= 100
  // 1 <= n <= 20
  // 1 <= target <= m
  // 0 <= houses[i] <= n
  // 1 <= cost[i][j] <= 10⁴
  //
  // Related Topics Array Dynamic Programming 👍 1656 👎 126

  public static void main(String[] args) {

    Solution solution = new PaintHouseIII().new Solution();
    String[] data = """
          [0,0,0,0,0]
      [[1,10],[10,1],[10,1],[1,10],[5,1]]
      5
      2
      3
      [0,2,1,2,0]
      [[1,10],[10,1],[10,1],[1,10],[5,1]]
      5
      2
      3
      [3,1,2,3]
      [[1,1,1],[1,1,1],[1,1,1],[1,1,1]]
      4
      3
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[][], int, int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minCost((int[])params[1 + i * paramTypes.length - 1],
        (int[][])params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length],
        (int)params[4 - 1 + i * paramTypes.length], (int)params[5 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int INF = 0x3f3f3f3f;

    public int minCost(int[] houses, int[][] cost, int m, int n, int t) {
      int[][][] f = new int[m + 1][n + 1][t + 1];
      // 不存在分区数量为 0 的状态
      for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
          f[i][j][0] = INF;
        }
      }
      for (int i = 1; i <= m; i++) {
        int color = houses[i - 1];
        for (int j = 1; j <= n; j++) {
          for (int k = 1; k <= t; k++) {
            // 形成分区数量大于房子数量，状态无效
            if (k > i) {
              f[i][j][k] = INF;
              continue;
            }

            // 第 i 间房间已经上色
            if (color != 0) {
              if (j == color) { // 只有与「本来的颜色」相同的状态才允许被转移
                int tmp = INF;
                // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
                for (int p = 1; p <= n; p++) {
                  if (p != j) {
                    tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                  }
                }
                // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
                f[i][j][k] = Math.min(f[i - 1][j][k], tmp);
              } else { // 其余状态无效
                f[i][j][k] = INF;
              }
            } else {
              // 第 i 间房间尚未上色
              int u = cost[i - 1][j - 1];
              int tmp = INF;
              // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
              for (int p = 1; p <= n; p++) {
                if (p != j) {
                  tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                }
              }
              // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
              // 并将「上色成本」添加进去
              f[i][j][k] = Math.min(tmp, f[i - 1][j][k]) + u;
            }
          }
        }
      }

      // 从「考虑所有房间，并且形成分区数量为 t」的所有方案中找答案
      int ans = INF;
      for (int i = 1; i <= n; i++) {
        ans = Math.min(ans, f[m][i][t]);
      }
      return ans == INF ? -1 : ans;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
