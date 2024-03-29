package edu.neu.algo.review.leetcode.editor.en._20230130;

import edu.neu.util.InputUtil;

public class ClimbingStairs {

  // You are climbing a staircase. It takes n steps to reach the top.
  //
  // Each time you can either climb 1 or 2 steps. In how many distinct ways can
  // you climb to the top?
  //
  //
  // Example 1:
  //
  //
  // Input: n = 2
  // Output: 2
  // Explanation: There are two ways to climb to the top.
  // 1. 1 step + 1 step
  // 2. 2 steps
  //
  //
  // Example 2:
  //
  //
  // Input: n = 3
  // Output: 3
  // Explanation: There are three ways to climb to the top.
  // 1. 1 step + 1 step + 1 step
  // 2. 1 step + 2 steps
  // 3. 2 steps + 1 step
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 45
  //
  // Related Topics Math Dynamic Programming Memoization 👍 16223 👎 487

  public static void main(String[] args) {
    Solution solution = new ClimbingStairs().new Solution();
    String[] data = """
                  2
      3
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.climbStairs((int)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int climbStairs(int n) {
      if (n < 4) {
        return n;
      }
      int[] dp = new int[n + 1];
      dp[0] = 1;
      int[] steps = new int[] {1, 2};
      // dp[1] = 1;
      // dp[2] = 2;
      for (int i = 1; i <= n; i++) {
        for (int step : steps) {
          if (i - step >= 0) {
            // i 可以从 i-step 走一步达到
            dp[i] = dp[i] + dp[i - step];
          }
        }
        // dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
