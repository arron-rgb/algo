package edu.neu.algo.review.leetcode.editor.en._20220722;

import java.util.*;
import edu.neu.util.InputUtil;

public class JumpGameVI {
  // 1696
  // You are given a 0-indexed integer array nums and an integer k.
  //
  // You are initially standing at index 0. In one move, you can jump at most k
  // steps forward without going outside the boundaries of the array. That is, you can
  // jump from index i to any index in the range [i + 1, min(n - 1, i + k)]
  // inclusive.
  //
  // You want to reach the last index of the array (index n - 1). Your score is
  // the sum of all nums[j] for each index j you visited in the array.
  //
  // Return the maximum score you can get.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,-1,-2,4,-7,3], k = 2
  // Output: 7
  // Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (
  // underlined above). The sum is 7.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [10,-5,-2,4,0,3], k = 3
  // Output: 17
  // Explanation: You can choose your jumps forming the subsequence [10,4,3] (
  // underlined above). The sum is 17.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length, k <= 10⁵
  // -10⁴ <= nums[i] <= 10⁴
  //
  // Related Topics Array Dynamic Programming Queue Sliding Window Heap (Priority
  // Queue) Monotonic Queue 👍 2728 👎 92

  public static void main(String[] args) {
    Solution solution = new JumpGameVI().new Solution();
    String[] data = """
          [1,-1,-2,4,-7,3]
      2
      [10,-5,-2,4,0,3]
      3
      [1,-5,-20,4,-1,3,-6,-3]
      2
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.maxResult((int[])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxResult(int[] nums, int k) {

    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
