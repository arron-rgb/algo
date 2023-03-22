package edu.neu.algo.review.leetcode.editor.en._20230207;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class CherryPickup {
  // 741
  // You are given an n x n grid representing a field of cherries, each cell is
  // one of three possible integers.
  //
  //
  // 0 means the cell is empty, so you can pass through,
  // 1 means the cell contains a cherry that you can pick up and pass through, or
  //
  // -1 means the cell contains a thorn that blocks your way.
  //
  //
  // Return the maximum number of cherries you can collect by following the rules
  // below:
  //
  //
  // Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right
  // or down through valid path cells (cells with value 0 or 1).
  // After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up
  // through valid path cells.
  // When passing through a path cell containing a cherry, you pick it up, and
  // the cell becomes an empty cell 0.
  // If there is no valid path between (0, 0) and (n - 1, n - 1), then no
  // cherries can be collected.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
  // Output: 5
  // Explanation: The player started at (0, 0) and went down, down, right right to
  // reach (2, 2).
  // 4 cherries were picked up during this single trip, and the matrix becomes [[0,
  // 1,-1],[0,0,-1],[0,0,0]].
  // Then, the player went left, up, up, left to return home, picking up one more
  // cherry.
  // The total number of cherries picked up is 5, and this is the maximum possible.
  //
  //
  //
  // Example 2:
  //
  //
  // Input: grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // n == grid.length
  // n == grid[i].length
  // 1 <= n <= 50
  // grid[i][j] is -1, 0, or 1.
  // grid[0][0] != -1
  // grid[n - 1][n - 1] != -1
  //
  //
  // Related Topics Array Dynamic Programming Matrix 👍 3463 👎 133

  public static void main(String[] args) {
    Solution solution = new CherryPickup().new Solution();
    String[] data = """
                  [[0,1,-1],[1,0,-1],[1,1,1]]
      [[1,1,-1],[1,-1,1],[-1,1,1]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.cherryPickup((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[][][] memo;
    int[][] grid;
    int N;

    public int cherryPickup(int[][] grid) {
      this.grid = grid;
      N = grid.length;
      memo = new int[N][N][N];
      for (int[][] layer : memo)
        for (int[] row : layer)
          Arrays.fill(row, Integer.MIN_VALUE);
      return Math.max(0, dp(0, 0, 0));
    }

    public int dp(int r1, int c1, int c2) {
      int r2 = r1 + c1 - c2;
      // [r2, c2] [r1, c1]
      // r2 + c2 = r1 + c1 保持两个点steps一致？
      if (N == r1 || N == r2 || N == c1 || N == c2 || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
        return -999999;
      } else if (r1 == N - 1 && c1 == N - 1) {
        return grid[r1][c1];
      } else if (memo[r1][c1][c2] != Integer.MIN_VALUE) {
        return memo[r1][c1][c2];
      } else {
        int ans = grid[r1][c1];
        if (c1 != c2)
          ans += grid[r2][c2];
        ans += Math.max(Math.max(dp(r1, c1 + 1, c2 + 1), dp(r1 + 1, c1, c2 + 1)),
          Math.max(dp(r1, c1 + 1, c2), dp(r1 + 1, c1, c2)));
        memo[r1][c1][c2] = ans;
        return ans;
      }
    }
  }
  // runtime:20 ms
  // memory:52.1 MB

  // leetcode submit region end(Prohibit modification and deletion)
  // class Solution {
  // public int cherryPickup(int[][] grid) {
  // int m = grid.length;
  // int n = grid[0].length;
  // int[][][] dp = new int[m + 1][n + 1][m * n];
  // // 第三维k表示 [k-1/n][k-1%n]是否已被采集了
  // // 4-1/3=1 4-1%3
  // // 6:[1,2] 4:[1,0]
  // int res = 0;
  // for (int i = 0; i < m; i++) {
  // for (int j = 0; j < n; j++) {
  // if (grid[i][j] == -1) {
  // continue;
  // }
  // int k = (i + 1) * (j + 1);
  // dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]) + (grid[i][j] == 1 ? 1 : 0);
  // }
  // }
  // System.out.println(Arrays.deepToString(dp));
  // return res;
  // }
  // }
}
