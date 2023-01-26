package edu.neu.algo.review.leetcode.editor.en._20230124;

import edu.neu.util.InputUtil;
import java.util.*;

public class FractionToRecurringDecimal {

  // Given two integers representing the numerator and denominator of a fraction,
  // return the fraction in string format.
  //
  // If the fractional part is repeating, enclose the repeating part in
  // parentheses.
  //
  // If multiple answers are possible, return any of them.
  //
  // It is guaranteed that the length of the answer string is less than 10⁴ for
  // all the given inputs.
  //
  //
  // Example 1:
  //
  //
  // Input: numerator = 1, denominator = 2
  // Output: "0.5"
  //
  //
  // Example 2:
  //
  //
  // Input: numerator = 2, denominator = 1
  // Output: "2"
  //
  //
  // Example 3:
  //
  //
  // Input: numerator = 4, denominator = 333
  // Output: "0.(012)"
  //
  //
  //
  // Constraints:
  //
  //
  // -2³¹ <= numerator, denominator <= 2³¹ - 1
  // denominator != 0
  //
  //
  // Related Topics Hash Table Math String 👍 1840 👎 3338

  public static void main(String[] args) {
    Solution solution = new FractionToRecurringDecimal().new Solution();
    String[] data = """
                  1
      2
      2
      1
      4
      333
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.fractionToDecimal((int)params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
      return "";
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
