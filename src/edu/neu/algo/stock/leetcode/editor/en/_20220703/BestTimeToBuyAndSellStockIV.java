package edu.neu.algo.stock.leetcode.editor.en._20220703;

import java.util.*;
import edu.neu.util.InputUtil;

public class BestTimeToBuyAndSellStockIV{
  // 188
  //You are given an integer array prices where prices[i] is the price of a given
//stock on the iᵗʰ day, and an integer k.
//
// Find the maximum profit you can achieve. You may complete at most k
//transactions.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you
//must sell the stock before you buy again).
//
//
// Example 1:
//
//
//Input: k = 2, prices = [2,4,1]
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit =
//4-2 = 2.
//
//
// Example 2:
//
//
//Input: k = 2, prices = [3,2,6,5,0,3]
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit =
//6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3
//-0 = 3.
//
//
//
// Constraints:
//
//
// 0 <= k <= 100
// 0 <= prices.length <= 1000
// 0 <= prices[i] <= 1000
//
// Related Topics Array Dynamic Programming 👍 4183 👎 156

  public static void main(String[] args) {
    Solution solution = new BestTimeToBuyAndSellStockIV().new Solution();
    String[] data = """
    2
[2,4,1]
2
[3,2,6,5,0,3]
    """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
            int q =
       solution.maxProfit(
            (int)params[1 -1 + i * paramTypes.length]
       ,
                  (int[])params[2 -1 + i * paramTypes.length]
                  );
            System.out.println(q);
          }
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
      if (prices.length == 0) return 0;

      // [天数][交易次数][是否持有股票]
      int len = prices.length;
      int[][][] dp = new int[len][k + 1][2];

      // dp数组初始化
      // 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
      for (int i = 0; i <= k; i++) {
        dp[0][i][1] = -prices[0];
      }

      for (int i = 1; i < len; i++) {
        for (int j = 1; j <= k; j++) {
          // dp方程, 0表示不持有/卖出, 1表示持有/买入
          dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
          dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
        }
      }
      return dp[len - 1][k][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
