package edu.neu.algo.dp.leetcode.editor.en._20220627;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class LastStoneWeightII {
  // 1049
  // You are given an array of integers stones where stones[i] is the weight of
  // the iᵗʰ stone.
  //
  // We are playing a game with the stones. On each turn, we choose any two
  // stones and smash them together. Suppose the stones have weights x and y with x <= y.
  // The result of this smash is:
  //
  //
  // If x == y, both stones are destroyed, and
  // If x != y, the stone of weight x is destroyed, and the stone of weight y has
  // new weight y - x.
  //
  //
  // At the end of the game, there is at most one stone left.
  //
  // Return the smallest possible weight of the left stone. If there are no
  // stones left, return 0.
  //
  //
  // Example 1:
  //
  //
  // Input: stones = [2,7,4,1,8,1]
  // Output: 1
  // Explanation:
  // We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
  // we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
  // we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
  // we can combine 1 and 1 to get 0, so the array converts to [1], then that's
  // the optimal value.
  //
  //
  // Example 2:
  //
  //
  // Input: stones = [31,26,33,21,40]
  // Output: 5
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= stones.length <= 30
  // 1 <= stones[i] <= 100
  //
  // Related Topics Array Dynamic Programming 👍 2231 👎 77

  public static void main(String[] args) {
    // 1 1 2 4 7 8
    Solution solution = new LastStoneWeightII().new Solution();
    String[] data = """
          [2,7,4,1,8,1]
      [31,26,33,21,40]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.lastStoneWeightII((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // public int lastStoneWeightII(int[] stones) {
    // int sum = Arrays.stream(stones).sum();
    // int target = sum / 2;
    // int n = stones.length;
    // int[][] dp = new int[n + 1][target + 1];
    // for (int i = 1; i < dp.length; i++) {
    // int stone = stones[i - 1];
    // for (int j = 0; j <= target; j++) {
    // dp[i][j] = dp[i - 1][j];
    // if (j >= stone) {
    // dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stone] + stone);
    // }
    // }
    // }
    // System.out.println(Arrays.deepToString(dp));
    // return Math.abs(sum - dp[n][target] * 2);
    // }
    public int lastStoneWeightII(int[] stones) {
      int sum = 0;
      for (int i : stones) {
        sum += i;
      }
      System.out.println(sum);
      int target = sum >> 1;
      // 初始化dp数组
      int[] dp = new int[target + 1];
      for (int stone : stones) {
        // 采用倒序
        for (int j = target; j >= stone; j--) {
          // 两种情况，要么放，要么不放
          dp[j] = Math.max(dp[j], dp[j - stone] + stone);
        }
      }
      // dp[i]表示能够容纳i重量的背包，最多可以装多少
      // 这道题就是 最多能够装一半的容量，看看实际能够装多少
      System.out.println(Arrays.toString(dp));
      // 一堆的和是dp[target]，另一堆和就是sum - dp[target]。剩下的就是 sum-dp[target]*2
      return sum - 2 * dp[target];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public int lastStoneWeightII(int[] stones) {
    int sum = 0;
    for (int stone : stones) {
      sum += stone;
    }
    int target = sum / 2;
    int[] dp = new int[target + 1];
    for (int stone : stones) {
      for (int j = target; j >= stone; j--) {
        // dp[i]可以通过dp[i-stone]到达
        dp[j] = Math.max(dp[j], dp[j - stone] + stone);
      }
    }
    return sum - 2 * dp[target];
  }
}
