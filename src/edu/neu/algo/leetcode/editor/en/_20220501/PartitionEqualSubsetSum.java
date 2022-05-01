package edu.neu.algo.leetcode.editor.en._20220501;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

  // Given a non-empty array nums containing only positive integers, find if the
  // array can be partitioned into two subsets such that the sum of elements in both
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
  // Related Topics Array Dynamic Programming 👍 7330 👎 116

  public static void main(String[] args) {
    Solution solution = new PartitionEqualSubsetSum().new Solution();
    solution.canPartition(new int[] {1, 5, 5, 11});
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canPartition(int[] nums) {
      int sum = Arrays.stream(nums).sum();
      int max = Arrays.stream(nums).max().getAsInt();
      if ((sum & 1) == 1 || max > sum / 2) {
        return false;
      }
      var target = sum / 2;
      boolean[] dp = new boolean[target + 1];
      dp[0] = true;
      for (int num : nums) {
        for (int j = target; j >= num; j--) {
          dp[j] = dp[j] | dp[j - num];
        }
        System.out.println(Arrays.toString(dp));
      }
      return dp[target];
    }

    boolean dfs(int[] nums, int target, boolean[] visited, int i) {
      if (i == nums.length) {
        return false;
      }
      if (target == 0) {
        return true;
      }

      visited[i] = true;
      boolean tmp = dfs(nums, target - nums[i], visited, i + 1);
      visited[i] = false;
      return tmp || dfs(nums, target, visited, i + 1);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
