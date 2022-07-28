package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class InterleavingString {
  // 97
  // Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of
  // s1 and s2.
  //
  // An interleaving of two strings s and t is a configuration where s and t are
  // divided into n and m non-empty substrings respectively, such that:
  //
  //
  // s = s1 + s2 + ... + sn
  // t = t1 + t2 + ... + tm
  // |n - m| <= 1
  // The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 +
  // t3 + s3 + ...
  //
  //
  // Note: a + b is the concatenation of strings a and b.
  //
  //
  // Example 1:
  //
  //
  // Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
  // Output: true
  // Explanation: One way to obtain s3 is:
  // Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
  // Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" =
  // "aadbbcbcac".
  // Since s3 can be obtained by interleaving s1 and s2, we return true.
  //
  //
  // Example 2:
  //
  //
  // Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
  // Output: false
  // Explanation: Notice how it is impossible to interleave s2 with any other
  // string to obtain s3.
  //
  //
  // Example 3:
  //
  //
  // Input: s1 = "", s2 = "", s3 = ""
  // Output: true
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= s1.length, s2.length <= 100
  // 0 <= s3.length <= 200
  // s1, s2, and s3 consist of lowercase English letters.
  //
  //
  //
  // Follow up: Could you solve it using only O(s2.length) additional memory
  // space?
  // Related Topics String Dynamic Programming 👍 5585 👎 333

  public static void main(String[] args) {
    Solution solution = new InterleavingString().new Solution();
    String[] data = """
          "aabcc"
      "dbbca"
      "aadbbcbcac"
      "aabcc"
      "dbbca"
      "aadbbbaccc"
      ""
      ""
      ""
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isInterleave((String)params[1 + i * paramTypes.length - 1],
        (String)params[2 + i * paramTypes.length - 1], (String)params[3 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      if (s3.length() != s1.length() + s2.length()) {
        return false;
      }
      boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
      for (int i = 0; i <= s1.length(); i++) {
        for (int j = 0; j <= s2.length(); j++) {
          if (i == 0 && j == 0) {
            dp[i][j] = true;
          } else if (i == 0) {
            dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
          } else if (j == 0) {
            dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
          } else {
            dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
              || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
          }
        }
      }
      return dp[s1.length()][s2.length()];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
