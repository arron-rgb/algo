package edu.neu.algo.leetcode.editor.en._20220505;

public class PerfectSquares {

  // Given an integer n, return the least number of perfect square numbers that
  // sum to n.
  //
  // A perfect square is an integer that is the square of an integer; in other
  // words, it is the product of some integer with itself. For example, 1, 4, 9, and 16
  // are perfect squares while 3 and 11 are not.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 12
  // Output: 3
  // Explanation: 12 = 4 + 4 + 4.
  //
  //
  // Example 2:
  //
  //
  // Input: n = 13
  // Output: 2
  // Explanation: 13 = 4 + 9.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 10⁴
  //
  // Related Topics Math Dynamic Programming Breadth-First Search 👍 6658 👎 293

  public static void main(String[] args) {
    Solution solution = new PerfectSquares().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numSquares(int n) {
      int[] dp = new int[n + 1];
      for (int i = 1; i < dp.length; i++) {
        int min = Integer.MAX_VALUE;
        for (int j = 1; j * j <= i; j++) {
          min = Math.min(min, dp[i - j * j]);
        }
        dp[i] = min + 1;
      }
      return dp[n];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
