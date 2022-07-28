package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class PermutationSequence {
  // 60
  // The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
  //
  // By listing and labeling all of the permutations in order, we get the
  // following sequence for n = 3:
  //
  //
  // "123"
  // "132"
  // "213"
  // "231"
  // "312"
  // "321"
  //
  //
  // Given n and k, return the kᵗʰ permutation sequence.
  //
  //
  // Example 1:
  // Input: n = 3, k = 3
  // Output: "213"
  // Example 2:
  // Input: n = 4, k = 9
  // Output: "2314"
  // Example 3:
  // Input: n = 3, k = 1
  // Output: "123"
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 9
  // 1 <= k <= n!
  //
  // Related Topics Math Recursion 👍 4382 👎 406

  public static void main(String[] args) {
    Solution solution = new PermutationSequence().new Solution();
    String[] data = """
          3
      3
      4
      9
      3
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q =
        solution.getPermutation((int)params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String getPermutation(int n, int k) {
      int[] factorial = new int[n];
      factorial[0] = 1;
      for (int i = 1; i < n; ++i) {
        factorial[i] = factorial[i - 1] * i;
      }

      --k;
      StringBuilder res = new StringBuilder();
      int[] valid = new int[n + 1];
      Arrays.fill(valid, 1);
      for (int i = 1; i <= n; ++i) {
        int order = k / factorial[n - i] + 1;
        for (int j = 1; j <= n; ++j) {
          order -= valid[j];
          if (order == 0) {
            res.append(j);
            valid[j] = 0;
            break;
          }
        }
        k %= factorial[n - i];
      }
      return res.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
