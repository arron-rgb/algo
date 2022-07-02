package edu.neu.algo.leetcode.editor.en._20220701;

import java.util.Arrays;

import edu.neu.util.InputUtil;

public class MinimumMovesToEqualArrayElements {
  // 453
  // Given an integer array nums of size n, return the minimum number of moves
  // required to make all array elements equal.
  //
  // In one move, you can increment n - 1 elements of the array by 1.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3]
  // Output: 3
  // Explanation: Only three moves are needed (remember each move increments two
  // elements):
  // [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,1,1]
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // n == nums.length
  // 1 <= nums.length <= 10⁵
  // -10⁹ <= nums[i] <= 10⁹
  // The answer is guaranteed to fit in a 32-bit integer.
  //
  // Related Topics Array Math 👍 1675 👎 1665

  public static void main(String[] args) {
    Solution solution = new MinimumMovesToEqualArrayElements().new Solution();
    String[] data = """
          [1,2,3]
      [1,1,1]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minMoves((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minMoves(int[] nums) {
      int min = Arrays.stream(nums).min().getAsInt();
      int sum = Arrays.stream(nums).sum();
      return sum - nums.length * min;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
