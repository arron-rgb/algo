package edu.neu.algo.dp.leetcode.editor.en._20220627;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class CoinChange {
  // 322
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
  // Related Topics Array Dynamic Programming Breadth-First Search 👍 12408 👎 282
  //

  public static void main(String[] args) {
    Solution solution = new CoinChange().new Solution();
    String[] data = """
          [1,2,5]
      11
      [2]
      3
      [1]
      0
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.coinChange((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      // dp[i] 表示 i最少能用几个硬币表示
      // dp[i] = Math.min(dp[i], dp[i-coin]+1)
      Arrays.fill(dp, amount + 1);
      dp[0] = 0;
      for (int coin : coins) {
        for (int i = coin; i < dp.length; i++) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
      return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
