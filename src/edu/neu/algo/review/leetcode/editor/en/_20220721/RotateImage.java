package edu.neu.algo.review.leetcode.editor.en._20220721;

import java.util.*;
import edu.neu.util.InputUtil;

public class RotateImage {
  // 48
  // You are given an n x n 2D matrix representing an image, rotate the image by 90
  // degrees (clockwise).
  //
  // You have to rotate the image in-place, which means you have to modify the
  // input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
  //
  //
  // Example 1:
  //
  //
  // Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
  // Output: [[7,4,1],[8,5,2],[9,6,3]]
  //
  //
  // Example 2:
  //
  //
  // Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
  // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
  //
  //
  //
  // Constraints:
  //
  //
  // n == matrix.length == matrix[i].length
  // 1 <= n <= 20
  // -1000 <= matrix[i][j] <= 1000
  //
  // Related Topics Array Math Matrix 👍 10312 👎 526

  public static void main(String[] args) {
    Solution solution = new RotateImage().new Solution();
    String[] data = """
          [[1,2,3],[4,5,6],[7,8,9]]
      [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[][] param = (int[][])params[1 + i * paramTypes.length - 1];
      solution.rotate(param);
      System.out.println(Arrays.deepToString(param));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void rotate(int[][] matrix) {
      int n = matrix.length;
      for (int i = 0; i < (n + 1) / 2; i++) {
        for (int j = 0; j < n / 2; j++) {
          int temp = matrix[n - 1 - j][i];
          matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
          matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
          matrix[j][n - 1 - i] = matrix[i][j];
          matrix[i][j] = temp;
        }
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
