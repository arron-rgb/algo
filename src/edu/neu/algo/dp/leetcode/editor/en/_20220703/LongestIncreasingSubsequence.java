package edu.neu.algo.dp.leetcode.editor.en._20220703;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class LongestIncreasingSubsequence {
  // 300
  // Given an integer array nums, return the length of the longest strictly
  // increasing subsequence.
  //
  // A subsequence is a sequence that can be derived from an array by deleting
  // some or no elements without changing the order of the remaining elements. For
  // example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [10,9,2,5,3,7,101,18]
  // Output: 4
  // Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
  // length is 4.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [0,1,0,3,2,3]
  // Output: 4
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [7,7,7,7,7,7,7]
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 2500
  // -10⁴ <= nums[i] <= 10⁴
  //
  //
  //
  // Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
  // complexity?
  // Related Topics Array Binary Search Dynamic Programming 👍 12754 👎 243

  public static void main(String[] args) {
    Solution solution = new LongestIncreasingSubsequence().new Solution();
    String[] data = """
          [10,9,2,5,3,7,101,18]
      [0,1,0,3,2,3]
      [1,3,6,7,9,4,10,5,6]
      [7,7,7,7,7,7,7]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.lengthOfLIS((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int lengthOfLIS(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      Arrays.fill(dp, 1);
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (nums[j] > nums[i]) {
            dp[j] = Math.max(dp[i] + 1, dp[j]);
          }
        }
      }
      return Arrays.stream(dp).max().getAsInt();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
