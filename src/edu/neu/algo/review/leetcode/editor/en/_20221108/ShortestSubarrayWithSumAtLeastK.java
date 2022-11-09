package edu.neu.algo.review.leetcode.editor.en._20221108;

import edu.neu.util.InputUtil;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {

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
  // Prefix Sum Monotonic Queue 👍 3462 👎 92

  public static void main(String[] args) {
    Solution solution = new ShortestSubarrayWithSumAtLeastK().new Solution();
    String[] data = """
      [84,-37,32,40,95]
      167
      """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.shortestSubarray((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int shortestSubarray(int[] nums, int k) {
      int n = nums.length;
      long[] preSumArr = new long[n + 1];
      for (int i = 0; i < n; i++) {
        preSumArr[i + 1] = preSumArr[i] + nums[i];
      }
      int res = n + 1;
      // 单调队列使用场景：求满足某种要求的最小区间或区间内的最小最大值
      Deque<Integer> queue = new ArrayDeque<>();
      for (int i = 0; i <= n; i++) {
        long curSum = preSumArr[i];
        // 如果当前数加起来，开始缩小边界仍然能够满足条件，则更新res
        while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
          // queue里存放索引
          res = Math.min(res, i - queue.pollFirst());
        }
        // [1,3,10] 进来一个7
        // 如果前面一个数的前缀和比加上当前数还大，则考虑以当前数为尾部
        while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
          queue.pollLast();
        }
        queue.offerLast(i);
      }
      return res < n + 1 ? res : -1;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
