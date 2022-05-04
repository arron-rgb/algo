package edu.neu.algo.leetcode.editor.en._20220503;

import java.util.Arrays;

public class CoinChange {

  // You are given an integer array coins representing coins of different
  // denominations and an integer amount representing a total amount of money.
  //
  // Return the fewest number of coins that you need to make up that amount. If
  // that amount of money cannot be made up by any combination of the coins, return -1.
  //
  //
  // You may assume that you have an infinite number of each kind of coin.
  //
  //
  // Example 1:
  //
  //
  // Input: coins = [1,2,5], amount = 11
  // Output: 3
  // Explanation: 11 = 5 + 5 + 1
  //
  //
  // Example 2:
  //
  //
  // Input: coins = [2], amount = 3
  // Output: -1
  //
  //
  // Example 3:
  //
  //
  // Input: coins = [1], amount = 0
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= coins.length <= 12
  // 1 <= coins[i] <= 2³¹ - 1
  // 0 <= amount <= 10⁴
  //
  // Related Topics Array Dynamic Programming Breadth-First Search 👍 10991 👎 266
  //

  public static void main(String[] args) {
    Solution solution = new CoinChange().new Solution();
    solution.coinChange(new int[] {2147483647}, 2);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, amount + 1);
      dp[0] = 0;
      for (int i = 0; i < dp.length; i++) {
        for (int coin : coins) {
          if (i - coin >= 0) {
            dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
          }
        }
      }
      return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
