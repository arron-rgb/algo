package edu.neu.algo.leetcode.editor.en._20220616;

import edu.neu.util.InputUtil;

public class MinCostClimbingStairs {

  // You are given an integer array cost where cost[i] is the cost of iᵗʰ step on
  // a staircase. Once you pay the cost, you can either climb one or two steps.
  //
  // You can either start from the step with index 0, or the step with index 1.
  //
  // Return the minimum cost to reach the top of the floor.
  //
  //
  // Example 1:
  //
  //
  // Input: cost = [10,15,20]
  // Output: 15
  // Explanation: You will start at index 1.
  // - Pay 15 and climb two steps to reach the top.
  // The total cost is 15.
  //
  //
  // Example 2:
  //
  //
  // Input: cost = [1,100,1,1,1,100,1,1,100,1]
  // Output: 6
  // Explanation: You will start at index 0.
  // - Pay 1 and climb two steps to reach index 2.
  // - Pay 1 and climb two steps to reach index 4.
  // - Pay 1 and climb two steps to reach index 6.
  // - Pay 1 and climb one step to reach index 7.
  // - Pay 1 and climb two steps to reach index 9.
  // - Pay 1 and climb one step to reach the top.
  // The total cost is 6.
  //
  //
  //
  // Constraints:
  //
  //
  // 2 <= cost.length <= 1000
  // 0 <= cost[i] <= 999
  //
  // Related Topics Array Dynamic Programming 👍 6106 👎 1062

  public static void main(String[] args) {
    Solution solution = new MinCostClimbingStairs().new Solution();
    int i = solution.minCostClimbingStairs(InputUtil.stringToArray("[1,100,1,1,1,100,1,1,100,1]"));
    System.out.println(i);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minCostClimbingStairs(int[] cost) {
      int n = cost.length;
      int[] dp = new int[n + 1];
      dp[0] = cost[0];
      dp[1] = cost[1];
      for (int i = 2; i < n; i++) {
        dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
      }
      // n 为终点 n-2, n-1 都可以一步到n
      return Math.min(dp[n - 2], dp[n - 1]);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
