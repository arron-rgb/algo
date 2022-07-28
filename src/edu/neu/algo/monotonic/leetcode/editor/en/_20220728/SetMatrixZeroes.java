package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class SetMatrixZeroes {
  // 73
  // Given an m x n integer matrix matrix, if an element is 0, set its entire row
  // and column to 0's.
  //
  // You must do it in place.
  //
  //
  // Example 1:
  //
  //
  // Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
  // Output: [[1,0,1],[0,0,0],[1,0,1]]
  //
  //
  // Example 2:
  //
  //
  // Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
  // Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
  //
  //
  //
  // Constraints:
  //
  //
  // m == matrix.length
  // n == matrix[0].length
  // 1 <= m, n <= 200
  // -2³¹ <= matrix[i][j] <= 2³¹ - 1
  //
  //
  //
  // Follow up:
  //
  //
  // A straightforward solution using O(mn) space is probably a bad idea.
  // A simple improvement uses O(m + n) space, but still not the best solution.
  // Could you devise a constant space solution?
  //
  // Related Topics Array Hash Table Matrix 👍 8273 👎 523

  public static void main(String[] args) {
    Solution solution = new SetMatrixZeroes().new Solution();
    String[] data = """
          [[1,1,1],[1,0,1],[1,1,1]]
      [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[][] param = (int[][])params[1 + i * paramTypes.length - 1];
      solution.setZeroes(param);
      System.out.println(Arrays.deepToString(param));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void setZeroes(int[][] matrix) {
      Boolean isCol = false;
      int m = matrix.length;
      int n = matrix[0].length;
      for (int i = 0; i < m; i++) {
        if (matrix[i][0] == 0) {
          isCol = true;
        }
        for (int j = 1; j < n; j++) {
          if (matrix[i][j] == 0) {
            matrix[0][j] = 0;
            matrix[i][0] = 0;
          }
        }
      }

      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          if (matrix[i][0] == 0 || matrix[0][j] == 0) {
            matrix[i][j] = 0;
          }
        }
      }

      // See if the first row needs to be set to zero as well
      if (matrix[0][0] == 0) {
        for (int j = 0; j < n; j++) {
          matrix[0][j] = 0;
        }
      }

      // See if the first column needs to be set to zero as well
      if (isCol) {
        for (int i = 0; i < m; i++) {
          matrix[i][0] = 0;
        }
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
