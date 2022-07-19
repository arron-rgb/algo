package edu.neu.algo.review.leetcode.editor.en._20220717;

import java.util.*;
import edu.neu.util.InputUtil;

public class MinimumMovesToEqualArrayElementsII {
  // 462
  // Given an integer array nums of size n, return the minimum number of moves
  // required to make all array elements equal.
  //
  // In one move, you can increment or decrement an element of the array by 1.
  //
  // Test cases are designed so that the answer will fit in a 32-bit integer.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3]
  // Output: 2
  // Explanation:
  // Only two moves are needed (remember each move increments or decrements one
  // element):
  // [1,2,3] => [2,2,3] => [2,2,2]
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,10,2,9]
  // Output: 16
  //
  //
  //
  // Constraints:
  //
  //
  // n == nums.length
  // 1 <= nums.length <= 10⁵
  // -10⁹ <= nums[i] <= 10⁹
  //
  // Related Topics Array Math Sorting 👍 2630 👎 101

  public static void main(String[] args) {
    Solution solution = new MinimumMovesToEqualArrayElementsII().new Solution();
    String[] data = """
          [1,2,3]
      [1,10,2,9]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minMoves2((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minMoves2(int[] nums) {
      int sum = 0;
      Arrays.sort(nums);
      int i = 0, right = nums.length - 1;
      while (i < right) {
        sum += nums[right] - nums[i];
        i++;
        right--;
      }
      return sum;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
