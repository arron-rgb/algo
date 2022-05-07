package edu.neu.algo.leetcode.editor.en._20220507;

import java.util.ArrayDeque;
import java.util.Deque;

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
  // Related Topics Array Binary Search Stack Monotonic Stack Ordered Set 👍 4291
  // 👎 231

  public static void main(String[] args) {
    Solution solution = new One32Pattern().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean find132pattern(int[] nums) {
      Deque<Integer> deque = new ArrayDeque<>();
      int n = nums.length;
      int max = Integer.MIN_VALUE;
      for (int i = n - 1; i >= 0; i--) {
        if (nums[i] < max) {
          return true;
        }
        while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
          max = Math.max(max, deque.pollLast());
        }
        deque.offerLast(nums[i]);
      }
      // find 3
      // if has one loop all could act as 2

      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
