package edu.neu.algo.dp.leetcode.editor.en._20220711;

import java.util.*;
import edu.neu.util.InputUtil;

public class CellsWithOddValuesInAMatrix {
  // 1252
  // There is an m x n matrix that is initialized to all 0's. There is also a 2D
  // array indices where each indices[i] = [ri, ci] represents a 0-indexed location to
  // perform some increment operations on the matrix.
  //
  // For each location indices[i], do both of the following:
  //
  //
  // Increment all the cells on row ri.
  // Increment all the cells on column ci.
  //
  //
  // Given m, n, and indices, return the number of odd-valued cells in the matrix
  // after applying the increment to all locations in indices.
  //
  //
  // Example 1:
  //
  //
  // Input: m = 2, n = 3, indices = [[0,1],[1,1]]
  // Output: 6
  // Explanation: Initial matrix = [[0,0,0],[0,0,0]].
  // After applying first increment it becomes [[1,2,1],[0,1,0]].
  // The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
  //
  //
  // Example 2:
  //
  //
  // Input: m = 2, n = 2, indices = [[1,1],[0,0]]
  // Output: 0
  // Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the
  // final matrix.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= m, n <= 50
  // 1 <= indices.length <= 100
  // 0 <= ri < m
  // 0 <= ci < n
  //
  //
  //
  // Follow up: Could you solve this in O(n + m + indices.length) time with only
  // O(n + m) extra space?
  // Related Topics Array Math Simulation 👍 791 👎 1161

  public static void main(String[] args) {
    Solution solution = new CellsWithOddValuesInAMatrix().new Solution();
    String[] data = """
          2
      3
      [[0,1],[1,1]]
      2
      2
      [[1,1],[0,0]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int, int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.oddCells((int)params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1],
        (int[][])params[3 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int oddCells(int m, int n, int[][] indices) {
      int[] row = new int[m];
      int[] col = new int[n];
      for (int[] index : indices) {
        row[index[0]]++;
        col[index[1]]++;
      }
      int count = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          int tmp = row[i] + col[j];
          if ((tmp & 1) == 1) {
            count++;
          }
        }
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
