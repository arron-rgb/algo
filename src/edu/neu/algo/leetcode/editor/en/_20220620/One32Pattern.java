package edu.neu.algo.leetcode.editor.en._20220620;

import java.util.ArrayDeque;
import java.util.Deque;

import edu.neu.util.InputUtil;

public class One32Pattern {

  // Given an array of n integers nums, a 132 pattern is a subsequence of three
  // integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] <
  // nums[j].
  //
  // Return true if there is a 132 pattern in nums, otherwise, return false.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3,4]
  // Output: false
  // Explanation: There is no 132 pattern in the sequence.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [3,1,4,2]
  // Output: true
  // Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [-1,3,2,0]
  // Output: true
  // Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3,
  // 0] and [-1, 2, 0].
  //
  //
  //
  // Constraints:
  //
  //
  // n == nums.length
  // 1 <= n <= 2 * 10⁵
  // -10⁹ <= nums[i] <= 10⁹
  //
  // Related Topics Array Binary Search Stack Monotonic Stack Ordered Set 👍 4747
  // 👎 270

  public static void main(String[] args) {
    Solution solution = new One32Pattern().new Solution();
    String[] data = """
          [1,2,3,4]
      [3,1,4,2]
      [-1,3,2,0]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.find132pattern((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean find132pattern(int[] nums) {
      int right = Integer.MIN_VALUE;
      Deque<Integer> deque = new ArrayDeque<>();
      for (int i = nums.length - 1; i >= 0; i--) {
        // 这不是只能保证 right被更新了 right当3, nums[i]当1, 如何知道2?
        if (nums[i] < right) {
          return true;
        }
        // 1 3 2
        // right 不等于 min了 说明 deque poll过了 右边存在某个数比当前的right小
        while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
          right = Math.max(deque.pollLast(), right);
        }
        deque.offerLast(nums[i]);
        // exists a three and current
        // if (!deque.isEmpty() && nums[i] < deque.peekLast() && right != Integer.MIN_VALUE) {
        // return true;
        // }
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
