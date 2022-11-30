package edu.neu.algo.review.leetcode.editor.en._20221117;

import edu.neu.util.InputUtil;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

  // Given an array of integers nums sorted in non-decreasing order, find the
  // starting and ending position of a given target value.
  //
  // If target is not found in the array, return [-1, -1].
  //
  // You must write an algorithm with O(log n) runtime complexity.
  //
  //
  // Example 1:
  // Input: nums = [5,7,7,8,8,10], target = 8
  // Output: [3,4]
  // Example 2:
  // Input: nums = [5,7,7,8,8,10], target = 6
  // Output: [-1,-1]
  // Example 3:
  // Input: nums = [], target = 0
  // Output: [-1,-1]
  //
  //
  // Constraints:
  //
  //
  // 0 <= nums.length <= 10⁵
  // -10⁹ <= nums[i] <= 10⁹
  // nums is a non-decreasing array.
  // -10⁹ <= target <= 10⁹
  //
  // Related Topics Array Binary Search 👍 14732 👎 360

  public static void main(String[] args) {
    Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    String[] data = """
                  [5,7,7,8,8,10]
      8
      [5,7,7,8,8,10]
      6
      []
      0
      [2,2]
      3
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q =
        solution.searchRange((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] searchRange(int[] nums, int target) {
      int n = nums.length;
      if (n == 0) {
        return new int[] {-1, -1};
      }

      int[] res = new int[2];
      int left = 0, right = n - 1;
      while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
          right = mid;
        } else if (nums[mid] < target) {
          left = mid + 1;
        } else {
          // target < nums[mid]
          right = mid - 1;
        }
      }
      res[0] = nums[left] == target ? left : -1;

      left = 0;
      right = n - 1;
      while (left < right) {
        int mid = (left + right + 1) / 2;
        if (nums[mid] == target) {
          // mid, target
          left = mid;
        } else if (nums[mid] < target) {
          left = mid;
        } else {
          // target < nums[mid]
          right = mid - 1;
        }
      }
      res[1] = nums[left] == target ? left : -1;
      return res;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
