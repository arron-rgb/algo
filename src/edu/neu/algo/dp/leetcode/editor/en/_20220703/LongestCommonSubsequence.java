package edu.neu.algo.dp.leetcode.editor.en._20220703;

import edu.neu.util.InputUtil;

public class LongestCommonSubsequence {
  // 1143
  // Given two strings text1 and text2, return the length of their longest common
  // subsequence. If there is no common subsequence, return 0.
  //
  // A subsequence of a string is a new string generated from the original string
  // with some characters (can be none) deleted without changing the relative order
  // of the remaining characters.
  //
  //
  // For example, "ace" is a subsequence of "abcde".
  //
  //
  // A common subsequence of two strings is a subsequence that is common to both
  // strings.
  //
  //
  // Example 1:
  //
  //
  // Input: text1 = "abcde", text2 = "ace"
  // Output: 3
  // Explanation: The longest common subsequence is "ace" and its length is 3.
  //
  //
  // Example 2:
  //
  //
  // Input: text1 = "abc", text2 = "abc"
  // Output: 3
  // Explanation: The longest common subsequence is "abc" and its length is 3.
  //
  //
  // Example 3:
  //
  //
  // Input: text1 = "abc", text2 = "def"
  // Output: 0
  // Explanation: There is no such common subsequence, so the result is 0.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= text1.length, text2.length <= 1000
  // text1 and text2 consist of only lowercase English characters.
  //
  // Related Topics String Dynamic Programming 👍 7181 👎 77

  public static void main(String[] args) {
    Solution solution = new LongestCommonSubsequence().new Solution();
    String[] data = """
          "abcde"
      "ace"
      "abc"
      "abc"
      "abc"
      "def"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.longestCommonSubsequence((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      // if (text1.length() > text2.length()) {
      // return longestCommonSubsequence(text2, text1);
      // }
      int m = text1.length();
      int n = text2.length();
      // dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]

      int[][] dp = new int[m + 1][n + 1];
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          } else {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          }
        }
      }
      // System.out.println(Arrays.deepToString(dp));
      return dp[m][n];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
