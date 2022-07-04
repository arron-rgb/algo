package edu.neu.algo.dp.leetcode.editor.en._20220703;

import edu.neu.util.InputUtil;

public class IsSubsequence {
  // 392
  // Given two strings s and t, return true if s is a subsequence of t, or false
  // otherwise.
  //
  // A subsequence of a string is a new string that is formed from the original
  // string by deleting some (can be none) of the characters without disturbing the
  // relative positions of the remaining characters. (i.e., "ace" is a subsequence of
  // "abcde" while "aec" is not).
  //
  //
  // Example 1:
  // Input: s = "abc", t = "ahbgdc"
  // Output: true
  // Example 2:
  // Input: s = "axc", t = "ahbgdc"
  // Output: false
  //
  //
  // Constraints:
  //
  //
  // 0 <= s.length <= 100
  // 0 <= t.length <= 10⁴
  // s and t consist only of lowercase English letters.
  //
  //
  //
  // Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >
  // = 10⁹, and you want to check one by one to see if t has its subsequence. In
  // this scenario, how would you change your code? Related Topics Two Pointers String
  // Dynamic Programming 👍 5036 👎 302

  public static void main(String[] args) {
    Solution solution = new IsSubsequence().new Solution();
    String[] data = """
          "abc"
      "ahbgdc"
      "axc"
      "ahbgdc"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isSubsequence((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isSubsequence(String s, String t) {
      int m = s.length();
      int n = t.length();
      int[][] dp = new int[m + 1][n + 1];
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            // todo
            dp[i][j] = dp[i][j - 1];
          }
        }
      }
      // System.out.println(Arrays.deepToString(dp));
      return dp[m][n] == m;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
