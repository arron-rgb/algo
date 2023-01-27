package edu.neu.algo.review.leetcode.editor.en._20230127;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class DecodeWays {
  // 91
  // A message containing letters from A-Z can be encoded into numbers using the
  // following mapping:
  //
  //
  // 'A' -> "1"
  // 'B' -> "2"
  // ...
  // 'Z' -> "26"
  //
  //
  // To decode an encoded message, all the digits must be grouped then mapped
  // back into letters using the reverse of the mapping above (there may be multiple
  // ways). For example, "11106" can be mapped into:
  //
  //
  // "AAJF" with the grouping (1 1 10 6)
  // "KJF" with the grouping (11 10 6)
  //
  //
  // Note that the grouping (1 11 06) is invalid because "06" cannot be mapped
  // into 'F' since "6" is different from "06".
  //
  // Given a string s containing only digits, return the number of ways to decode
  // it.
  //
  // The test cases are generated so that the answer fits in a 32-bit integer.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "12"
  // Output: 2
  // Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
  //
  //
  // Example 2:
  //
  //
  // Input: s = "226"
  // Output: 3
  // Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
  // 6).
  //
  //
  // Example 3:
  //
  //
  // Input: s = "06"
  // Output: 0
  // Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is
  // different from "06").
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 100
  // s contains only digits and may contain leading zero(s).
  //
  //
  // Related Topics String Dynamic Programming 👍 9449 👎 4186

  public static void main(String[] args) {
    Solution solution = new DecodeWays().new Solution();
    String[] data = """
                  "12"
      "226"
      "06"
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numDecodings((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numDecodings(String s) {
      if (s == null || s.isEmpty()) {
        return 0;
      }
      int n = s.length();
      // dp[i] presents how many ways to decode string s with len i
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = s.charAt(0) != '0' ? 1 : 0;
      for (int i = 2; i <= n; i++) {
        int first = Integer.parseInt(s.substring(i - 1, i));
        int second = Integer.parseInt(s.substring(i - 2, i));
        if (first >= 1 && first <= 9) {
          dp[i] += dp[i - 1];
        }
        if (second >= 10 && second <= 26) {
          dp[i] += dp[i - 2];
        }
      }
      return dp[n];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
