package edu.neu.algo.stock.leetcode.editor.en._20220703;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class BestTimeToBuyAndSellStockIII {
  // 123
  // You are given an array prices where prices[i] is the price of a given stock
  // on the iᵗʰ day.
  //
  // Find the maximum profit you can achieve. You may complete at most two
  // transactions.
  //
  // Note: You may not engage in multiple transactions simultaneously (i.e., you
  // must sell the stock before you buy again).
  //
  //
  // Example 1:
  //
  //
  // Input: prices = [3,3,5,0,0,3,1,4]
  // Output: 6
  // Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit =
  // 3-0 = 3.
  // Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
  //
  //
  // Example 2:
  //
  //
  // Input: prices = [1,2,3,4,5]
  // Output: 4
  // Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =
  // 5-1 = 4.
  // Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
  // are engaging multiple transactions at the same time. You must sell before buying
  // again.
  //
  //
  // Example 3:
  //
  //
  // Input: prices = [7,6,4,3,1]
  // Output: 0
  // Explanation: In this case, no transaction is done, i.e. max profit = 0.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= prices.length <= 10⁵
  // 0 <= prices[i] <= 10⁵
  //
  // Related Topics Array Dynamic Programming 👍 6175 👎 124

  public static void main(String[] args) {
    Solution solution = new BestTimeToBuyAndSellStockIII().new Solution();
    String[] data = """
          [3,3,5,0,0,3,1,4]
      [1,2,3,4,5]
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
      int len = prices.length;
      // 边界判断, 题目中 length >= 1, 所以可省去
      if (prices.length == 0) {
        return 0;
      }
      /*
       * 定义 5 种状态:
       * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
       */
      int[][] dp = new int[len][4];
      dp[0][0] = -prices[0];
      // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
      dp[0][2] = -prices[0];

      for (int i = 1; i < len; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
        dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] - prices[i]);
        dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] + prices[i]);
      }
      System.out.println(Arrays.deepToString(dp));

      return dp[len - 1][3];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
