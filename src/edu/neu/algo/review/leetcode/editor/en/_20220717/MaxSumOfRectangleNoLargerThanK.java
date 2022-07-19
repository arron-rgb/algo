package edu.neu.algo.review.leetcode.editor.en._20220717;

import java.util.*;
import edu.neu.util.InputUtil;

public class MaxSumOfRectangleNoLargerThanK {
  // 363
  // Given an m x n matrix matrix and an integer k, return the max sum of a
  // rectangle in the matrix such that its sum is no larger than k.
  //
  // It is guaranteed that there will be a rectangle with a sum no larger than k.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: matrix = [[1,0,1],[0,-2,3]], k = 2
  // Output: 2
  // Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2,
  // and 2 is the max number no larger than k (k = 2).
  //
  //
  // Example 2:
  //
  //
  // Input: matrix = [[2,2,-1]], k = 3
  // Output: 3
  //
  //
  //
  // Constraints:
  //
  //
  // m == matrix.length
  // n == matrix[i].length
  // 1 <= m, n <= 100
  // -100 <= matrix[i][j] <= 100
  // -10⁵ <= k <= 10⁵
  //
  //
  //
  // Follow up: What if the number of rows is much larger than the number of
  // columns?
  // Related Topics Array Binary Search Dynamic Programming Matrix Ordered Set 👍
  // 2000 👎 109

  public static void main(String[] args) {
    Solution solution = new MaxSumOfRectangleNoLargerThanK().new Solution();
    String[] data = """
          [[1,0,1],[0,-2,3]]
      2
      [[2,2,-1]]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxSumSubmatrix((int[][])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
      return -1;// todo
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
