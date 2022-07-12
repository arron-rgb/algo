package edu.neu.algo.dp.leetcode.editor.en._20220711;

import java.util.*;
import edu.neu.util.InputUtil;

public class ValidNumber {
  // 65
  // A valid number can be split up into these components (in order):
  //
  //
  // A decimal number or an integer.
  // (Optional) An 'e' or 'E', followed by an integer.
  //
  //
  // A decimal number can be split up into these components (in order):
  //
  //
  // (Optional) A sign character (either '+' or '-').
  // One of the following formats:
  //
  // One or more digits, followed by a dot '.'.
  // One or more digits, followed by a dot '.', followed by one or more digits.
  // A dot '.', followed by one or more digits.
  //
  //
  //
  //
  // An integer can be split up into these components (in order):
  //
  //
  // (Optional) A sign character (either '+' or '-').
  // One or more digits.
  //
  //
  // For example, all the following are valid numbers: [],
  // while the following are not valid numbers: [].
  //
  // Given a string s, return true if s is a valid number.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "0"
  // Output: true
  //
  //
  // Example 2:
  //
  //
  // Input: s = "e"
  // Output: false
  //
  //
  // Example 3:
  //
  //
  // Input: s = "."
  // Output: false
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 20
  // s consists of only English letters (both uppercase and lowercase), digits (0-
  // 9), plus '+', minus '-', or dot '.'.
  //
  // Related Topics String 👍 652 👎 1175

  public static void main(String[] args) {
    Solution solution = new ValidNumber().new Solution();
    String[] data = """
          "0"
      "e"
      "."
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    List<String> falses = List.of("abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53");
    for (String string : falses) {
      boolean number = solution.isNumber(string);
      if (number) {
        System.err.println("false");
        break;
      }
    }
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isNumber((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isNumber(String s) {
      if (s == null || s.trim().length() == 0) {
        return false;
      }

      boolean seenNum = false;
      boolean seenE = false;
      boolean seenD = false;

      s = s.trim();
      for (int i = 0; i < s.length(); ++i) {
        char c = s.charAt(i);
        switch (c) {
          case '.' -> {
            if (seenD || seenE) {
              return false;
            }
            seenD = true;
          }
          case 'e', 'E' -> {
            if (seenE || !seenNum) {
              return false;
            }
            seenE = true;
            seenNum = false;
          }
          case '+', '-' -> {
            if (i != 0 && s.charAt(i - 1) != 'e') {
              return false;
            }
            seenNum = false;
          }
          default -> {
            if (c - '0' < 0 || c - '0' > 9) {
              return false;
            }
            seenNum = true;
          }
        }

      }
      return seenNum;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  // valid number:
  // 1. 小数 或 整数
  // 2. 整数后面可以跟e or E
  // 小数可以分成
  // 可选[+/-]
  // 必选
  // -- 1. 整数 和 一个.
  // -- 2. 整数 和 一个. 和 整数
  // -- 3. 一个. 和整数
  // 整数可以分成
  // 可选[+/-]
  // 必选
  // -- 1. 整数
}
