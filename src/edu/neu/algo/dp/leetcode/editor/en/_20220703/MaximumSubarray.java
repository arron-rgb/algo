package edu.neu.algo.dp.leetcode.editor.en._20220703;

import edu.neu.util.InputUtil;

public class MaximumSubarray {
  // 53
  // Given an integer array nums, find the contiguous subarray (containing at
  // least one number) which has the largest sum and return its sum.
  //
  // A subarray is a contiguous part of an array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
  // Output: 6
  // Explanation: [4,-1,2,1] has the largest sum = 6.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1]
  // Output: 1
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [5,4,-1,7,8]
  // Output: 23
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // -10⁴ <= nums[i] <= 10⁴
  //
  //
  //
  // Follow up: If you have figured out the O(n) solution, try coding another
  // solution using the divide and conquer approach, which is more subtle.
  // Related Topics Array Divide and Conquer Dynamic Programming 👍 22286 👎 1103

  public static void main(String[] args) {
    Solution solution = new MaximumSubarray().new Solution();
    String[] data = """
          [-2,1,-3,4,-1,2,1,-5,4]
      [1]
      [5,4,-1,7,8]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxSubArray((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxSubArray(int[] nums) {
      int n = nums.length;
      int res = nums[0];
      int[] dp = new int[n + 1];
      dp[0] = nums[0];
      for (int i = 1; i < n; i++) {
        dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        if (dp[i] > res) {
          res = dp[i];
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
