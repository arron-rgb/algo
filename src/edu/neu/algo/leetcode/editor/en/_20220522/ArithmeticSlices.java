package edu.neu.algo.leetcode.editor.en._20220522;

public class ArithmeticSlices {

  // An integer array is called arithmetic if it consists of at least three
  // elements and if the difference between any two consecutive elements is the same.
  //
  //
  // For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic
  // sequences.
  //
  //
  // Given an integer array nums, return the number of arithmetic subarrays of
  // nums.
  //
  // A subarray is a contiguous subsequence of the array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3,4]
  // Output: 3
  // Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,
  // 2,3,4] itself.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1]
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 5000
  // -1000 <= nums[i] <= 1000
  //
  // Related Topics Array Dynamic Programming 👍 3908 👎 249

  public static void main(String[] args) {
    Solution solution = new ArithmeticSlices().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
      // if (nums.length < 3) {
      // return 0;
      // }
      // int n = nums.length;
      // int count = 0;
      // int diff;
      // for (int i = 0; i < n - 2; i++) {
      // diff = nums[i + 1] - nums[i];
      // for (int j = i + 2; j < n; j++) {
      // if (nums[j] - nums[j - 1] == diff) {
      // count++;
      // } else {
      // break;
      // }
      // }
      // }
      // return count;
      if (nums.length < 3) {
        return 0;
      }
      int[] dp = new int[nums.length];
      dp[0] = 0;
      dp[1] = 0;
      for (int i = 2; i < nums.length; i++) {
        if (nums[i] == 2 * nums[i - 1] - nums[i - 2]) {
          dp[i] = dp[i - 1] + 1;
        } else {
          dp[i] = 0;
        }
      }
      int ans = 0;
      for (int item : dp) {
        ans = ans + item;
      }
      return ans;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
