package edu.neu.algo.dp.leetcode.editor.en._20220714;

import java.util.*;
import edu.neu.util.InputUtil;

public class ShortestSubarrayWithSumAtLeastK {
  // 862
  // Given an integer array nums and an integer k, return the length of the
  // shortest non-empty subarray of nums with a sum of at least k. If there is no such
  // subarray, return -1.
  //
  // A subarray is a contiguous part of an array.
  //
  //
  // Example 1:
  // Input: nums = [1], k = 1
  // Output: 1
  // Example 2:
  // Input: nums = [1,2], k = 4
  // Output: -1
  // Example 3:
  // Input: nums = [2,-1,2], k = 3
  // Output: 3
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // -10⁵ <= nums[i] <= 10⁵
  // 1 <= k <= 10⁹
  //
  // Related Topics Array Binary Search Queue Sliding Window Heap (Priority Queue)
  // Prefix Sum Monotonic Queue 👍 3070 👎 78

  public static void main(String[] args) {
    Solution solution = new ShortestSubarrayWithSumAtLeastK().new Solution();
    String[] data = """
          [1]
      1
      [1,2]
      4
      [2,-1,2]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.shortestSubarray((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int shortestSubarray(int[] nums, int k) {
      // todo
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
