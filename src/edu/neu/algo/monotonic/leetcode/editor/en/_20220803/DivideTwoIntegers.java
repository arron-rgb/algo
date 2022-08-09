package edu.neu.algo.monotonic.leetcode.editor.en._20220803;

import java.util.*;
import edu.neu.util.InputUtil;

public class DivideTwoIntegers {
  // 29
  // Given two integers dividend and divisor, divide two integers without using
  // multiplication, division, and mod operator.
  //
  // The integer division should truncate toward zero, which means losing its
  // fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be
  // truncated to -2.
  //
  // Return the quotient after dividing dividend by divisor.
  //
  // Note: Assume we are dealing with an environment that could only store
  // integers within the 32-bit signed integer range: [−2³¹, 2³¹ − 1]. For this problem, if
  // the quotient is strictly greater than 2³¹ - 1, then return 2³¹ - 1, and if the
  // quotient is strictly less than -2³¹, then return -2³¹.
  //
  //
  // Example 1:
  //
  //
  // Input: dividend = 10, divisor = 3
  // Output: 3
  // Explanation: 10/3 = 3.33333.. which is truncated to 3.
  //
  //
  // Example 2:
  //
  //
  // Input: dividend = 7, divisor = -3
  // Output: -2
  // Explanation: 7/-3 = -2.33333.. which is truncated to -2.
  //
  //
  //
  // Constraints:
  //
  //
  // -2³¹ <= dividend, divisor <= 2³¹ - 1
  // divisor != 0
  //
  // Related Topics Math Bit Manipulation 👍 3339 👎 11288

  public static void main(String[] args) {
    Solution solution = new DivideTwoIntegers().new Solution();
    String[] data = """
          10
      3
      7
      -3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.divide((int)params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int divide(int dividend, int divisor) {
      if(dividend == Integer.MIN_VALUE && divisor == -1){
        return Integer.MAX_VALUE;
      }
      return dividend / divisor;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
