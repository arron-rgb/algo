package edu.neu.algo.review.leetcode.editor.en._20221109;

import edu.neu.util.InputUtil;

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
  // Related Topics Hash Table String Sliding Window 👍 30125 👎 1287

  public static void main(String[] args) {
    Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    String[] data = """
      "abcabcbb"
      "bbbbb"
      "pwwkew"
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.lengthOfLongestSubstring((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int lengthOfLongestSubstring(String s) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
