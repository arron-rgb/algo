package edu.neu.algo.review.leetcode.editor.en._20230207;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class CherryPickupII {
  // 1463
  // You are given a rows x cols matrix grid representing a field of cherries
  // where grid[i][j] represents the number of cherries that you can collect from the (i,
  // j) cell.
  //
  // You have two robots that can collect cherries for you:
  //
  //
  // Robot #1 is located at the top-left corner (0, 0), and
  // Robot #2 is located at the top-right corner (0, cols - 1).
  //
  //
  // Return the maximum number of cherries collection using both robots by
  // following the rules below:
  //
  //
  // From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (
  // i + 1, j + 1).
  // When any robot passes through a cell, It picks up all cherries, and the cell
  // becomes an empty cell.
  // When both robots stay in the same cell, only one takes the cherries.
  // Both robots cannot move outside of the grid at any moment.
  // Both robots should reach the bottom row in grid.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
  // Output: 24
  // Explanation: Path of robot #1 and #2 are described in color green and blue
  // respectively.
  // Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
  // Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
  // Total of cherries: 12 + 12 = 24.
  //
  //
  // Example 2:
  //
  //
  // Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0]
  // ,[1,0,2,3,0,0,6]]
  // Output: 28
  // Explanation: Path of robot #1 and #2 are described in color green and blue
  // respectively.
  // Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
  // Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
  // Total of cherries: 17 + 11 = 28.
  //
  //
  //
  // Constraints:
  //
  //
  // rows == grid.length
  // cols == grid[i].length
  // 2 <= rows, cols <= 70
  // 0 <= grid[i][j] <= 100
  //
  //
  // Related Topics Array Dynamic Programming Matrix 👍 2781 👎 28

  public static void main(String[] args) {
    Solution solution = new CherryPickupII().new Solution();
    String[] data = """
                  [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
      [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
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
    public int cherryPickup(int[][] grid) {
      // 到达grid[i][j]的状态有: 1. which robot arrives 2. how many steps they take
      int m = grid.length;
      int n = grid[0].length;
      int maxSteps = Math.max(m, n);
      int[][][][] dp = new int[m + 1][n + 1][2][maxSteps];
      // dp[i][j][k][l]表示第k个robot走了l步能够采到的cherries
      //
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
