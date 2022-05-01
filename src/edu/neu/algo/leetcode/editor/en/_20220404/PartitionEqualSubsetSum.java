package edu.neu.algo.leetcode.editor.en._20220404;

public class PartitionEqualSubsetSum {

  //// Given a non-empty array nums containing only positive integers, find if the
  //
  //// array can be partitioned into two subsets such that the sum of elements in
  // both
  //// subsets is equal.
  ////
  ////
  //// Example 1:
  ////
  ////
  //// Input: nums = [1,5,11,5]
  //// Output: true
  //// Explanation: The array can be partitioned as [1, 5, 5] and [11].
  ////
  ////
  //// Example 2:
  ////
  ////
  //// Input: nums = [1,2,3,5]
  //// Output: false
  //// Explanation: The array cannot be partitioned into equal sum subsets.
  ////
  ////
  ////
  //// Constraints:
  ////
  ////
  //// 1 <= nums.length <= 200
  //// 1 <= nums[i] <= 100
  ////
  //// Related Topics Array Dynamic Programming 👍 7179 👎 114
  //

  public static void main(String[] args) {

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canPartition(int[] nums) {
      int n = nums.length;
      int sum = 0;
      int max = -1;
      for (int num : nums) {
        sum += num;
        max = Math.max(max, num);
      }
      if ((sum & 1) == 1) {
        return false;
      }
      int target = sum / 2;
      if (target < max) {
        return false;
      }
      boolean[][] dp = new boolean[n][target + 1];
      for (int i = 0; i < n; i++) {
        dp[i][0] = true;
      }
      dp[0][nums[0]] = true;
      for (int i = 1; i < n; i++) {
        int num = nums[i];
        for (int j = 1; j <= target; j++) {
          if (j >= num) {
            dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }
      }
      return dp[n - 1][target];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
