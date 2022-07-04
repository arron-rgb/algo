package edu.neu.algo.dp.leetcode.editor.en._20220704;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class SquaresOfASortedArray {
  // 977
  // Given an integer array nums sorted in non-decreasing order, return an array
  // of the squares of each number sorted in non-decreasing order.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [-4,-1,0,3,10]
  // Output: [0,1,9,16,100]
  // Explanation: After squaring, the array becomes [16,1,0,9,100].
  // After sorting, it becomes [0,1,9,16,100].
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [-7,-3,2,3,11]
  // Output: [4,9,9,49,121]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // -10⁴ <= nums[i] <= 10⁴
  // nums is sorted in non-decreasing order.
  //
  //
  //
  // Follow up: Squaring each element and sorting the new array is very trivial,
  // could you find an O(n) solution using a different approach? Related Topics Array
  // Two Pointers Sorting 👍 5733 👎 159

  public static void main(String[] args) {
    Solution solution = new SquaresOfASortedArray().new Solution();
    String[] data = """
          [-4,-1,0,3,10]
      [-7,-3,2,3,11]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.sortedSquares((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] sortedSquares(int[] nums) {
      int[] res = new int[nums.length];
      int left = 0, right = nums.length - 1;
      int index = nums.length - 1;
      while (index >= 0) {
        if (Math.abs(nums[left]) < Math.abs(nums[right])) {
          res[index] = nums[right] * nums[right];
          right--;
        } else {
          res[index] = nums[left] * nums[left];
          left++;
        }
        index--;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
