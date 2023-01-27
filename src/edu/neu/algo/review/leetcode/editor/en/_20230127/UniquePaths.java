package edu.neu.algo.review.leetcode.editor.en._20230127;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class UniquePaths {
  // 62
  // There is a robot on an m x n grid. The robot is initially located at the top-
  // left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right
  // corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at
  // any point in time.
  //
  // Given the two integers m and n, return the number of possible unique paths
  // that the robot can take to reach the bottom-right corner.
  //
  // The test cases are generated so that the answer will be less than or equal
  // to 2 * 10⁹.
  //
  //
  // Example 1:
  //
  //
  // Input: m = 3, n = 7
  // Output: 28
  //
  //
  // Example 2:
  //
  //
  // Input: m = 3, n = 2
  // Output: 3
  // Explanation: From the top-left corner, there are a total of 3 ways to reach
  // the bottom-right corner:
  // 1. Right -> Down -> Down
  // 2. Down -> Down -> Right
  // 3. Down -> Right -> Down
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= m, n <= 100
  //
  //
  // Related Topics Math Dynamic Programming Combinatorics 👍 12841 👎 370

  public static void main(String[] args) {
    Solution solution = new UniquePaths().new Solution();
    String[] data = """
                  3
      7
      3
      2
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.uniquePaths((int)params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int uniquePaths(int m, int n) {
      int[][] dp = new int[m][n];
      Arrays.fill(dp[0], 1);
      for (int i = 0; i < m; i++) {
        dp[i][0] = 1;
      }

      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          dp[i][j] += dp[i - 1][j];
          dp[i][j] += dp[i][j - 1];
        }
      }
      return dp[m - 1][n - 1];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
