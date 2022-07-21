package edu.neu.algo.review.leetcode.editor.en._20220720;

import java.util.*;
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
  // Related Topics String Dynamic Programming 👍 19876 👎 1151

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
    int left = 0, max = -1;

    public String longestPalindrome(String s) {
      int n = s.length();
      if (n < 2) {
        return s;
      }

      for (int i = 0; i < n - 1; i++) {
        expand(s, i, i); // assume odd length, try to extend Palindrome as possible
        expand(s, i, i + 1); // assume even length.
      }
      return s.substring(left, left + max);
    }

    void expand(String s, int left, int right) {
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      if (right - left - 1 > max) {
        this.left = left + 1;
        max = right - left - 1;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
