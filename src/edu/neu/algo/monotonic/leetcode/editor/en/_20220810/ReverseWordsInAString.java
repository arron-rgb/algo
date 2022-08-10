package edu.neu.algo.monotonic.leetcode.editor.en._20220810;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReverseWordsInAString {
  // 151
  // Given an input string s, reverse the order of the words.
  //
  // A word is defined as a sequence of non-space characters. The words in s will
  // be separated by at least one space.
  //
  // Return a string of the words in reverse order concatenated by a single space.
  //
  //
  // Note that s may contain leading or trailing spaces or multiple spaces
  // between two words. The returned string should only have a single space separating the
  // words. Do not include any extra spaces.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "the sky is blue"
  // Output: "blue is sky the"
  //
  //
  // Example 2:
  //
  //
  // Input: s = " hello world "
  // Output: "world hello"
  // Explanation: Your reversed string should not contain leading or trailing
  // spaces.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "a good example"
  // Output: "example good a"
  // Explanation: You need to reduce multiple spaces between two words to a single
  // space in the reversed string.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁴
  // s contains English letters (upper-case and lower-case), digits, and spaces '
  // '.
  // There is at least one word in s.
  //
  //
  //
  // Follow-up: If the string data type is mutable in your language, can you
  // solve it in-place with O(1) extra space?
  // Related Topics Two Pointers String 👍 3637 👎 4062

  public static void main(String[] args) {
    Solution solution = new ReverseWordsInAString().new Solution();
    String[] data = """
          "the sky is blue"
      "  hello world  "
      "a good   example"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.reverseWords((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reverseWords(String s) {
      String[] words = s.trim().split(" +");
      Collections.reverse(Arrays.asList(words));
      return String.join(" ", words);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
