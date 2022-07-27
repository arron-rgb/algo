package edu.neu.algo.review.leetcode.editor.en._20220724;

import java.util.*;
import edu.neu.util.InputUtil;

public class SearchA2DMatrix {
  // 74
  // Write an efficient algorithm that searches for a value target in an m x n
  // integer matrix matrix. This matrix has the following properties:
  //
  //
  // Integers in each row are sorted from left to right.
  // The first integer of each row is greater than the last integer of the
  // previous row.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
  // Output: true
  //
  //
  // Example 2:
  //
  //
  // Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
  // Output: false
  //
  //
  //
  // Constraints:
  //
  //
  // m == matrix.length
  // n == matrix[i].length
  // 1 <= m, n <= 100
  // -10⁴ <= matrix[i][j], target <= 10⁴
  //
  // Related Topics Array Binary Search Matrix 👍 8629 👎 290

  public static void main(String[] args) {
    Solution solution = new SearchA2DMatrix().new Solution();
    String[] data = """
      [[1]]
      1
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
    public boolean searchMatrix(int[][] matrix, int target) {
      int rowIndex = binarySearchFirstColumn(matrix, target);
      if (rowIndex < 0) {
        return false;
      }
      return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
      int low = -1, high = matrix.length - 1;
      while (low < high) {
        int mid = (high - low + 1) / 2 + low;
        if (matrix[mid][0] <= target) {
          low = mid;
        } else {
          high = mid - 1;
        }
      }
      return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
      int low = 0, high = row.length - 1;
      while (low <= high) {
        int mid = (high - low) / 2 + low;
        if (row[mid] == target) {
          return true;
        } else if (row[mid] > target) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      return false;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class SimpleSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length;
      int n = matrix[0].length;
      int left = 0, right = m * n - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (matrix[mid / n][mid % n] == target) {
          return true;
        } else if (matrix[mid / n][mid % n] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return false;
    }
  }
}
