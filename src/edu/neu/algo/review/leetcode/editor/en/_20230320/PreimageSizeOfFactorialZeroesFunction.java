package edu.neu.algo.review.leetcode.editor.en._20230320;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class PreimageSizeOfFactorialZeroesFunction {
  // 793
  // Let f(x) be the number of zeroes at the end of x!. Recall that x! = 1 * 2 * 3
  // * ... * x and by convention, 0! = 1.
  //
  //
  // For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) =
  // 2 because 11! = 39916800 has two zeroes at the end.
  //
  //
  // Given an integer k, return the number of non-negative integers x have the
  // property that f(x) = k.
  //
  //
  // Example 1:
  //
  //
  // Input: k = 0
  // Output: 5
  // Explanation: 0!, 1!, 2!, 3!, and 4! end with k = 0 zeroes.
  //
  //
  // Example 2:
  //
  //
  // Input: k = 5
  // Output: 0
  // Explanation: There is no x such that x! ends in k = 5 zeroes.
  //
  //
  // Example 3:
  //
  //
  // Input: k = 3
  // Output: 5
  //
  //
  //
  // Constraints:
  //
  //
  // 0 <= k <= 10⁹
  //
  //
  // Related Topics Math Binary Search 👍 380 👎 86

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] data = """
                  0
      5
      3
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.preimageSizeFZF((int)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int preimageSizeFZF(int k) {
      long l = k - 1, r = k * 10L + 1;
      while (l + 1 < r) {
        long m = l + r >> 1, t = f(m);
        if (t == k)
          return 5;
        else if (t < k)
          l = m;
        else
          r = m;
      }
      return 0;
    }

    long f(long n) {
      if (n == 0)
        return 0;
      return n / 5 + f(n / 5);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
