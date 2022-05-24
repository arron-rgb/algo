package edu.neu.algo.leetcode.editor.en._20220517;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  // Given an m x n matrix, return all elements of the matrix in spiral order.
  //
  //
  // Example 1:
  //
  //
  // Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
  // Output: [1,2,3,6,9,8,7,4,5]
  //
  //
  // Example 2:
  //
  //
  // Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
  // Output: [1,2,3,4,8,12,11,10,9,5,6,7]
  //
  //
  //
  // Constraints:
  //
  //
  // m == matrix.length
  // n == matrix[i].length
  // 1 <= m, n <= 10
  // -100 <= matrix[i][j] <= 100
  //
  // Related Topics Array Matrix Simulation 👍 7172 👎 839

  public static void main(String[] args) {
    Solution solution = new SpiralMatrix().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

      List<Integer> res = new ArrayList<>();

      if (matrix.length == 0) {
        return res;
      }

      int row = 0;
      int rowEnd = matrix.length - 1;
      int col = 0;
      int colEnd = matrix[0].length - 1;

      while (row <= rowEnd && col <= colEnd) {
        // Traverse Right
        for (int j = col; j <= colEnd; j++) {
          res.add(matrix[row][j]);
        }
        row++;

        // Traverse Down
        for (int j = row; j <= rowEnd; j++) {
          res.add(matrix[j][colEnd]);
        }
        colEnd--;

        if (row <= rowEnd) {
          // Traverse Left
          for (int j = colEnd; j >= col; j--) {
            res.add(matrix[rowEnd][j]);
          }
        }
        rowEnd--;

        if (col <= colEnd) {
          // Traver Up
          for (int j = rowEnd; j >= row; j--) {
            res.add(matrix[j][col]);
          }
        }
        col++;
      }

      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
