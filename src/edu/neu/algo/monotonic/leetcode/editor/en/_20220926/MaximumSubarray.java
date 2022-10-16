package edu.neu.algo.monotonic.leetcode.editor.en._20220926;

import java.util.*;

import edu.neu.util.InputUtil;

public class MaximumSubarray {
  // 53
  // Given an integer array nums, find the contiguous subarray (containing at
  // least one number) which has the largest sum and return its sum.
  //
  // A subarray is a contiguous part of an array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
  // Output: 6
  // Explanation: [4,-1,2,1] has the largest sum = 6.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1]
  // Output: 1
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [5,4,-1,7,8]
  // Output: 23
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // -10⁴ <= nums[i] <= 10⁴
  //
  //
  //
  // Follow up: If you have figured out the O(n) solution, try coding another
  // solution using the divide and conquer approach, which is more subtle.
  // Related Topics Array Divide and Conquer Dynamic Programming 👍 25216 👎 1159

  public static void main(String[] args) {
    Solution solution = new MaximumSubarray().new Solution();
    String[] data = """
          [-2,1,-3,4,-1,2,1,-5,4]
      [1]
      [5,4,-1,7,8]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.maxSubArray((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxSubArray(int[] nums) {
      int n = nums.length;
      int pre = nums[0];
      int cur;
      int res = nums[0];
      for (int i = 1; i < n; i++) {
        cur = Math.max(pre + nums[i], nums[i]);
        res = Math.max(res, cur);
        pre = cur;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public int[] getMaxMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] prefix = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        prefix[i + 1][j + 1] = prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j] - matrix[i][j];
      }
    }

    int i0 = 0, j0 = 0, i1 = 0, j1 = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        for (int k = i; k < m; k++) {
          for (int l = j; l < n; l++) {
            int sum = recSum(i, j, k, l, prefix);
            if (sum > max) {
              max = sum;
              i0 = i;
              j0 = j;
              i1 = k;
              j1 = l;
            }
          }
        }
      }
    }

    return new int[] {i0, j0, i1, j1};
  }

  int recSum(int i1, int j1, int i2, int j2, int[][] sums) {
    return sums[i2 + 1][j2 + 1] - sums[i2 + 1][j1] - sums[i1][j2 + 1] + sums[i1][j1];
  }
}
