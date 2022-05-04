package edu.neu.algo.leetcode.editor.en._20220503;

public class WildcardMatching {

  // Given an input string (s) and a pattern (p), implement wildcard pattern
  // matching with support for '?' and '*' where:
  //
  //
  // '?' Matches any single character.
  // '*' Matches any sequence of characters (including the empty sequence).
  //
  //
  // The matching should cover the entire input string (not partial).
  //
  //
  // Example 1:
  //
  //
  // Input: s = "aa", p = "a"
  // Output: false
  // Explanation: "a" does not match the entire string "aa".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "aa", p = "*"
  // Output: true
  // Explanation: '*' matches any sequence.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "cb", p = "?a"
  // Output: false
  // Explanation: '?' matches 'c', but the second letter is 'a', which does not
  // match 'b'.
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= s.length, p.length <= 2000
  // s contains only lowercase English letters.
  // p contains only lowercase English letters, '?' or '*'.
  //
  // Related Topics String Dynamic Programming Greedy Recursion 👍 4626 👎 210

  public static void main(String[] args) {
    Solution solution = new WildcardMatching().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isMatch(String s, String p) {
      int m = s.length();
      int n = p.length();

      boolean[][] f = new boolean[m + 1][n + 1];
      f[0][0] = true;
      for (int i = 0; i <= m; ++i) {
        for (int j = 1; j <= n; ++j) {
          if (p.charAt(j - 1) == '*') {
            f[i][j] = f[i][j - 2];
            if (matches(s, p, i, j - 1)) {
              f[i][j] = f[i][j] || f[i - 1][j];
            }
          } else {
            if (matches(s, p, i, j)) {
              f[i][j] = f[i - 1][j - 1];
            }
          }
        }
      }
      return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
      if (i == 0) {
        return false;
      }
      if (p.charAt(j - 1) == '?') {
        return true;
      }
      return s.charAt(i - 1) == p.charAt(j - 1);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
