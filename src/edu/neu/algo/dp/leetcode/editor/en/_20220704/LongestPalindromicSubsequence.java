package edu.neu.algo.dp.leetcode.editor.en._20220704;

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
  // Related Topics String Dynamic Programming 👍 5586 👎 252

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
      int q = solution.longestPalindromeSubseq((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestPalindromeSubseq(String s) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
