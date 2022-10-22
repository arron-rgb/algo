package edu.neu.algo.monotonic.leetcode.editor.en._20221021;

import java.util.*;
import edu.neu.util.InputUtil;

public class FindTheIndexOfTheFirstOccurrenceInAString {
  // 28
  // Given two strings needle and haystack, return the index of the first
  // occurrence of needle in haystack, or -1 if needle is not part of haystack.
  //
  //
  // Example 1:
  //
  //
  // Input: haystack = "sadbutsad", needle = "sad"
  // Output: 0
  // Explanation: "sad" occurs at index 0 and 6.
  // The first occurrence is at index 0, so we return 0.
  //
  //
  // Example 2:
  //
  //
  // Input: haystack = "leetcode", needle = "leeto"
  // Output: -1
  // Explanation: "leeto" did not occur in "leetcode", so we return -1.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= haystack.length, needle.length <= 10⁴
  // haystack and needle consist of only lowercase English characters.
  //
  // Related Topics Two Pointers String String Matching 👍 628 👎 48

  public static void main(String[] args) {
    Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    String[] data = """
          "sadbutsad"
      "sad"
      "leetcode"
      "leeto"
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

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int strStr(String haystack, String needle) {
      int n = haystack.length();
      int m = needle.length();
      if (n < m) {
        return -1;
      }
      for (int i = 0; i < n; i++) {
        boolean find = true;
        for (int j = 0; j < m; j++) {
          if (haystack.charAt(i + j) != needle.charAt(j)) {
            find = false;
            break;
          }
        }
        if (find) {
          return i;
        }
      }
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
