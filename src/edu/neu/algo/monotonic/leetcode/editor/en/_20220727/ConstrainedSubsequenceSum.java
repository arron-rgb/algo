package edu.neu.algo.monotonic.leetcode.editor.en._20220727;

import java.util.*;
import edu.neu.util.InputUtil;

public class ConstrainedSubsequenceSum {
  // 1425
  // Given an integer array nums and an integer k, return the maximum sum of a non-
  // empty subsequence of that array such that for every two consecutive integers in
  // the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is
  // satisfied.
  //
  // A subsequence of an array is obtained by deleting some number of elements (
  // can be zero) from the array, leaving the remaining elements in their original
  // order.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [10,2,-10,5,20], k = 2
  // Output: 37
  // Explanation: The subsequence is [10, 2, 5, 20].
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [-1,-2,-3], k = 1
  // Output: -1
  // Explanation: The subsequence must be non-empty, so we choose the largest
  // number.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [10,-2,-10,-5,20], k = 2
  // Output: 23
  // Explanation: The subsequence is [10, -2, -5, 20].
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= k <= nums.length <= 10⁵
  // -10⁴ <= nums[i] <= 10⁴
  //
  // Related Topics Array Dynamic Programming Queue Sliding Window Heap (Priority
  // Queue) Monotonic Queue 👍 894 👎 35

  public static void main(String[] args) {
    Solution solution = new ConstrainedSubsequenceSum().new Solution();
    String[] data = """
          [10,2,-10,5,20]
      2
      [-1,-2,-3]
      1
      [10,-2,-10,-5,20]
      2
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.constrainedSubsetSum((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
      int res = nums[0];
      Deque<Integer> q = new ArrayDeque<>();
      for (int i = 0; i < nums.length; ++i) {
        nums[i] += !q.isEmpty() ? q.peek() : 0;
        res = Math.max(res, nums[i]);
        while (!q.isEmpty() && nums[i] > q.peekLast()) {
          q.pollLast();
        }
        if (nums[i] > 0) {
          q.offerLast(nums[i]);
        }
        if (i >= k && !q.isEmpty() && q.peek() == nums[i - k]) {
          q.pollFirst();
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
