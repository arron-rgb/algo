package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class Pow {
  // 50
  // Implement pow(x, n), which calculates x raised to the power n (i.e., xⁿ).
  //
  //
  // Example 1:
  //
  //
  // Input: x = 2.00000, n = 10
  // Output: 1024.00000
  //
  //
  // Example 2:
  //
  //
  // Input: x = 2.10000, n = 3
  // Output: 9.26100
  //
  //
  // Example 3:
  //
  //
  // Input: x = 2.00000, n = -2
  // Output: 0.25000
  // Explanation: 2⁻² = 1/2² = 1/4 = 0.25
  //
  //
  //
  // Constraints:
  //
  //
  // -100.0 < x < 100.0
  // -2³¹ <= n <= 2³¹-1
  // -10⁴ <= xⁿ <= 10⁴
  //
  // Related Topics Math Recursion 👍 5188 👎 5933

  public static void main(String[] args) {
    Solution solution = new Pow().new Solution();
    String[] data = """
          2.00000
      10
      2.10000
      3
      2.00000
      -2
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[double, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      double q =
        solution.myPow((double)params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public double myPow(double x, int n) {
      if (x == 0.0f) {
        return 0.0d;
      }
      long b = n;
      double res = 1.0;
      if (b < 0) {
        x = 1 / x;
        b = -b;
      }
      while (b > 0) {
        if ((b & 1) == 1) {
          res *= x;
        }
        x *= x;
        b >>= 1;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
