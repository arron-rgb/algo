package edu.neu.algo.dp.leetcode.editor.en._20220708;

import java.util.*;
import edu.neu.util.InputUtil;

public class EditDistance {
  // 72
  // Given two strings word1 and word2, return the minimum number of operations
  // required to convert word1 to word2.
  //
  // You have the following three operations permitted on a word:
  //
  //
  // Insert a character
  // Delete a character
  // Replace a character
  //
  //
  //
  // Example 1:
  //
  //
  // Input: word1 = "horse", word2 = "ros"
  // Output: 3
  // Explanation:
  // horse -> rorse (replace 'h' with 'r')
  // rorse -> rose (remove 'r')
  // rose -> ros (remove 'e')
  //
  //
  // Example 2:
  //
  //
  // Input: word1 = "intention", word2 = "execution"
  // Output: 5
  // Explanation:
  // intention -> inention (remove 't')
  // inention -> enention (replace 'i' with 'e')
  // enention -> exention (replace 'n' with 'x')
  // exention -> exection (replace 'n' with 'c')
  // exection -> execution (insert 'u')
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= word1.length, word2.length <= 500
  // word1 and word2 consist of lowercase English letters.
  //
  // Related Topics String Dynamic Programming 👍 9080 👎 106

  public static void main(String[] args) {
    Solution solution = new EditDistance().new Solution();
    String[] data = """
          "horse"
      "ros"
      "intention"
      "execution"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minDistance((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minDistance(String s, String t) {
      if (s.length() > t.length()) {
        String tmp = t;
        t = s;
        s = tmp;
      }
      int m = s.length();
      int n = t.length();
      int[][] dp = new int[m + 1][n + 1];
      // insert a letter: 可以从dp[i-1][j]或者dp[i][j-1]到dp[i][j]
      // delete: 可以从
      // replace: dp[i-1][j-1] + 1
      // 当前相等: 可以从dp[i-1][j-1]直接到
      // i=1, j=2: dp[i][j] =
      // 当前不等: 可以从dp[i-1][j] 或者 dp[i][j-1] 插入 或者 dp[i-1][j-1] 替换
      // - h o r s e
      // r 1 2 2 3 4
      // o 2 1 2 3 4
      // s 3 2 2
      // for (int i = 1; i < dp.length; i++) {
      // Arrays.fill(dp[i], Integer.MAX_VALUE);
      // }
      for (int i = 0; i < m + 1; i++) {
        dp[i][0] = i;
      }
      for (int j = 0; j < n + 1; j++) {
        dp[0][j] = j;
      }
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (s.charAt(i - 1) == t.charAt(j - 1)) {
            // 相等 直接从dp[i-1][j-1]过来
            dp[i][j] = dp[i - 1][j - 1];
          } else {
            // 不相等，可以从dp[i-1][j-1] 替换一个
            // 或者从dp[i-1][j] or dp[i][j-1] 加一个
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
          }
        }
      }
      return dp[m][n];
    }

    int min(int... i) {
      int min = Integer.MAX_VALUE;
      for (int i1 : i) {
        if (i1 < min) {
          min = i1;
        }
      }
      return min;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
