package edu.neu.algo.leetcode.editor.en._20220522;

public class PalindromicSubstrings {

  // Given a string s, return the number of palindromic substrings in it.
  //
  // A string is a palindrome when it reads the same backward as forward.
  //
  // A substring is a contiguous sequence of characters within the string.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "abc"
  // Output: 3
  // Explanation: Three palindromic strings: "a", "b", "c".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "aaa"
  // Output: 6
  // Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 1000
  // s consists of lowercase English letters.
  //
  // Related Topics String Dynamic Programming 👍 6879 👎 158

  public static void main(String[] args) {
    Solution solution = new PalindromicSubstrings().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int res = 0;

    public int countSubstrings(String s) {
      if (s == null || s.length() < 1) {
        return res;
      }
      for (int i = 0; i < s.length(); i++) {
        extend(s, i, i);
        extend(s, i, i + 1);
      }
      return res;
    }

    void extend(String s, int left, int right) {
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        res++;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
