package edu.neu.algo.review.leetcode.editor.en._20230216;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class CountSubarraysWithFixedBounds {
  // 2444
  // You are given an integer array nums and two integers minK and maxK.
  //
  // A fixed-bound subarray of nums is a subarray that satisfies the following
  // conditions:
  //
  //
  // The minimum value in the subarray is equal to minK.
  // The maximum value in the subarray is equal to maxK.
  //
  //
  // Return the number of fixed-bound subarrays.
  //
  // A subarray is a contiguous part of an array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
  // Output: 2
  // Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,1,1,1], minK = 1, maxK = 1
  // Output: 10
  // Explanation: Every subarray of nums is a fixed-bound subarray. There are 10
  // possible subarrays.
  //
  //
  //
  // Constraints:
  //
  //
  // 2 <= nums.length <= 10⁵
  // 1 <= nums[i], minK, maxK <= 10⁶
  //
  //
  // Related Topics Array Queue Sliding Window Monotonic Queue 👍 601 👎 11

  public static void main(String[] args) {
    Solution solution = new CountSubarraysWithFixedBounds().new Solution();
    String[] data = """
                  [1,3,5,2,7,5]
      1
      5
      [1,1,1,1]
      1
      1
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      long q = solution.countSubarrays((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length], (int)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
      return 0l;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
