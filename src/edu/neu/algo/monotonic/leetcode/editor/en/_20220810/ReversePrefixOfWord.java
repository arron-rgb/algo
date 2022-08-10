package edu.neu.algo.monotonic.leetcode.editor.en._20220810;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReversePrefixOfWord {
  // 2000
  // Given a 0-indexed string word and a character ch, reverse the segment of word
  // that starts at index 0 and ends at the index of the first occurrence of ch (
  // inclusive). If the character ch does not exist in word, do nothing.
  //
  //
  // For example, if word = "abcdefd" and ch = "d", then you should reverse the
  // segment that starts at 0 and ends at 3 (inclusive). The resulting string will be
  // "dcbaefd".
  //
  //
  // Return the resulting string.
  //
  //
  // Example 1:
  //
  //
  // Input: word = "abcdefd", ch = "d"
  // Output: "dcbaefd"
  // Explanation: The first occurrence of "d" is at index 3.
  // Reverse the part of word from 0 to 3 (inclusive), the resulting string is
  // "dcbaefd".
  //
  //
  // Example 2:
  //
  //
  // Input: word = "xyxzxe", ch = "z"
  // Output: "zxyxxe"
  // Explanation: The first and only occurrence of "z" is at index 3.
  // Reverse the part of word from 0 to 3 (inclusive), the resulting string is
  // "zxyxxe".
  //
  //
  // Example 3:
  //
  //
  // Input: word = "abcd", ch = "z"
  // Output: "abcd"
  // Explanation: "z" does not exist in word.
  // You should not do any reverse operation, the resulting string is "abcd".
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= word.length <= 250
  // word consists of lowercase English letters.
  // ch is a lowercase English letter.
  //
  // Related Topics Two Pointers String 👍 411 👎 9

  public static void main(String[] args) {
    Solution solution = new ReversePrefixOfWord().new Solution();
    String[] data = """
          "abcdefd"
      "d"
      "xyxzxe"
      "z"
      "abcd"
      "z"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, char]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.reversePrefix((String)params[1 + i * paramTypes.length - 1],
        (char)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reversePrefix(String word, char ch) {
      StringBuilder stringBuilder = new StringBuilder();
      int i = 0;
      for (; i < word.length(); i++) {
        char c = word.charAt(i);
        if (c != ch) {
          stringBuilder.append(c);
        } else {
          stringBuilder.append(c);
          stringBuilder.reverse();
          break;
        }
      }
      if (i + 1 < word.length()) {
        stringBuilder.append(word.substring(i + 1));
      }
      return stringBuilder.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
