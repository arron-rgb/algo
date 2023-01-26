package edu.neu.algo.review.leetcode.editor.en._20221214;

import edu.neu.util.InputUtil;

public class BinarySearch {

  // Given an array of integers nums which is sorted in ascending order, and an
  // integer target, write a function to search target in nums. If target exists, then
  // return its index. Otherwise, return -1.
  //
  // You must write an algorithm with O(log n) runtime complexity.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [-1,0,3,5,9,12], target = 9
  // Output: 4
  // Explanation: 9 exists in nums and its index is 4
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [-1,0,3,5,9,12], target = 2
  // Output: -1
  // Explanation: 2 does not exist in nums so return -1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // -10⁴ < nums[i], target < 10⁴
  // All the integers in nums are unique.
  // nums is sorted in ascending order.
  //
  // Related Topics Array Binary Search 👍 7458 👎 161

  public static void main(String[] args) {
    Solution solution = new BinarySearch().new Solution();
    String[] data = """
                  [-1,0,3,5,9,12]
      9
      [-1,0,3,5,9,12]
      2
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.search((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int search(int[] nums, int target) {
      int left = 0, right = nums.length - 1;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return nums[left] == target ? left : -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
