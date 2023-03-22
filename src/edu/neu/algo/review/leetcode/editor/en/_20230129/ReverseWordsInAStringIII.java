package edu.neu.algo.review.leetcode.editor.en._20230129;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class ReverseWordsInAStringIII {
  // 557
  // Given a string s, reverse the order of characters in each word within a
  // sentence while still preserving whitespace and initial word order.
  //
  //
  // Example 1:
  // Input: s = "Let's take LeetCode contest"
  // Output: "s'teL ekat edoCteeL tsetnoc"
  //
  // Example 2:
  // Input: s = "God Ding"
  // Output: "doG gniD"
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 5 * 10⁴
  // s contains printable ASCII characters.
  // s does not contain any leading or trailing spaces.
  // There is at least one word in s.
  // All the words in s are separated by a single space.
  //
  //
  // Related Topics Two Pointers String 👍 4539 👎 220

  public static void main(String[] args) {
    Solution solution = new ReverseWordsInAStringIII().new Solution();
    String[] data = """
                  "Let's take LeetCode contest"
      "God Ding"
      "I love u"
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.reverseWords((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reverseWords(String s) {
      int n = s.length();
      char[] ss = s.toCharArray();
      for (int i = 0; i < n;) {
        int j = i;
        while (j < n && s.charAt(j) != ' ') {
          j++;
        }
        reverse(ss, i, j - 1);
        // skip space
        i = j;
        while (i < n && s.charAt(i) == ' ') {
          i++;
        }
      }
      return new String(ss);
    }

    void reverse(char[] ss, int i, int j) {
      if (j >= ss.length) {
        j = ss.length - 1;
      }
      if (i == j) {
        return;
      }
      if (i > j) {
        throw new RuntimeException("");
      }
      while (i < j) {
        char c = ss[i];
        ss[i] = ss[j];
        ss[j] = c;
        i++;
        j--;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
