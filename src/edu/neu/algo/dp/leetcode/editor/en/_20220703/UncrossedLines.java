package edu.neu.algo.dp.leetcode.editor.en._20220703;

import edu.neu.util.InputUtil;

public class UncrossedLines {
  // 1035
  // You are given two integer arrays nums1 and nums2. We write the integers of
  // nums1 and nums2 (in the order they are given) on two separate horizontal lines.
  //
  // We may draw connecting lines: a straight line connecting two numbers nums1[i]
  // and nums2[j] such that:
  //
  //
  // nums1[i] == nums2[j], and
  // the line we draw does not intersect any other connecting (non-horizontal)
  // line.
  //
  //
  // Note that a connecting line cannot intersect even at the endpoints (i.e.,
  // each number can only belong to one connecting line).
  //
  // Return the maximum number of connecting lines we can draw in this way.
  //
  //
  // Example 1:
  //
  //
  // Input: nums1 = [1,4,2], nums2 = [1,2,4]
  // Output: 2
  // Explanation: We can draw 2 uncrossed lines as in the diagram.
  // We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[
  // 2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
  //
  //
  // Example 2:
  //
  //
  // Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
  // Output: 3
  //
  //
  // Example 3:
  //
  //
  // Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
  // Output: 2
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums1.length, nums2.length <= 500
  // 1 <= nums1[i], nums2[j] <= 2000
  //
  // Related Topics Array Dynamic Programming 👍 1728 👎 28

  public static void main(String[] args) {
    Solution solution = new UncrossedLines().new Solution();
    String[] data = """
          [1,4,2]
      [1,2,4]
      [2,5,1,2,5]
      [10,5,2,1,5,2]
      [1,3,7,1,7,5]
      [1,9,2,5,1]
      [3]
      [3,3,2]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxUncrossedLines((int[])params[1 - 1 + i * paramTypes.length],
        (int[])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
      // dp[i][j]: 长度为i, 长度为j 能画几条线
      // 什么时候能画
      // nums[i]==nums[j]的时候, 且画完不会交叉
      // 只要线往后画就不会交叉
      int m = nums1.length;
      int n = nums2.length;
      int[][] dp = new int[m + 1][n + 1];
      // int res = Integer.MIN_VALUE;
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (nums1[i - 1] == nums2[j - 1]) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          }
          // if (dp[i][j] > res) {
          // res = dp[i][j];
          // }
        }
      }
      // System.out.println(Arrays.deepToString(dp));
      return dp[m][n];
      // return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
