package edu.neu.algo.leetcode.editor.en._20220621;

import edu.neu.util.InputUtil;

public class TargetSum {

  // You are given an integer array nums and an integer target.
  //
  // You want to build an expression out of nums by adding one of the symbols '+'
  // and '-' before each integer in nums and then concatenate all the integers.
  //
  //
  // For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
  // and concatenate them to build the expression "+2-1".
  //
  //
  // Return the number of different expressions that you can build, which
  // evaluates to target.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,1,1,1,1], target = 3
  // Output: 5
  // Explanation: There are 5 ways to assign symbols to make the sum of nums be
  // target 3.
  // -1 + 1 + 1 + 1 + 1 = 3
  // +1 - 1 + 1 + 1 + 1 = 3
  // +1 + 1 - 1 + 1 + 1 = 3
  // +1 + 1 + 1 - 1 + 1 = 3
  // +1 + 1 + 1 + 1 - 1 = 3
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1], target = 1
  // Output: 1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 20
  // 0 <= nums[i] <= 1000
  // 0 <= sum(nums[i]) <= 1000
  // -1000 <= target <= 1000
  //
  // Related Topics Array Dynamic Programming Backtracking 👍 7121 👎 267

  public static void main(String[] args) {
    Solution solution = new TargetSum().new Solution();
    String[] data = """
          [1,1,1,1,1]
      3
      [1]
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findTargetSumWays((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
