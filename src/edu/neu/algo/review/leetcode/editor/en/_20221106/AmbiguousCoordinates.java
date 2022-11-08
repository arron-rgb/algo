package edu.neu.algo.review.leetcode.editor.en._20221106;

import java.util.*;
import edu.neu.util.InputUtil;

public class AmbiguousCoordinates {
  // 816
  // We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)". Then, we
  // removed all commas, decimal points, and spaces and ended up with the string s.
  //
  //
  // For example, "(1, 3)" becomes s = "(13)" and "(2, 0.5)" becomes s = "(205)".
  //
  //
  //
  // Return a list of strings representing all possibilities for what our
  // original coordinates could have been.
  //
  // Our original representation never had extraneous zeroes, so we never started
  // with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other
  // number that can be represented with fewer digits. Also, a decimal point within a
  // number never occurs without at least one digit occurring before it, so we never
  // started with numbers like ".1".
  //
  // The final answer list can be returned in any order. All coordinates in the
  // final answer have exactly one space between them (occurring after the comma.)
  //
  //
  // Example 1:
  //
  //
  // Input: s = "(123)"
  // Output: ["(1, 2.3)","(1, 23)","(1.2, 3)","(12, 3)"]
  //
  //
  // Example 2:
  //
  //
  // Input: s = "(0123)"
  // Output: ["(0, 1.23)","(0, 12.3)","(0, 123)","(0.1, 2.3)","(0.1, 23)","(0.12, 3
  // )"]
  // Explanation: 0.0, 00, 0001 or 00.01 are not allowed.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "(00011)"
  // Output: ["(0, 0.011)","(0.001, 1)"]
  //
  //
  //
  // Constraints:
  //
  //
  // 4 <= s.length <= 12
  // s[0] == '(' and s[s.length - 1] == ')'.
  // The rest of s are digits.
  //
  // Related Topics String Backtracking 👍 275 👎 616

  public static void main(String[] args) {
    Solution solution = new AmbiguousCoordinates().new Solution();
    String[] data = """
          "(123)"
      "(0123)"
      "(00011)"
          """.trim().replaceAll("\n", "<newLine>").split("<newLine>");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.ambiguousCoordinates((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<String> ambiguousCoordinates(String s) {
      List<String> ans = new ArrayList<>();
      for (int i = 2; i < s.length() - 1; ++i) {
        // 每组left有相对应的一组right，
        // 遍历每种选项，全部拼接起来即可
        for (String left : make(s, 1, i)) {
          for (String right : make(s, i, s.length() - 1)) {
            ans.add("(" + left + ", " + right + ")");
          }
        }
      }
      return ans;
    }

    public List<String> make(String s, int i, int j) {
      // 考虑如何生成left和right
      List<String> ans = new ArrayList<>();
      for (int d = 1; d <= j - i; ++d) {
        String left = s.substring(i, i + d);
        String right = s.substring(i + d, j);
        if ((!left.startsWith("0") || "0".equals(left)) && !right.endsWith("0")) {
          ans.add(left + (d < j - i ? "." : "") + right);
        }
      }
      return ans;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
