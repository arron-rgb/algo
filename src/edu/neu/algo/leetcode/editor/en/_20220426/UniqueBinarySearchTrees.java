package edu.neu.algo.leetcode.editor.en._20220426;

public class UniqueBinarySearchTrees {

  // Given an integer n, return the number of structurally unique BST's (binary
  // search trees) which has exactly n nodes of unique values from 1 to n.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 3
  // Output: 5
  //
  //
  // Example 2:
  //
  //
  // Input: n = 1
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 19
  //
  // Related Topics Math Dynamic Programming Tree Binary Search Tree Binary Tree ?
  // ? 7104 👎 289

  public static void main(String[] args) {
    Solution solution = new UniqueBinarySearchTrees().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numTrees(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;
      for (int i = 2; i < dp.length; i++) {
        for (int j = 1; j <= i; j++) {
          dp[i] += dp[j - 1] * dp[i - j];
        }
      }
      return dp[n];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
