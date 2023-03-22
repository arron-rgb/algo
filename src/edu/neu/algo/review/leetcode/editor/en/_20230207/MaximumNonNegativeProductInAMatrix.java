package edu.neu.algo.review.leetcode.editor.en._20230207;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MaximumNonNegativeProductInAMatrix {
  // 1594
  // You are given a m x n matrix grid. Initially, you are located at the top-left
  // corner (0, 0), and in each step, you can only move right or down in the matrix.
  //
  //
  // Among all possible paths starting from the top-left corner (0, 0) and ending
  // in the bottom-right corner (m - 1, n - 1), find the path with the maximum non-
  // negative product. The product of a path is the product of all integers in the
  // grid cells visited along the path.
  //
  // Return the maximum non-negative product modulo 10⁹ + 7. If the maximum
  // product is negative, return -1.
  //
  // Notice that the modulo is performed after getting the maximum product.
  //
  //
  // Example 1:
  //
  //
  // Input: grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
  // Output: -1
  // Explanation: It is not possible to get non-negative product in the path from (
  // 0, 0) to (2, 2), so return -1.
  //
  //
  // Example 2:
  //
  //
  // Input: grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
  // Output: 8
  // Explanation: Maximum non-negative product is shown (1 * 1 * -2 * -4 * 1 = 8).
  //
  //
  // Example 3:
  //
  //
  // Input: grid = [[1,3],[0,-4]]
  // Output: 0
  // Explanation: Maximum non-negative product is shown (1 * 0 * -4 = 0).
  //
  //
  //
  // Constraints:
  //
  //
  // m == grid.length
  // n == grid[i].length
  // 1 <= m, n <= 15
  // -4 <= grid[i][j] <= 4
  //
  //
  // Related Topics Array Dynamic Programming Matrix 👍 684 👎 32

  public static void main(String[] args) {
    Solution solution = new MaximumNonNegativeProductInAMatrix().new Solution();
    String[] data = """
                  [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
      [[1,-2,1],[1,-2,1],[3,-4,1]]
      [[1,3],[0,-4]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxProductPath((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxProductPath(int[][] g) {
      int m = g.length, n = g[0].length, mod = 1_000_000_007;
      long[][][] dp = new long[m][n][2];
      dp[0][0] = new long[] {g[0][0], g[0][0]};
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0 && j == 0)
            continue;
          long a = 0, b = 0;
          if (i == 0) {
            dp[i][j][0] = dp[i][j][1] = g[i][j] * dp[i][j - 1][0];
          } else if (j == 0) {
            dp[i][j][0] = dp[i][j][1] = g[i][j] * dp[i - 1][j][0];
          } else {
            a = g[i][j] * Math.max(dp[i][j - 1][0], dp[i - 1][j][0]);
            b = g[i][j] * Math.min(dp[i][j - 1][1], dp[i - 1][j][1]);
            dp[i][j][0] = Math.max(a, b);
            dp[i][j][1] = Math.min(a, b);
          }
        }
      }
      System.out.println(Arrays.deepToString(dp));
      if (dp[m - 1][n - 1][0] < 0)
        return -1;
      return (int)((dp[m - 1][n - 1][0]) % mod);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
