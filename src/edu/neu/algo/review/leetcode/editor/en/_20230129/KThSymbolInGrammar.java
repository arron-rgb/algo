package edu.neu.algo.review.leetcode.editor.en._20230129;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class KThSymbolInGrammar {
  // 779
  // We build a table of n rows (1-indexed). We start by writing 0 in the 1ˢᵗ row.
  // Now in every subsequent row, we look at the previous row and replace each
  // occurrence of 0 with 01, and each occurrence of 1 with 10.
  //
  //
  // For example, for n = 3, the 1ˢᵗ row is 0, the 2ⁿᵈ row is 01, and the 3ʳᵈ row
  // is 0110.
  //
  //
  // Given two integer n and k, return the kᵗʰ (1-indexed) symbol in the nᵗʰ row
  // of a table of n rows.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 1, k = 1
  // Output: 0
  // Explanation: row 1: 0
  //
  //
  // Example 2:
  //
  //
  // Input: n = 2, k = 1
  // Output: 0
  // Explanation:
  // row 1: 0
  // row 2: 01
  //
  //
  // Example 3:
  //
  //
  // Input: n = 2, k = 2
  // Output: 1
  // Explanation:
  // row 1: 0
  // row 2: 01
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 30
  // 1 <= k <= 2n - 1
  //
  //
  // Related Topics Math Bit Manipulation Recursion 👍 2357 👎 286

  public static void main(String[] args) {
    Solution solution = new KThSymbolInGrammar().new Solution();
    String[] data = """
                  1
      1
      2
      1
      2
      2
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.kthGrammar((int)params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int solve(int i, int j, int k, int curr) {
      if (i == j)
        return curr;
      int m = (i + j) / 2;
      if (m < k)
        return solve(m + 1, j, k, 1 - curr);
      return solve(i, m, k, curr);
    }

    public int kthGrammar(int n, int k) {
      int range = (int)Math.pow(2, n - 1);
      return solve(0, range - 1, k - 1, 0);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
