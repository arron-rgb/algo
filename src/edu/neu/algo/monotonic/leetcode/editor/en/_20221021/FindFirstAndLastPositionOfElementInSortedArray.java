package edu.neu.algo.monotonic.leetcode.editor.en._20221021;

import java.util.*;
import edu.neu.util.InputUtil;

public class FindFirstAndLastPositionOfElementInSortedArray {
  // 34
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
  // Related Topics Array Binary Search 👍 14381 👎 353

  public static void main(String[] args) {
    Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    String[] data = """
          [5,7,7,8,8,10]
      8
      [5,7,7,8,8,10]
      6
      []
      0
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q =
        solution.searchRange((int[])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(Arrays.toString(q));
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] searchRange(int[] nums, int target) {
      return null;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
