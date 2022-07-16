package edu.neu.algo.review.leetcode.editor.en._20220715;

import java.util.*;
import edu.neu.util.InputUtil;

public class FindTheSmallestDivisorGivenAThreshold {
  // 1283
  // Given an array of integers nums and an integer threshold, we will choose a
  // positive integer divisor, divide all the array by it, and sum the division's
  // result. Find the smallest divisor such that the result mentioned above is less than
  // or equal to threshold.
  //
  // Each result of the division is rounded to the nearest integer greater than
  // or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
  //
  // The test cases are generated so that there will be an answer.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,5,9], threshold = 6
  // Output: 5
  // Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
  // If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5
  // the sum will be 5 (1+1+1+2).
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [44,22,33,11,1], threshold = 5
  // Output: 44
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 5 * 10⁴
  // 1 <= nums[i] <= 10⁶
  // nums.length <= threshold <= 10⁶
  //
  // Related Topics Array Binary Search 👍 1525 👎 157

  public static void main(String[] args) {
    Solution solution = new FindTheSmallestDivisorGivenAThreshold().new Solution();
    String[] data = """
          [1,2,5,9]
      6
      [44,22,33,11,1]
      5
      [21212,10101,12121]
      1000000
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.smallestDivisor((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
      int left = 1, right = Integer.MIN_VALUE;
      for (int num : nums) {
        // left = Math.min(left, num);
        right = Math.max(right, num);
      }
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (check(mid, nums, threshold)) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      return left;
    }

    private boolean check(int divisor, int[] nums, int threshold) {
      int sum = 0;
      for (int num : nums) {
        sum += (num + divisor - 1) / divisor;
      }
      // System.out.println(divisor + " " + sum);
      return sum <= threshold;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
