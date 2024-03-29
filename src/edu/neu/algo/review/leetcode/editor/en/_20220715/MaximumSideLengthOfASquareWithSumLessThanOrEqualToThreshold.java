package edu.neu.algo.review.leetcode.editor.en._20220715;

import edu.neu.util.InputUtil;

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
  // 1292
  // Given a m x n matrix mat and an integer threshold, return the maximum side-
  // length of a square with a sum less than or equal to threshold or return 0 if there
  // is no such square.
  //
  //
  // Example 1:
  //
  //
  // Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
  // Output: 2
  // Explanation: The maximum side length of square with sum less than 4 is 2 as
  // shown.
  //
  //
  // Example 2:
  //
  //
  // Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]],
  // threshold = 1
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // m == mat.length
  // n == mat[i].length
  // 1 <= m, n <= 300
  // 0 <= mat[i][j] <= 10⁴
  // 0 <= threshold <= 10⁵
  //
  // Related Topics Array Binary Search Matrix Prefix Sum 👍 837 👎 72

  public static void main(String[] args) {
    MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold a =
      new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();
    Solution solution = a.new Solution();
    String[] data =
      """
        [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]
        4
        [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]]
        1
        [[28,39,98,91,7,99],[79,3,17,83,9,92],[81,73,42,27,67,70],[88,30,73,99,96,89],[27,59,0,1,65,79],[42,55,48,29,86,96]]
        24829
        [[2,2,2],[3,3,3],[4,4,4]]
        13
        [[2,2,2],[3,3,3],[4,4,4]]
        13
        [[2,2,2],[3,3,3],[4,4,4]]
        5
        [[2,2,2],[3,3,3],[4,4,4]]
        15
        [[2,2,2],[3,3,3],[4,4,4]]
        28
              """
        .trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[][], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxSideLength((int[][])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q + ": "
        + a.largestSubgrid((int[][])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
      int m = mat.length;
      int n = mat[0].length;
      int right = Math.min(m, n);
      int[][] prefixSum = new int[m + 1][n + 1];
      int min = Integer.MAX_VALUE;
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (i == 1) {
            prefixSum[i][j] = prefixSum[i][j - 1] + mat[i - 1][j - 1];
          } else if (j == 1) {
            prefixSum[i][j] = prefixSum[i - 1][j] + mat[i - 1][j - 1];
          } else {
            prefixSum[i][j] = -prefixSum[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] + mat[i - 1][j - 1];
          }
          min = Math.min(min, mat[i - 1][j - 1]);
        }
      }
      int left = 0;
      while (left < right) {
        int mid = left + (right - left + 1) / 2;
        // 这题取右边界
        if (check(mid, prefixSum, threshold)) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      return left;
    }

    private boolean check(int len, int[][] prefixSum, int th) {
      for (int i = len; i < prefixSum.length; i++) {
        // find a point act as the right-bottom point of a square
        // then the sum is prefixSum[]
        for (int j = len; j < prefixSum[0].length; j++) {
          if (prefixSum[i][j] - prefixSum[i - len][j] - prefixSum[i][j - len] + prefixSum[i - len][j - len] <= th) {
            return true;
          }
        }
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  // [0, 0, 0, 0, 0, 0, 0, 0],
  // [0, 1, 2, 5, 7, 11, 14, 16],
  // [0, 2, 4, 10, 14, 22, 28, 32],
  // [0, 3, 6, 15, 21, 33, 42, 48]
  int largestSubgrid(int[][] grid, int maxSum) {
    int n = grid.length;
    int[][] sum = new int[n][n];
    int mx = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          sum[0][0] = grid[0][0];
        } else if (i == 0) {
          sum[0][j] = sum[0][j - 1] + grid[0][j];
        } else if (j == 0) {
          sum[i][0] = sum[i - 1][0] + grid[i][0];
        } else {
          sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + grid[i][j] - sum[i - 1][j - 1];
        }
        mx = Math.max(mx, grid[i][j]);
        // cout << sum[i][j] <<' ';
      }
      // cout <<endl;
    }
    // if(maxSum < mx)return 0;
    // if(maxSum >= sum[n-1][n-1])return n;
    int ans = 0;
    int l = 0, r = n;
    while (l < r) {
      int x = l + (r - l + 1) / 2;
      int res = 0;
      for (int i = x - 1; i < n; i++) {
        for (int j = x - 1; j < n; j++) {
          int total = sum[i][j];
          if (i >= x)
            total -= sum[i - x][j];
          if (j >= x)
            total -= sum[i][j - x];
          if (i >= x && j >= x)
            total += sum[i - x][j - x];
          res = Math.max(res, total);
        }
      }
      if (maxSum >= res)
        l = x;
      else
        r = x - 1;
    }
    return r;
  }
}
