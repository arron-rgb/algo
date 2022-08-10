package edu.neu.algo.monotonic.leetcode.editor.en._20220810;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReverseStringII {
  // 541
  // Given a string s and an integer k, reverse the first k characters for every 2
  // k characters counting from the start of the string.
  //
  // If there are fewer than k characters left, reverse all of them. If there are
  // less than 2k but greater than or equal to k characters, then reverse the first
  // k characters and leave the other as original.
  //
  //
  // Example 1:
  // Input: s = "abcdefg", k = 2
  // Output: "bacdfeg"
  // Example 2:
  // Input: s = "abcd", k = 2
  // Output: "bacd"
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁴
  // s consists of only lowercase English letters.
  // 1 <= k <= 10⁴
  //
  // Related Topics Two Pointers String 👍 1108 👎 2599

  public static void main(String[] args) {
    Solution solution = new ReverseStringII().new Solution();
    String[] data = """
          "abcdefg"
      2
      "abcd"
      2
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q =
        solution.reverseStr((String)params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reverseStr(String s, int k) {
      char[] a = s.toCharArray();
      for (int start = 0; start < a.length; start += 2 * k) {
        int i = start, j = Math.min(start + k - 1, a.length - 1);
        while (i < j) {
          char tmp = a[i];
          a[i++] = a[j];
          a[j--] = tmp;
        }
      }
      return new String(a);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
