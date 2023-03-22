package edu.neu.algo.review.leetcode.editor.en._20230207;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MinimumFallingPathSum {
  // 931
  // Given an n x n array of integers matrix, return the minimum sum of any
  // falling path through matrix.
  //
  // A falling path starts at any element in the first row and chooses the
  // element in the next row that is either directly below or diagonally left/right.
  // Specifically, the next element from position (row, col) will be (row + 1, col - 1), (
  // row + 1, col), or (row + 1, col + 1).
  //
  //
  // Example 1:
  //
  //
  // Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
  // Output: 13
  // Explanation: There are two falling paths with a minimum sum as shown.
  //
  //
  // Example 2:
  //
  //
  // Input: matrix = [[-19,57],[-40,-5]]
  // Output: -59
  // Explanation: The falling path with a minimum sum is shown.
  //
  //
  //
  // Constraints:
  //
  //
  // n == matrix.length == matrix[i].length
  // 1 <= n <= 100
  // -100 <= matrix[i][j] <= 100
  //
  //
  // Related Topics Array Dynamic Programming Matrix 👍 4425 👎 118

  public static void main(String[] args) {
    Solution solution = new MinimumFallingPathSum().new Solution();
    String[] data = """
                  [[2,1,3],[6,5,4],[7,8,9]]
      [[-19,57],[-40,-5]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minFallingPathSum((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minFallingPathSum(int[][] matrix) {
      int m = matrix.length;
      for (int i = 1; i < m; ++i)
        for (int j = 0; j < m; ++j)
          matrix[i][j] += Math.min(matrix[i - 1][j],
            Math.min(matrix[i - 1][Math.max(0, j - 1)], matrix[i - 1][Math.min(m - 1, j + 1)]));

      return Arrays.stream(matrix[m - 1]).min().getAsInt();
    }
  }
  // runtime:3 ms
  // memory:48.1 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
