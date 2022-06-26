package edu.neu.algo.leetcode.editor.en._20220626;

import edu.neu.util.InputUtil;

public class RotateArray {

  // Given an array, rotate the array to the right by k steps, where k is non-
  // negative.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3,4,5,6,7], k = 3
  // Output: [5,6,7,1,2,3,4]
  // Explanation:
  // rotate 1 steps to the right: [7,1,2,3,4,5,6]
  // rotate 2 steps to the right: [6,7,1,2,3,4,5]
  // rotate 3 steps to the right: [5,6,7,1,2,3,4]
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [-1,-100,3,99], k = 2
  // Output: [3,99,-1,-100]
  // Explanation:
  // rotate 1 steps to the right: [99,-1,-100,3]
  // rotate 2 steps to the right: [3,99,-1,-100]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // -2³¹ <= nums[i] <= 2³¹ - 1
  // 0 <= k <= 10⁵
  //
  //
  //
  // Follow up:
  //
  //
  // Try to come up with as many solutions as you can. There are at least three
  // different ways to solve this problem.
  // Could you do it in-place with O(1) extra space?
  //
  // Related Topics Array Math Two Pointers 👍 9909 👎 1333

  public static void main(String[] args) {
    Solution solution = new RotateArray().new Solution();
    String[] data = """
          [1,2,3]
      1
          [1,2,3,4,5,6,7]
      3
      [-1,-100,3,99]
      2
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      solution.rotate((int[])params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void rotate(int[] nums, int k) {
      k %= nums.length;
      reverse(nums, 0, nums.length - 1);
      reverse(nums, 0, k - 1);
      reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
      while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
