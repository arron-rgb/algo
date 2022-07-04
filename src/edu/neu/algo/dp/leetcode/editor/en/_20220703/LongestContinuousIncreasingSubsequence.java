package edu.neu.algo.dp.leetcode.editor.en._20220703;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class LongestContinuousIncreasingSubsequence {
  // 674
  // Given an unsorted array of integers nums, return the length of the longest
  // continuous increasing subsequence (i.e. subarray). The subsequence must be
  // strictly increasing.
  //
  // A continuous increasing subsequence is defined by two indices l and r (l < r)
  // such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each
  // l <= i < r, nums[i] < nums[i + 1].
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,3,5,4,7]
  // Output: 3
  // Explanation: The longest continuous increasing subsequence is [1,3,5] with
  // length 3.
  // Even though [1,3,5,7] is an increasing subsequence, it is not continuous as
  // elements 5 and 7 are separated by element
  // 4.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [2,2,2,2,2]
  // Output: 1
  // Explanation: The longest continuous increasing subsequence is [2] with length
  // 1. Note that it must be strictly
  // increasing.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // -10⁹ <= nums[i] <= 10⁹
  //
  // Related Topics Array 👍 1750 👎 166

  public static void main(String[] args) {
    Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
    String[] data = """
          [1,3,5,4,7]
      [2,2,2,2,2]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findLengthOfLCIS((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findLengthOfLCIS(int[] nums) {

      int n = nums.length;
      int[] dp = new int[n];
      Arrays.fill(dp, 1);
      for (int i = 0; i < n - 1; i++) {
        if (nums[i + 1] > nums[i]) {
          dp[i + 1] = Math.max(dp[i] + 1, dp[i + 1]);
        }
      }
      System.out.println(Arrays.toString(dp));
      return Arrays.stream(dp).max().getAsInt();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
