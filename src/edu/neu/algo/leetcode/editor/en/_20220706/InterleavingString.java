package edu.neu.algo.leetcode.editor.en._20220706;

import edu.neu.util.InputUtil;

public class InterleavingString {
  // 97
  // Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of
  // s1 and s2.
  //
  // An interleaving of two strings s and t is a configuration where they are
  // divided into non-empty substrings such that:
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
  //
  //
  // Example 2:
  //
  //
  // Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
  // Output: false
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
  // Related Topics String Dynamic Programming 👍 4118 👎 228

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
      boolean q = solution.isInterleave((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length], (String)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
