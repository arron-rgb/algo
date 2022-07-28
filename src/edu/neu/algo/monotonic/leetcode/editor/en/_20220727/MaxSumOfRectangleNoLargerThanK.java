package edu.neu.algo.monotonic.leetcode.editor.en._20220727;

import edu.neu.util.InputUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

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
  // 2042 👎 110

  public static void main(String[] args) {
    BruteSolution solution = new MaxSumOfRectangleNoLargerThanK().new BruteSolution();
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
      int ans = Integer.MIN_VALUE;
      int m = matrix.length, n = matrix[0].length;
      for (int i = 0; i < m; ++i) { // 枚举上边界
        int[] sum = new int[n];
        for (int j = i; j < m; ++j) { // 枚举下边界
          for (int c = 0; c < n; ++c) {
            sum[c] += matrix[j][c]; // 更新每列的元素和
          }
          TreeSet<Integer> sumSet = new TreeSet<>();
          sumSet.add(0);
          int s = 0;
          for (int v : sum) {
            s += v;
            Integer ceil = sumSet.ceiling(s - k);
            if (ceil != null) {
              ans = Math.max(ans, s - ceil);
            }
            sumSet.add(s);
          }
        }
      }
      return ans;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class BruteSolution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
      int m = matrix.length;
      int n = matrix[0].length;
      int[][] prefixSum = new int[m + 1][n + 1];
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
        }
      }
      int res = Integer.MIN_VALUE;
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          for (int i0 = 0; i0 < i; i0++) {
            for (int j0 = 0; j0 < j; j0++) {
              int sum = prefixSum[i][j] - prefixSum[i0][j] - prefixSum[i][j0] + prefixSum[i0][j0];
              if (sum <= k) {
                res = Math.max(res, sum);
              }
            }
          }
        }
      }
      return res;
    }
  }

}
