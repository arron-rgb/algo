package edu.neu.algo.review.leetcode.editor.en._20220724;

import java.util.*;
import edu.neu.util.InputUtil;

public class SearchA2DMatrixII {
  // 240
  // Write an efficient algorithm that searches for a value target in an m x n
  // integer matrix matrix. This matrix has the following properties:
  //
  //
  // Integers in each row are sorted in ascending from left to right.
  // Integers in each column are sorted in ascending from top to bottom.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
  // 8,21,23,26,30]], target = 5
  // Output: true
  //
  //
  // Example 2:
  //
  //
  // Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
  // 8,21,23,26,30]], target = 20
  // Output: false
  //
  //
  //
  // Constraints:
  //
  //
  // m == matrix.length
  // n == matrix[i].length
  // 1 <= n, m <= 300
  // -10⁹ <= matrix[i][j] <= 10⁹
  // All the integers in each row are sorted in ascending order.
  // All the integers in each column are sorted in ascending order.
  // -10⁹ <= target <= 10⁹
  //
  // Related Topics Array Binary Search Divide and Conquer Matrix 👍 8142 👎 135

  public static void main(String[] args) {
    Solution solution = new SearchA2DMatrixII().new Solution();
    String[] data = """
          [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
      5
      [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
      20
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.searchMatrix((int[][])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // todo 左下、右上和左上、右下区别

    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length;
      int n = matrix[0].length;
      int i = m - 1, j = 0;
      while (i >= 0 && j < n) {
        if (matrix[i][j] == target) {
          return true;
        } else if (matrix[i][j] > target) {
          i--;
        } else {
          j++;
        }
      }
      return false;
    }
  }
  // runtime:5 ms
  // memory:48.1 MB
  // leetcode submit region end(Prohibit modification and deletion)

}
