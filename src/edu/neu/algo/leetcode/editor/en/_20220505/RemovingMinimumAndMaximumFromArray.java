package edu.neu.algo.leetcode.editor.en._20220505;

public class RemovingMinimumAndMaximumFromArray {

  // You are given a 0-indexed array of distinct integers nums.
  //
  // There is an element in nums that has the lowest value and an element that
  // has the highest value. We call them the minimum and maximum respectively. Your
  // goal is to remove both these elements from the array.
  //
  // A deletion is defined as either removing an element from the front of the
  // array or removing an element from the back of the array.
  //
  // Return the minimum number of deletions it would take to remove both the
  // minimum and maximum element from the array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [2,10,7,5,4,1,8,6]
  // Output: 5
  // Explanation:
  // The minimum element in the array is nums[5], which is 1.
  // The maximum element in the array is nums[1], which is 10.
  // We can remove both the minimum and maximum by removing 2 elements from the
  // front and 3 elements from the back.
  // This results in 2 + 3 = 5 deletions, which is the minimum number possible.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [0,-4,19,1,8,-2,-3,5]
  // Output: 3
  // Explanation:
  // The minimum element in the array is nums[1], which is -4.
  // The maximum element in the array is nums[2], which is 19.
  // We can remove both the minimum and maximum by removing 3 elements from the
  // front.
  // This results in only 3 deletions, which is the minimum number possible.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [101]
  // Output: 1
  // Explanation:
  // There is only one element in the array, which makes it both the minimum and
  // maximum element.
  // We can remove it with 1 deletion.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // -10⁵ <= nums[i] <= 10⁵
  // The integers in nums are distinct.
  //
  // Related Topics Array Greedy 👍 332 👎 17

  public static void main(String[] args) {
    Solution solution = new RemovingMinimumAndMaximumFromArray().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minimumDeletions(int[] nums) {
      if (nums.length < 3) {
        return nums.length;
      }
      int res;
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      int minIndex = 0, maxIndex = 0;
      for (int i = 0; i < nums.length; i++) {
        if (min > nums[i]) {
          min = nums[i];
          minIndex = i;
        }
        if (max < nums[i]) {
          max = nums[i];
          maxIndex = i;
        }
      }

      // 1. 0 min max len-1
      // 2. 0 max min len-1
      int right = Math.max(maxIndex, minIndex);
      int left = Math.min(minIndex, maxIndex);

      // 从左侧开始删 + 从右侧开始删
      // 全部从左侧删 right
      // 全部从右侧删
      res = Math.min(right + 1, nums.length - left);
      res = Math.min(res, left + nums.length - right + 1);
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
