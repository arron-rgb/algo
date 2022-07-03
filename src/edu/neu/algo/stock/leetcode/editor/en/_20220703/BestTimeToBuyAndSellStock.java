package edu.neu.algo.stock.leetcode.editor.en._20220703;

import java.util.Arrays;

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
  // Related Topics Array Dynamic Programming 👍 17482 👎 568

  public static void main(String[] args) {
    Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    String[] data = """
          [7,1,5,3,6,4]
      [7,6,4,3,1]
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
      System.out.println(Arrays.deepToString(dp));
      return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
