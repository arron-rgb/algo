package edu.neu.algo.review.leetcode.editor.en._20221102;

import edu.neu.util.InputUtil;

public class LongestPalindromicSubstring {
  // 5
  // Given a string s, return the longest palindromic substring in s.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "babad"
  // Output: "bab"
  // Explanation: "aba" is also a valid answer.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "cbbd"
  // Output: "bb"
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 1000
  // s consist of only digits and English letters.
  //
  // Related Topics String Dynamic Programming 👍 22355 👎 1289

  public static void main(String[] args) {
    Solution solution = new LongestPalindromicSubstring().new Solution();
    String[] data = """
          "babad"
      "cbbd"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.longestPalindrome((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    private int start, max;

    public String longestPalindrome(String s) {
      int len = s.length();
      if (len < 2) {
        return s;
      }

      for (int i = 0; i < len - 1; i++) {
        extend(s, i, i);
        extend(s, i, i + 1);
      }
      return s.substring(start, start + max);
    }

    private void extend(String s, int left, int right) {
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      if (max < right - left - 1) {
        start = left + 1;
        max = right - left - 1;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
