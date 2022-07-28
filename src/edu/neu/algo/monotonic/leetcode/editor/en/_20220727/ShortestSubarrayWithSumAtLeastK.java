package edu.neu.algo.monotonic.leetcode.editor.en._20220727;

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
  // Prefix Sum Monotonic Queue 👍 3117 👎 81

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
      int q = solution.shortestSubarray((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int shortestSubarray(int[] nums, int k) {
      int n = nums.length;
      int res = n + 1;
      long[] prefix = new long[res];
      for (int i = 1; i <= n; i++) {
        prefix[i] = prefix[i - 1] + nums[i - 1];
      }
      Deque<Integer> deque = new ArrayDeque<>();
      for (int i = 0; i < prefix.length; i++) {
        // 保证窗口单调
        while (!deque.isEmpty() && prefix[deque.peekLast()] >= prefix[i]) {
          deque.pollLast();
        }
        // 满足条件的答案
        // 尝试删除一个能否仍然满足条件
        // 如果可以则移除一个
        while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
          res = Math.min(res, i - deque.pollFirst());
        }
        deque.offerLast(i);
      }
      return res == n + 1 ? -1 : res;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class WrongSolution {
    // 本题没法二分

    // [84,-37,32,40,95]
    // 167
    // 长度为4，没满足条件的
    // 长度为3 sum[32, 40, 95] >= 167
    public int shortestSubarray(int[] nums, int k) {
      int n = nums.length;
      long[] prefix = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        prefix[i] = prefix[i - 1] + nums[i - 1];
      }
      int left = 0, right = n;
      while (left < right) {
        int mid = left + (right - left) / 2;
        System.out.println(mid + ": " + left + ", " + right);
        if (validate(prefix, k, mid)) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      return validate(prefix, k, left) ? left : -1;
    }

    boolean validate(long[] prefix, int k, int mid) {
      for (int i = 0; i < prefix.length - mid; i++) {
        if (prefix[i + mid] - prefix[i] >= k) {
          return true;
        }
      }
      return false;
    }
  }

}
