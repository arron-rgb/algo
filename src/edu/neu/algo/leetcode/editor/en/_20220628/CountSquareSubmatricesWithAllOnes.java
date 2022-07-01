package edu.neu.algo.leetcode.editor.en._20220628;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class CountSquareSubmatricesWithAllOnes {
  // 1277
  // Given a m * n matrix of ones and zeros, return how many square submatrices
  // have all ones.
  //
  //
  // Example 1:
  //
  //
  // Input: matrix =
  // [
  //   [0,1,1,1],
  //   [1,1,1,1],
  //   [0,1,1,1]
  // ]
  // Output: 15
  // Explanation:
  // There are 10 squares of side 1.
  // There are 4 squares of side 2.
  // There is 1 square of side 3.
  // Total number of squares = 10 + 4 + 1 = 15.
  //
  //
  // Example 2:
  //
  //
  // Input: matrix =
  // [
  // [1,0,1],
  // [1,1,0],
  // [1,1,0]
  // ]
  // Output: 7
  // Explanation:
  // There are 6 squares of side 1.
  // There is 1 square of side 2.
  // Total number of squares = 6 + 1 = 7.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= arr.length <= 300
  // 1 <= arr[0].length <= 300
  // 0 <= arr[i][j] <= 1
  //
  // Related Topics Array Dynamic Programming Matrix 👍 3457 👎 61

  public static void main(String[] args) {
    Solution solution = new CountSquareSubmatricesWithAllOnes().new Solution();
    String[] data = """
          [[0,1,1,1],[1,1,1,1],[0,1,1,1]]
      [[1,0,1],[1,1,0],[1,1,0]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.countSquares((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int countSquares(int[][] matrix) {
      int res = 0;
      int m = matrix.length;
      int n = matrix[0].length;
      int[][] dp = new int[m + 1][n + 1];
      for (int i = 1; i < dp.length; i++) {
        for (int j = 1; j < dp[0].length; j++) {
          if (matrix[i - 1][j - 1] != 0) {
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            res += dp[i][j];
          }
        }
      }
      System.out.println(Arrays.deepToString(dp));
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
