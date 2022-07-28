package edu.neu.algo.monotonic.leetcode.editor.en._20220727;

import java.util.*;
import edu.neu.util.InputUtil;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
  // 1438
  // Given an array of integers nums and an integer limit, return the size of the
  // longest non-empty subarray such that the absolute difference between any two
  // elements of this subarray is less than or equal to limit.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [8,2,4,7], limit = 4
  // Output: 2
  // Explanation: All subarrays are:
  // [8] with maximum absolute diff |8-8| = 0 <= 4.
  // [8,2] with maximum absolute diff |8-2| = 6 > 4.
  // [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
  // [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
  // [2] with maximum absolute diff |2-2| = 0 <= 4.
  // [2,4] with maximum absolute diff |2-4| = 2 <= 4.
  // [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
  // [4] with maximum absolute diff |4-4| = 0 <= 4.
  // [4,7] with maximum absolute diff |4-7| = 3 <= 4.
  // [7] with maximum absolute diff |7-7| = 0 <= 4.
  // Therefore, the size of the longest subarray is 2.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [10,1,2,4,7,2], limit = 5
  // Output: 4
  // Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute
  // diff is |2-7| = 5 <= 5.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [4,2,2,2,4,4,2,2], limit = 0
  // Output: 3
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // 1 <= nums[i] <= 10⁹
  // 0 <= limit <= 10⁹
  //
  // Related Topics Array Queue Sliding Window Heap (Priority Queue) Ordered Set
  // Monotonic Queue 👍 2401 👎 97

  public static void main(String[] args) {
    Solution solution = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
    String[] data = """
          [8,2,4,7]
      4
      [10,1,2,4,7,2]
      5
      [4,2,2,2,4,4,2,2]
      0
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.longestSubarray((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestSubarray(int[] nums, int limit) {
      Deque<Integer> maxQ = new ArrayDeque<>();
      Deque<Integer> minQ = new ArrayDeque<>();
      int l = 0;
      int r = 0;
      for (; r < nums.length; r++) {
        // Monotonic increase and decreasing queue
        while (!maxQ.isEmpty() && maxQ.peekLast() < nums[r]) {
          maxQ.pollLast();
        }
        while (!minQ.isEmpty() && minQ.peekLast() > nums[r]) {
          minQ.pollLast();
        }
        minQ.add(nums[r]);
        maxQ.add(nums[r]);
        if (maxQ.peekFirst() - minQ.peekFirst() > limit) {
          if (maxQ.peekFirst() == nums[l]) {
            maxQ.pollFirst();
          }
          if (minQ.peekFirst() == nums[l]) {
            minQ.pollFirst();
          }
          l++;
        }
      }
      return r - l;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
