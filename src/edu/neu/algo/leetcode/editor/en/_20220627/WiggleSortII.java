package edu.neu.algo.leetcode.editor.en._20220627;

import edu.neu.util.InputUtil;

public class WiggleSortII {
  // 324
  // Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2]
  // < nums[3]....
  //
  // You may assume the input array always has a valid answer.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,5,1,1,6,4]
  // Output: [1,6,1,5,1,4]
  // Explanation: [1,4,1,5,1,6] is also accepted.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,3,2,2,3,1]
  // Output: [2,3,1,3,1,2]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 5 * 10⁴
  // 0 <= nums[i] <= 5000
  // It is guaranteed that there will be an answer for the given input nums.
  //
  //
  //
  // Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
  // Related Topics Array Divide and Conquer Sorting Quickselect 👍 2170 👎 820

  public static void main(String[] args) {
    Solution solution = new WiggleSortII().new Solution();
    String[] data = """
          [1,5,1,1,6,4]
      [1,3,2,2,3,1]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      solution.wiggleSort((int[])params[1 - 1 + i * paramTypes.length]);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void wiggleSort(int[] nums) {

    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
