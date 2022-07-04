package edu.neu.algo.dp.leetcode.editor.en._20220703;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class MaximumLengthOfRepeatedSubarray {
  // 718
  // Given two integer arrays nums1 and nums2, return the maximum length of a
  // subarray that appears in both arrays.
  //
  //
  // Example 1:
  //
  //
  // Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
  // Output: 3
  // Explanation: The repeated subarray with maximum length is [3,2,1].
  //
  //
  // Example 2:
  //
  //
  // Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
  // Output: 5
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums1.length, nums2.length <= 1000
  // 0 <= nums1[i], nums2[i] <= 100
  //
  // Related Topics Array Binary Search Dynamic Programming Sliding Window
  // Rolling Hash Hash Function 👍 4004 👎 96

  public static void main(String[] args) {
    Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
    String[] data = """
          [1,2,3,2,1]
      [3,2,1,4,7]
      [0,0,0,0,0]
      [0,0,0,0,0]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.findLength((int[])params[1 - 1 + i * paramTypes.length], (int[])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findLength(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;
      int[][] dp = new int[m + 1][n + 1];
      int res = Integer.MIN_VALUE;
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          // 以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
          if (nums1[i - 1] == nums2[j - 1]) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          }
          if (dp[i][j] > res) {
            res = dp[i][j];
          }
        }
      }
      System.out.println(Arrays.deepToString(dp));
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
