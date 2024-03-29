package edu.neu.algo.dp.leetcode.editor.en._20220701;

import edu.neu.util.InputUtil;

public class HouseRobberII {
  // 213
  // You are a professional robber planning to rob houses along a street. Each
  // house has a certain amount of money stashed. All houses at this place are arranged
  // in a circle. That means the first house is the neighbor of the last one.
  // Meanwhile, adjacent houses have a security system connected, and it will automatically
  // contact the police if two adjacent houses were broken into on the same night.
  //
  // Given an integer array nums representing the amount of money of each house,
  // return the maximum amount of money you can rob tonight without alerting the
  // police.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [2,3,2]
  // Output: 3
  // Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money =
  // 2), because they are adjacent houses.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3,1]
  // Output: 4
  // Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
  // Total amount you can rob = 1 + 3 = 4.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [1,2,3]
  // Output: 3
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 100
  // 0 <= nums[i] <= 1000
  //
  // Related Topics Array Dynamic Programming 👍 5954 👎 96

  public static void main(String[] args) {
    Solution solution = new HouseRobberII().new Solution();
    String[] data = """
      [1]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.rob((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int rob(int[] nums) {
      int n = nums.length;
      if (n == 1) {
        return nums[0];
      }
      if (n == 2) {
        return Math.max(nums[0], nums[1]);
      }
      int[] nums2 = new int[n];
      System.arraycopy(nums, 1, nums2, 0, n - 1);
      nums[n - 1] = 0;
      return Math.max(dp(nums), dp(nums2));
    }

    public int dp(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[1], nums[0]);
      for (int i = 2; i < dp.length; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }
      return Math.max(dp[n - 2], dp[n - 1]);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
