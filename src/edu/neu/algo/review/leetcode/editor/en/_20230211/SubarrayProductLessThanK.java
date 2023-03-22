package edu.neu.algo.review.leetcode.editor.en._20230211;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class SubarrayProductLessThanK {
  // 713
  // Given an array of integers nums and an integer k, return the number of
  // contiguous subarrays where the product of all the elements in the subarray is strictly
  // less than k.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [10,5,2,6], k = 100
  // Output: 8
  // Explanation: The 8 subarrays that have product less than 100 are:
  // [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
  // Note that [10, 5, 2] is not included as the product of 100 is not strictly
  // less than k.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3], k = 0
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 3 * 10⁴
  // 1 <= nums[i] <= 1000
  // 0 <= k <= 10⁶
  //
  //
  // Related Topics Array Sliding Window 👍 5069 👎 161

  public static void main(String[] args) {
    Solution solution = new SubarrayProductLessThanK().new Solution();
    String[] data = """
                  [10,5,2,6]
      100
      [1,2,3]
      0
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numSubarrayProductLessThanK((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
      if (k <= 1) {
        return 0;
      }
      int left = 0, n = nums.length;
      int prod = 1;
      int res = 0;
      for (int right = 0; right < n; right++) {
        prod *= nums[right];
        while (prod >= k) {
          prod /= nums[left];
          left++;
        }
        // 长度为几就有几种可能
        // 所以res+窗口大小
        res += (right - left + 1);
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
