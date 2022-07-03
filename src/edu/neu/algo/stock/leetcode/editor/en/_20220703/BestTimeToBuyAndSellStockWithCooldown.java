package edu.neu.algo.stock.leetcode.editor.en._20220703;

import edu.neu.util.InputUtil;

public class BestTimeToBuyAndSellStockWithCooldown {
  // 309
  // You are given an array prices where prices[i] is the price of a given stock
  // on the iᵗʰ day.
  //
  // Find the maximum profit you can achieve. You may complete as many
  // transactions as you like (i.e., buy one and sell one share of the stock multiple times)
  // with the following restrictions:
  //
  //
  // After you sell your stock, you cannot buy stock on the next day (i.e.,
  // cooldown one day).
  //
  //
  // Note: You may not engage in multiple transactions simultaneously (i.e., you
  // must sell the stock before you buy again).
  //
  //
  // Example 1:
  //
  //
  // Input: prices = [1,2,3,0,2]
  // Output: 3
  // Explanation: transactions = [buy, sell, cooldown, buy, sell]
  //
  //
  // Example 2:
  //
  //
  // Input: prices = [1]
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= prices.length <= 5000
  // 0 <= prices[i] <= 1000
  //
  // Related Topics Array Dynamic Programming 👍 6037 👎 213

  public static void main(String[] args) {
    Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    String[] data = """
          [1,2,3,0,2]
      [1]
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
      if (prices == null || prices.length < 2) {
        return 0;
      }
      int[][] dp = new int[prices.length][2];

      // bad case
      dp[0][0] = 0;
      dp[0][1] = -prices[0];
      dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
      dp[1][1] = Math.max(dp[0][1], -prices[1]);

      for (int i = 2; i < prices.length; i++) {
        // dp公式
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
      }

      return dp[prices.length - 1][0];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
