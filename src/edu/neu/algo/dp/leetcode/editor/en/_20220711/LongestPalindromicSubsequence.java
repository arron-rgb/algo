package edu.neu.algo.dp.leetcode.editor.en._20220711;

import java.util.*;
import edu.neu.util.InputUtil;

public class LongestPalindromicSubsequence {
  // 516
  // Given a string s, find the longest palindromic subsequence's length in s.
  //
  // A subsequence is a sequence that can be derived from another sequence by
  // deleting some or no elements without changing the order of the remaining elements.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "bbbab"
  // Output: 4
  // Explanation: One possible longest palindromic subsequence is "bbbb".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "cbbd"
  // Output: 2
  // Explanation: One possible longest palindromic subsequence is "bb".
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 1000
  // s consists only of lowercase English letters.
  //
  // Related Topics String Dynamic Programming 👍 5636 👎 253

  public static void main(String[] args) {
    Solution solution = new LongestPalindromicSubsequence().new Solution();
    String[] data = """
          "bbbab"
      "cbbd"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.longestPalindromeSubseq((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestPalindromeSubseq(String s) {
      int n = s.length();
      char[] cs = s.toCharArray();
      int[][] dp = new int[n][n];
      for (int len = 1; len <= n; len++) {
        for (int l = 0; l + len - 1 < n; l++) {
          int r = l + len - 1;
          if (len == 1) {
            dp[l][r] = 1;
          } else if (len == 2) {
            dp[l][r] = cs[l] == cs[r] ? 2 : 1;
          } else {
            dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
            if (cs[l] == cs[r]) {
              dp[l][r] = Math.max(dp[l][r], dp[l + 1][r - 1] + 2);
            } else {
              dp[l][r] = Math.max(dp[l][r], dp[l + 1][r - 1]);
            }
          }
        }
      }
      return dp[0][n - 1];
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
