package edu.neu.algo.monotonic.leetcode.editor.en._20220729;

import java.util.*;
import edu.neu.util.InputUtil;

public class ImplementStrStr {
  // 28
  // Implement strStr().
  //
  // Given two strings needle and haystack, return the index of the first
  // occurrence of needle in haystack, or -1 if needle is not part of haystack.
  //
  // Clarification:
  //
  // What should we return when needle is an empty string? This is a great
  // question to ask during an interview.
  //
  // For the purpose of this problem, we will return 0 when needle is an empty
  // string. This is consistent to C's strstr() and Java's indexOf().
  //
  //
  // Example 1:
  //
  //
  // Input: haystack = "hello", needle = "ll"
  // Output: 2
  //
  //
  // Example 2:
  //
  //
  // Input: haystack = "aaaaa", needle = "bba"
  // Output: -1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= haystack.length, needle.length <= 10⁴
  // haystack and needle consist of only lowercase English characters.
  //
  // Related Topics Two Pointers String String Matching 👍 4638 👎 3839

  public static void main(String[] args) {
    Solution solution = new ImplementStrStr().new Solution();
    String[] data = """
          "hello"
      "ll"
      "aaaaa"
      "bba"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.strStr((String)params[1 + i * paramTypes.length - 1], (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int strStr(String haystack, String needle) {
      if (null == needle) {
        return 0;
      }
      int ret = -1;
      int indexB = 0;
      int indexE = needle.length();
      while (indexE <= haystack.length()) {
        if (haystack.substring(indexB, indexE).equals(needle)) {
          ret = indexB;
          break;
        }
        indexB++;
        indexE++;

      }
      return ret;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
