package edu.neu.algo.leetcode.editor.en._20220417;

public class SearchInsertPosition {

  // Given a sorted array of distinct integers and a target value, return the
  // index if the target is found. If not, return the index where it would be if it were
  // inserted in order.
  //
  // You must write an algorithm with O(log n) runtime complexity.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,3,5,6], target = 5
  // Output: 2
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,3,5,6], target = 2
  // Output: 1
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [1,3,5,6], target = 7
  // Output: 4
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // -10⁴ <= nums[i] <= 10⁴
  // nums contains distinct values sorted in ascending order.
  // -10⁴ <= target <= 10⁴
  //
  // Related Topics Array Binary Search 👍 7442 👎 401

  public static void main(String[] args) {
    Solution solution = new SearchInsertPosition().new Solution();
    System.out.println(solution.searchInsert(new int[] {1, 3, 5, 6}, 5));
    System.out.println(solution.searchInsert(new int[] {1, 3, 5, 6}, 2));
    System.out.println(solution.searchInsert(new int[] {1, 3, 5, 6}, 7));
    System.out.println(solution.searchInsert(new int[] {1, 3, 5, 6}, 1));
    System.out.println(solution.searchInsert(new int[] {1, 3}, 2));
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int searchInsert(int[] nums, int target) {
      // int left = 0, right = nums.length - 1;
      // while (left <= right) {
      int left = 0, right = nums.length;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] > target) {
          // right = mid - 1;
          right = mid;
        } else if (nums[mid] < target) {
          left = mid + 1;
        } else {
          return mid;
        }
      }
      return left;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
