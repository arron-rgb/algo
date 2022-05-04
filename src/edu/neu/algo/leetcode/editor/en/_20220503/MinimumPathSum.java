package edu.neu.algo.leetcode.editor.en._20220503;

public class MinimumPathSum {

  // Given a m x n grid filled with non-negative numbers, find a path from top
  // left to bottom right, which minimizes the sum of all numbers along its path.
  //
  // Note: You can only move either down or right at any point in time.
  //
  //
  // Example 1:
  //
  //
  // Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
  // Output: 7
  // Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
  //
  //
  // Example 2:
  //
  //
  // Input: grid = [[1,2,3],[4,5,6]]
  // Output: 12
  //
  //
  //
  // Constraints:
  //
  //
  // m == grid.length
  // n == grid[i].length
  // 1 <= m, n <= 200
  // 0 <= grid[i][j] <= 100
  //
  // Related Topics Array Dynamic Programming Matrix 👍 7230 👎 98

  public static void main(String[] args) {
    Solution solution = new MinimumPathSum().new Solution();
    int i = solution.minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    System.out.println(i);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minPathSum(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[][] dp = new int[m][n];
      dp[0][0] = grid[0][0];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0 && j == 0) {
            continue;
          }
          int top = i >= 1 ? dp[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
          int left = j >= 1 ? dp[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
          dp[i][j] = Math.min(top, left);
        }
      }
      return dp[m - 1][n - 1];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
