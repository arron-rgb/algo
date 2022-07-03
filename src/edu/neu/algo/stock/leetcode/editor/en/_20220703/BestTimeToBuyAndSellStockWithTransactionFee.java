package edu.neu.algo.stock.leetcode.editor.en._20220703;

import edu.neu.util.InputUtil;

public class BestTimeToBuyAndSellStockWithTransactionFee {
  // 714
  // You are given an array prices where prices[i] is the price of a given stock
  // on the iᵗʰ day, and an integer fee representing a transaction fee.
  //
  // Find the maximum profit you can achieve. You may complete as many
  // transactions as you like, but you need to pay the transaction fee for each transaction.
  //
  // Note: You may not engage in multiple transactions simultaneously (i.e., you
  // must sell the stock before you buy again).
  //
  //
  // Example 1:
  //
  //
  // Input: prices = [1,3,2,8,4,9], fee = 2
  // Output: 8
  // Explanation: The maximum profit can be achieved by:
  // - Buying at prices[0] = 1
  // - Selling at prices[3] = 8
  // - Buying at prices[4] = 4
  // - Selling at prices[5] = 9
  // The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
  //
  //
  // Example 2:
  //
  //
  // Input: prices = [1,3,7,5,10,3], fee = 3
  // Output: 6
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= prices.length <= 5 * 10⁴
  // 1 <= prices[i] < 5 * 10⁴
  // 0 <= fee < 5 * 10⁴
  //
  // Related Topics Array Dynamic Programming Greedy 👍 4181 👎 106

  public static void main(String[] args) {
    Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
    String[] data = """
          [1,3,2,8,4,9]
      2
      [1,3,7,5,10,3]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.maxProfit((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxProfit(int[] prices, int fee) {
      int len = prices.length;
      // 0 : 持股（买入）
      // 1 : 不持股（售出）
      // dp 定义第i天持股/不持股 所得最多现金
      int[][] dp = new int[len][2];
      dp[0][0] = -prices[0];
      for (int i = 1; i < len; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
      }
      return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
