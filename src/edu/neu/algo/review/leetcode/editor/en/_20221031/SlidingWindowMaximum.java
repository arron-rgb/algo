package edu.neu.algo.review.leetcode.editor.en._20221031;

import java.util.*;
import edu.neu.util.InputUtil;

public class SlidingWindowMaximum {
  // 239
  // You are given an array of integers nums, there is a sliding window of size k
  // which is moving from the very left of the array to the very right. You can only
  // see the k numbers in the window. Each time the sliding window moves right by one
  // position.
  //
  // Return the max sliding window.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
  // Output: [3,3,5,5,6,7]
  // Explanation:
  // Window position Max
  // --------------- -----
  // [1 3 -1] -3 5 3 6 7 3
  // 1 [3 -1 -3] 5 3 6 7 3
  // 1 3 [-1 -3 5] 3 6 7 5
  // 1 3 -1 [-3 5 3] 6 7 5
  // 1 3 -1 -3 [5 3 6] 7 6
  // 1 3 -1 -3 5 [3 6 7] 7
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1], k = 1
  // Output: [1]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // -10⁴ <= nums[i] <= 10⁴
  // 1 <= k <= nums.length
  //
  // Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic
  // Queue 👍 12612 👎 407

  public static void main(String[] args) {
    Solution solution = new SlidingWindowMaximum().new Solution();
    String[] data = """
      [1,-1]
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.maxSlidingWindow((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      Deque<Integer> queue = new ArrayDeque<>();
      int n = nums.length;
      int[] res = new int[n - k + 1];
      for (int i = 0; i < n; i++) {
        // 维护窗口
        while (!queue.isEmpty() && i - queue.peekFirst() >= k) {
          queue.pollFirst();
        }

        // 维护单调队列
        while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
          queue.pollLast();
        }
        queue.addLast(i);
        if (i - k + 1 >= 0) {
          res[i - k + 1] = nums[queue.peekFirst()];
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
