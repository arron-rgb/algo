package edu.neu.algo.review.leetcode.editor.en._20230130;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class CheckIfMatrixIsXMatrix {
  // 2319
  // A square matrix is said to be an X-Matrix if both of the following conditions
  // hold:
  //
  //
  // All the elements in the diagonals of the matrix are non-zero.
  // All other elements are 0.
  //
  //
  // Given a 2D integer array grid of size n x n representing a square matrix,
  // return true if grid is an X-Matrix. Otherwise, return false.
  //
  //
  // Example 1:
  //
  //
  // Input: grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
  // Output: true
  // Explanation: Refer to the diagram above.
  // An X-Matrix should have the green elements (diagonals) be non-zero and the
  // red elements be 0.
  // Thus, grid is an X-Matrix.
  //
  //
  // Example 2:
  //
  //
  // Input: grid = [[5,7,0],[0,3,1],[0,5,0]]
  // Output: false
  // Explanation: Refer to the diagram above.
  // An X-Matrix should have the green elements (diagonals) be non-zero and the
  // red elements be 0.
  // Thus, grid is not an X-Matrix.
  //
  //
  //
  // Constraints:
  //
  //
  // n == grid.length == grid[i].length
  // 3 <= n <= 100
  // 0 <= grid[i][j] <= 10⁵
  //
  //
  // Related Topics Array Matrix 👍 314 👎 10

  public static void main(String[] args) {
    Solution solution = new CheckIfMatrixIsXMatrix().new Solution();
    String[] data = """
                  [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
      [[5,7,0],[0,3,1],[0,5,0]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.checkXMatrix((int[][])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean checkXMatrix(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == j || i + j == n - 1) {
            if (grid[i][j] == 0) {
              return false;
            }
          } else {
            if (grid[i][j] != 0) {
              return false;
            }
          }
        }
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
