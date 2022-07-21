package edu.neu.algo.review.leetcode.editor.en._20220720;

import java.util.*;
import edu.neu.util.InputUtil;

public class NumberOfDigitOne {
  // 233
  // Given an integer n, count the total number of digit 1 appearing in all non-
  // negative integers less than or equal to n.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 13
  // Output: 6
  //
  //
  // Example 2:
  //
  //
  // Input: n = 0
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= n <= 10⁹
  //
  // Related Topics Math Dynamic Programming Recursion 👍 797 👎 1105

  public static void main(String[] args) {
    Solution solution = new NumberOfDigitOne().new Solution();
    String[] data = """
          13
      0
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.countDigitOne((int)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int countDigitOne(int n) {
      if (n < 1) {
        return 0;
      }
      if (n < 10) {
        return 1;
      }
      // x: first digit
      int y = 1, x = n;
      while (!(x < 10)) {
        x /= 10;
        y *= 10;
      }
      if (x == 1) {
        return n - y + 1 + countDigitOne(y - 1) + countDigitOne(n % y);
      } else {
        return y + x * countDigitOne(y - 1) + countDigitOne(n % y);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
