package edu.neu.algo.leetcode.editor.en._20220503;

public class ShortestUnsortedContinuousSubarray {

  // Given an integer array nums, you need to find one continuous subarray that if
  // you only sort this subarray in ascending order, then the whole array will be
  // sorted in ascending order.
  //
  // Return the shortest such subarray and output its length.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [2,6,4,8,10,9,15]
  // Output: 5
  // Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the
  // whole array sorted in ascending order.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3,4]
  // Output: 0
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [1]
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // -10⁵ <= nums[i] <= 10⁵
  //
  //
  //
  // Follow up: Can you solve it in O(n) time complexity? Related Topics Array Two
  // Pointers Stack Greedy Sorting Monotonic Stack 👍 5181 👎 207

  public static void main(String[] args) {
    Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
    int unsortedSubarray = solution.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15});
    System.out.println(unsortedSubarray);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findUnsortedSubarray(int[] nums) {
      int max = Integer.MIN_VALUE, right = -1;
      int min = Integer.MAX_VALUE, left = -1;
      for (int i = 0; i < nums.length; i++) {
        if (max > nums[i]) {
          right = i;
        } else {
          max = nums[i];
        }
        if (min < nums[nums.length - i - 1]) {
          left = nums.length - i - 1;
        } else {
          min = nums[nums.length - i - 1];
        }
      }
      return right == -1 ? 0 : right - left + 1;

    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
