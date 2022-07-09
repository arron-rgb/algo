package edu.neu.algo.dp.leetcode.editor.en._20220709;

import java.util.*;
import edu.neu.util.InputUtil;

public class DistinctSubsequences {
  // 115
  // Given two strings s and t, return the number of distinct subsequences of s
  // which equals t.
  //
  // A string's subsequence is a new string formed from the original string by
  // deleting some (can be none) of the characters without disturbing the remaining
  // characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while
  // "AEC" is not).
  //
  // The test cases are generated so that the answer fits on a 32-bit signed
  // integer.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "rabbbit", t = "rabbit"
  // Output: 3
  // Explanation:
  // As shown below, there are 3 ways you can generate "rabbit" from S.
  // rabbbit
  // rabbbit
  // rabbbit
  //
  //
  // Example 2:
  //
  //
  // Input: s = "babgbag", t = "bag"
  // Output: 5
  // Explanation:
  // As shown below, there are 5 ways you can generate "bag" from S.
  // babgbag
  // babgbag
  // babgbag
  // babgbag
  // babgbag
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length, t.length <= 1000
  // s and t consist of English letters.
  //
  // Related Topics String Dynamic Programming 👍 3823 👎 158

  public static void main(String[] args) {
    Solution solution = new DistinctSubsequences().new Solution();
    String[] data = """
          "rabbbit"
      "rabbit"
      "babgbag"
      "bag"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numDistinct((String)params[1 + i * paramTypes.length - 1],
        (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numDistinct(String t, String s) {
      // array creation
      int m = t.length();
      int n = s.length();
      int[][] dp = new int[n + 1][m + 1];

      // filling the first row: with 1s
      for (int j = 0; j <= m; j++) {
        dp[0][j] = 1;
      }
      // the first column is 0 by default in every other rows but the first, which we need.
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
          } else {
            dp[i][j] = dp[i][j - 1];
          }
        }
      }
      System.out.println(Arrays.deepToString(dp));

      return dp[n][m];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
