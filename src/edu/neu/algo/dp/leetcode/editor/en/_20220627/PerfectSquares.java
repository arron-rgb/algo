package edu.neu.algo.dp.leetcode.editor.en._20220627;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class PerfectSquares {
  // 279
  // Given an integer n, return the least number of perfect square numbers that
  // sum to n.
  //
  // A perfect square is an integer that is the square of an integer; in other
  // words, it is the product of some integer with itself. For example, 1, 4, 9, and 16
  // are perfect squares while 3 and 11 are not.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 12
  // Output: 3
  // Explanation: 12 = 4 + 4 + 4.
  //
  //
  // Example 2:
  //
  //
  // Input: n = 13
  // Output: 2
  // Explanation: 13 = 4 + 9.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 10⁴
  //
  // Related Topics Math Dynamic Programming Breadth-First Search 👍 6919 👎 301

  public static void main(String[] args) {
    Solution solution = new PerfectSquares().new Solution();
    String[] data = """
          12
      13
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numSquares((int)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numSquares(int n) {
      int[] dp = new int[n + 1];
      // dp[i] 表示几个平方数能凑够i
      // dp[i] = dp[i-j*j] + 1
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;
      for (int i = 1; i < dp.length; i++) {
        // 1与 [1, 根号n]中的平方数组合 能凑出哪些数
        for (int j = 1; j * j < n; j++) {
          if (i - j * j >= 0) {
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
          }
        }
      }
      return dp[n];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
