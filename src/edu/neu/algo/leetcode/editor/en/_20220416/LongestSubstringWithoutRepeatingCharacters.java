package edu.neu.algo.leetcode.editor.en._20220416;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  // Given a string s, find the length of the longest substring without repeating
  // characters.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "abcabcbb"
  // Output: 3
  // Explanation: The answer is "abc", with the length of 3.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "bbbbb"
  // Output: 1
  // Explanation: The answer is "b", with the length of 1.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "pwwkew"
  // Output: 3
  // Explanation: The answer is "wke", with the length of 3.
  // Notice that the answer must be a substring, "pwke" is a subsequence and not a
  // substring.
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= s.length <= 5 * 10⁴
  // s consists of English letters, digits, symbols and spaces.
  //
  // Related Topics Hash Table String Sliding Window 👍 22933 👎 1027

  public static void main(String[] args) {

  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int lengthOfLongestSubstring(String s) {
      int left = 0, right = 0;
      int res = 0;
      Set<Character> set = new HashSet<>();
      while (right < s.length()) {
        if (set.contains(s.charAt(right))) {
          res = Math.max(res, right - left + 1);
          left++;
          right++;
        } else {
          set.add(s.charAt(right));
          right++;
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
