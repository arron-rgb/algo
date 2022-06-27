package edu.neu.algo.dp.leetcode.editor.en._20220627;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class CombinationSumIV {
  // 377
  // Given an array of distinct integers nums and a target integer target, return
  // the number of possible combinations that add up to target.
  //
  // The test cases are generated so that the answer can fit in a 32-bit integer.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3], target = 4
  // Output: 7
  // Explanation:
  // The possible combination ways are:
  // (1, 1, 1, 1)
  // (1, 1, 2)
  // (1, 2, 1)
  // (1, 3)
  // (2, 1, 1)
  // (2, 2)
  // (3, 1)
  // Note that different sequences are counted as different combinations.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [9], target = 3
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 200
  // 1 <= nums[i] <= 1000
  // All the elements of nums are unique.
  // 1 <= target <= 1000
  //
  //
  //
  // Follow up: What if negative numbers are allowed in the given array? How does
  // it change the problem? What limitation we need to add to the question to allow
  // negative numbers?
  // Related Topics Array Dynamic Programming 👍 3597 👎 407

  public static void main(String[] args) {
    Solution solution = new CombinationSumIV().new Solution();
    String[] data = """
          [1,2,3]
      4
      [9]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.combinationSum4((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int combinationSum4(int[] coins, int amount) {
      // 排列
      int[] dp = new int[amount + 1];
      dp[0] = 1;
      for (int i = 1; i < dp.length; i++) {
        // 每轮更新几种方法能到i
        for (int coin : coins) {
          if (i - coin >= 0) {
            dp[i] += dp[i - coin];
          }
        }
//        System.out.println(Arrays.toString(dp));
      }
      return dp[amount];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
