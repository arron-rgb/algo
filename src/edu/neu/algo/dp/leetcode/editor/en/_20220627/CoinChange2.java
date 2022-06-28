package edu.neu.algo.dp.leetcode.editor.en._20220627;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class CoinChange2 {
  // 518
  // You are given an integer array coins representing coins of different
  // denominations and an integer amount representing a total amount of money.
  //
  // Return the number of combinations that make up that amount. If that amount
  // of money cannot be made up by any combination of the coins, return 0.
  //
  // You may assume that you have an infinite number of each kind of coin.
  //
  // The answer is guaranteed to fit into a signed 32-bit integer.
  //
  //
  // Example 1:
  //
  //
  // Input: amount = 5, coins = [1,2,5]
  // Output: 4
  // Explanation: there are four ways to make up the amount:
  // 5=5
  // 5=2+2+1
  // 5=2+1+1+1
  // 5=1+1+1+1+1
  //
  //
  // Example 2:
  //
  //
  // Input: amount = 3, coins = [2]
  // Output: 0
  // Explanation: the amount of 3 cannot be made up just with coins of 2.
  //
  //
  // Example 3:
  //
  //
  // Input: amount = 10, coins = [10]
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= coins.length <= 300
  // 1 <= coins[i] <= 5000
  // All the values of coins are unique.
  // 0 <= amount <= 5000
  //
  // Related Topics Array Dynamic Programming 👍 5422 👎 107

  public static void main(String[] args) {
    Solution solution = new CoinChange2().new Solution();
    String[] data = """
          4
      [1,2,3]
      3
      [2]
      10
      [10]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.change((int)params[1 - 1 + i * paramTypes.length], (int[])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)

  class Solution {
    public int change(int amount, int[] coins) {
      // todo 01背包 nums 外循环 target内循环 且倒序遍历
      //
      int[] dp = new int[amount + 1];
      // dp[i] 表示 有几种方法能够组成i
      // dp[i] = dp[i-coin]+1
      // coin数量不限
      dp[0] = 1;
      for (int coin : coins) {
        // 组合
        // 用当前已有的coin组成某个数
        // 每轮加一个
        // 数量无限
        for (int i = coin; i < dp.length; i++) {
          dp[i] += dp[i - coin];
        }
        System.out.println(Arrays.toString(dp));
      }
      return dp[amount];
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
