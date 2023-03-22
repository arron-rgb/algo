package edu.neu.algo.review.leetcode.editor.en._20230129;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class NThTribonacciNumber {
  // 1137
  // The Tribonacci sequence Tn is defined as follows:
  //
  // T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
  //
  // Given n, return the value of Tn.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 4
  // Output: 4
  // Explanation:
  // T_3 = 0 + 1 + 1 = 2
  // T_4 = 1 + 1 + 2 = 4
  //
  //
  // Example 2:
  //
  //
  // Input: n = 25
  // Output: 1389537
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= n <= 37
  // The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 -
  // 1.
  //
  //
  // Related Topics Math Dynamic Programming Memoization 👍 2598 👎 135

  public static void main(String[] args) {
    Solution solution = new NThTribonacciNumber().new Solution();
    String[] data = """
                  4
      25
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.tribonacci((int)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int tribonacci(int n) {
      if (n < 2) {
        return n;
      }
      if (n == 2) {
        return 1;
      }
      int a = 0;
      int b = 1;
      int c = 1;
      int res = 0;
      for (int i = 3; i <= n; i++) {
        res = a + b + c;
        a = b;
        b = c;
        c = res;
      }
      return res;

    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
