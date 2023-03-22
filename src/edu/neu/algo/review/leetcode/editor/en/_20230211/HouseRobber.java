package edu.neu.algo.review.leetcode.editor.en._20230211;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class HouseRobber {
  // 198
  // You are a professional robber planning to rob houses along a street. Each
  // house has a certain amount of money stashed, the only constraint stopping you from
  // robbing each of them is that adjacent houses have security systems connected and
  // it will automatically contact the police if two adjacent houses were broken
  // into on the same night.
  //
  // Given an integer array nums representing the amount of money of each house,
  // return the maximum amount of money you can rob tonight without alerting the
  // police.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3,1]
  // Output: 4
  // Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
  // Total amount you can rob = 1 + 3 = 4.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [2,7,9,3,1]
  // Output: 12
  // Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
  // (money = 1).
  // Total amount you can rob = 2 + 9 + 1 = 12.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 100
  // 0 <= nums[i] <= 400
  //
  //
  // Related Topics Array Dynamic Programming 👍 16824 👎 328

  public static void main(String[] args) {
    Solution solution = new HouseRobber().new Solution();
    String[] data = """
                  [1,2,3,1]
      [2,7,9,3,1]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.rob((int[])params[i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int rob(int[] nums) {
      // 当前操作: 第i个房子选还是不选
      // 子问题: 前i-1个房子选还是不选
      // 不选: 前i-1的max 选: 前i-2的max+当前

      int n = nums.length;
      if (n == 1) {
        return nums[0];
      }
      if (n == 2) {
        return Math.max(nums[0], nums[1]);
      }
      // 迭代
      // 自底向上 指递归树 自底向上
      int[] dp = new int[n + 1];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[0], nums[1]);
      // 为什么要用dp?
      // 子问题: 前i-1个房子选还是不选
      // dp[i] 表示 i个房子的最优解
      for (int i = 2; i < n; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }
      return dp[n - 1];
      // 自顶向下 指 递归树 自顶向下
    }

    int[] cache;

    // public int rob(int[] nums) {
    // // 当前操作: 第i个房子选还是不选
    // cache = new int[105];
    // Arrays.fill(cache, -1);
    // // 子问题: 前i-1个房子选还是不选
    // // 不选: 前i-1的max 选: 前i-2的max+当前
    // return dfs(nums, nums.length - 1);
    // }

    int dfs(int[] nums, int i) {
      if (cache[i] != -1) {
        return cache[i];
      }
      if (i == 0) {
        cache[i] = nums[0];
        return cache[i];
      }
      if (i == 1) {
        cache[i] = Math.max(nums[0], nums[1]);
        return cache[i];
      }
      cache[i] = Math.max(dfs(nums, i - 1), dfs(nums, i - 2) + nums[i]);
      return cache[i];
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
