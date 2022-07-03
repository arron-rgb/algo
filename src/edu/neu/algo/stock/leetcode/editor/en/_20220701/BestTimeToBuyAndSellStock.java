package edu.neu.algo.stock.leetcode.editor.en._20220701;

import edu.neu.util.InputUtil;

public class BestTimeToBuyAndSellStock {
  // 121
  // You are given an array prices where prices[i] is the price of a given stock
  // on the iᵗʰ day.
  //
  // You want to maximize your profit by choosing a single day to buy one stock
  // and choosing a different day in the future to sell that stock.
  //
  // Return the maximum profit you can achieve from this transaction. If you
  // cannot achieve any profit, return 0.
  //
  //
  // Example 1:
  //
  //
  // Input: prices = [7,1,5,3,6,4]
  // Output: 5
  // Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
  // 6-1 = 5.
  // Note that buying on day 2 and selling on day 1 is not allowed because you
  // must buy before you sell.
  //
  //
  // Example 2:
  //
  //
  // Input: prices = [7,6,4,3,1]
  // Output: 0
  // Explanation: In this case, no transactions are done and the max profit = 0.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= prices.length <= 10⁵
  // 0 <= prices[i] <= 10⁴
  //
  // Related Topics Array Dynamic Programming 👍 17435 👎 566

  public static void main(String[] args) {
    Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    String[] data = """
          [7,1,5,3,6,4]
      [7,6,4,3,1]
      [1]
      [1,2]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxProfit((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // public int maxProfit(int[] prices) {
    // int[] dp = new int[2];
    // // 记录一次交易，一次交易有买入卖出两种状态
    // // 0代表持有，1代表卖出
    // dp[0] = -prices[0];
    // // 可以参考斐波那契问题的优化方式
    // // 我们从 i=1 开始遍历数组，一共有 prices.length 天，
    // // 所以是 i<=prices.length
    // for (int i = 1; i <= prices.length; i++) {
    // // 前一天持有；或当天买入
    // dp[0] = Math.max(dp[0], -prices[i - 1]);
    // // 如果 dp[0] 被更新，那么 dp[1] 肯定会被更新为正数的 dp[1]
    // // 而不是 dp[0]+prices[i-1]==0 的0，
    // // 所以这里使用会改变的dp[0]也是可以的
    // // 当然 dp[1] 初始值为 0 ，被更新成 0 也没影响
    // // 前一天卖出；或当天卖出, 当天要卖出，得前一天持有才行
    // dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
    // }
    // return dp[1];
    // }
    public int maxProfit(int[] prices) {
      int n = prices.length;
      // 一次交易有买入卖出两种状态
      int[][] dp = new int[n + 1][2];
      dp[0][0] = -prices[0];
      dp[0][1] = 0;

      for (int i = 1; i < n; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
      }
      return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
