package edu.neu.algo.dp.leetcode.editor.en._20220627;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

  // Given a non-empty array nums containing only positive integers, find if the

  // array can be partitioned into two subsets such that the sum of elements in
  // both
  // subsets is equal.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,5,11,5]
  // Output: true
  // Explanation: The array can be partitioned as [1, 5, 5] and [11].
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3,5]
  // Output: false
  // Explanation: The array cannot be partitioned into equal sum subsets.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 200
  // 1 <= nums[i] <= 100
  //
  // Related Topics Array Dynamic Programming 👍 7854 👎 125

  public static void main(String[] args) {
    // Solution solution = new PartitionEqualSubsetSum().new Solution();
    // String[] data = """
    // [1,5,11,5]
    // [1,2,3,5]
    // """.trim().replaceAll("\n", "|").split("\\|");
    // String[] paramTypes = InputUtil.param("[int[]]");
    // Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // boolean q = solution.canPartition((int[])params[1 - 1 + i * paramTypes.length]);
    // System.out.println(q);
    // }
    int[] weight = {1, 3, 4};
    int[] value = {15, 20, 30};
    int size = 4;
    int bag = bag(weight, value, size);
    System.out.println(bag);
  }

  public static int bag(int[] weights, int[] values, int size) {
    int n = weights.length;
    // 定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
    int[][] dp = new int[n + 1][size + 1];
    // 初始化：背包容量为0时，能获得的价值都为0
    // for (int i = 0; i <= n; i++) {
    // dp[i][0] = value0;
    // }
    // 遍历顺序：先遍历物品，再遍历背包容量
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= size; j++) {
        if (j < weights[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
        }
      }
    }
    System.out.println(Arrays.deepToString(dp));
    return dp[n - 1][size];
  }

  public static int testWeightBagProblem(int[] weights, int[] values, int size) {
    int n = weights.length;
    // 定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
    int[] dp = new int[size + 1];
    // 遍历顺序：先遍历物品，再遍历背包容量
    for (int i = 0; i < n; i++) {
      // 倒序遍历是为了保证物品i只被放入一次！。但如果一旦正序遍历了，那么物品0就会被重复加入多次！
      for (int j = size; j >= weights[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
      }
    }
    // 打印dp数组
    System.out.println(Arrays.toString(dp));
    return dp[size];
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canPartition(int[] nums) {
      int sum = Arrays.stream(nums).sum();
      if ((sum & 1) == 1) {
        return false;
      }
      sum /= 2;
      boolean[] dp = new boolean[sum + 1];
      dp[0] = true;
      for (int num : nums) {
        for (int i = sum; i >= num; i--) {
          // // i-num的范围是 从i-num都能到达i
          dp[i] = dp[i] || dp[i - num];
        }
      }
      return dp[sum];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
