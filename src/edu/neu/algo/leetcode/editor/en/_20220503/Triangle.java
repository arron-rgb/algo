package edu.neu.algo.leetcode.editor.en._20220503;

import java.util.List;

public class Triangle {

  // Given a triangle array, return the minimum path sum from top to bottom.
  //
  // For each step, you may move to an adjacent number of the row below. More
  // formally, if you are on index i on the current row, you may move to either index i
  // or index i + 1 on the next row.
  //
  //
  // Example 1:
  //
  //
  // Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
  // Output: 11
  // Explanation: The triangle looks like:
  // 2
  // 3 4
  // 6 5 7
  // 4 1 8 3
  // The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined
  // above).
  //
  //
  // Example 2:
  //
  //
  // Input: triangle = [[-10]]
  // Output: -10
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= triangle.length <= 200
  // triangle[0].length == 1
  // triangle[i].length == triangle[i - 1].length + 1
  // -10⁴ <= triangle[i][j] <= 10⁴
  //
  //
  //
  // Follow up: Could you do this using only O(n) extra space, where n is the
  // total number of rows in the triangle? Related Topics Array Dynamic Programming 👍 484
  // 8 👎 380

  public static void main(String[] args) {
    Solution solution = new Triangle().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      int[][] dp = new int[n][n];
      dp[0][0] = triangle.get(0).get(0);

      for (int i = 1; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
          int val = triangle.get(i).get(j);
          dp[i][j] = Integer.MAX_VALUE;
          if (j != 0) {
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + val);
          }
          if (j != i) {
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + val);
          }
        }
      }
      int min = Integer.MAX_VALUE;
      for (int i : dp[n - 1]) {
        min = Math.min(min, i);
      }
      return min;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
