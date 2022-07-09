package edu.neu.algo.dp.leetcode.editor.en._20220708;

import java.util.*;
import edu.neu.util.InputUtil;

public class DeleteOperationForTwoStrings {
  // 583
  // Given two strings word1 and word2, return the minimum number of steps
  // required to make word1 and word2 the same.
  //
  // In one step, you can delete exactly one character in either string.
  //
  //
  // Example 1:
  //
  //
  // Input: word1 = "sea", word2 = "eat"
  // Output: 2
  // Explanation: You need one step to make "sea" to "ea" and another step to make
  // "eat" to "ea".
  //
  //
  // Example 2:
  //
  //
  // Input: word1 = "leetcode", word2 = "etco"
  // Output: 4
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= word1.length, word2.length <= 500
  // word1 and word2 consist of only lowercase English letters.
  //
  // Related Topics String Dynamic Programming 👍 4190 👎 63

  public static void main(String[] args) {
    Solution solution = new DeleteOperationForTwoStrings().new Solution();
    String[] data = """
          "sea"
      "eat"
      "leetcode"
      "etco"
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

      int m = s.length();
      int n = t.length();
      int[][] dp = new int[m + 1][n + 1];

      // - e a t
      // s 0 0 0
      // e 1 1 1
      // a 1 2 2
      // dp[i][j] 表示 从s.substring(0,i)和t.substring(0, j) 最长的连续子序列的长度
      // 最后的结果就是
      // 每步 可以删除任意一个字符串中的一个字符。
      // - l e e t c o d e
      // e 0 1 1 1 1 1 1 1
      // t 0 1 1 2 2
      // c 0 1 1 2 3
      // o
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
          }
        }
      }
      // System.out.println(Arrays.deepToString(dp));
      return m + n - 2 * dp[m][n];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
