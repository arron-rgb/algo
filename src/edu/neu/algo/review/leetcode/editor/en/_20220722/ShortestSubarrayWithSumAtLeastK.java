package edu.neu.algo.review.leetcode.editor.en._20220722;

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
  // Prefix Sum Monotonic Queue 👍 3103 👎 79

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
      int n = nums.length;
      long[] prefix = new long[n + 1];
      for (int i = 1; i < prefix.length; i++) {
        prefix[i] = prefix[i - 1] + nums[i - 1];
      }
      Deque<Integer> deque = new ArrayDeque<>();
      int res = n + 1;
      for (int i = 0; i <= n; i++) {

        while (!deque.isEmpty() && prefix[deque.peekLast()] >= prefix[i]) {
          deque.pollLast();
        }
        while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
          res = Math.min(res, i - deque.pollFirst());
        }
        deque.offerLast(i);
      }
      return res < n + 1 ? res : -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
