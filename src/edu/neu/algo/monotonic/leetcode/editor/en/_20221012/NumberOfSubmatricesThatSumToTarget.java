package edu.neu.algo.monotonic.leetcode.editor.en._20221012;

import java.util.*;
import edu.neu.util.InputUtil;

public class NumberOfSubmatricesThatSumToTarget {
  // 1074
  // Given a matrix and a target, return the number of non-empty submatrices that
  // sum to target.
  //
  // A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x
  // <= x2 and y1 <= y <= y2.
  //
  // Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if
  // they have some coordinate that is different: for example, if x1 != x1'.
  //
  //
  // Example 1:
  //
  //
  // Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
  // Output: 4
  // Explanation: The four 1x1 submatrices that only contain 0.
  //
  //
  // Example 2:
  //
  //
  // Input: matrix = [[1,-1],[-1,1]], target = 0
  // Output: 5
  // Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2
  // x2 submatrix.
  //
  //
  // Example 3:
  //
  //
  // Input: matrix = [[904]], target = 0
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= matrix.length <= 100
  // 1 <= matrix[0].length <= 100
  // -1000 <= matrix[i] <= 1000
  // -10^8 <= target <= 10^8
  //
  // Related Topics Array Hash Table Matrix Prefix Sum 👍 2776 👎 61

  public static void main(String[] args) {
    Solution solution = new NumberOfSubmatricesThatSumToTarget().new Solution();
    String[] data = """
          [[0,1,0],[1,1,1],[0,1,0]]
      0
      [[1,-1],[-1,1]]
      0
      [[904]]
      0
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numSubmatrixSumTarget((int[][])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
