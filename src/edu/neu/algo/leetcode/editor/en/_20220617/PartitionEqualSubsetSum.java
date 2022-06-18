package edu.neu.algo.leetcode.editor.en._20220617;

import edu.neu.util.InputUtil;

public class PartitionEqualSubsetSum {

  // Given a non-empty array nums containing only positive integers, find if the
  // array can be partitioned into two subsets such that the sum of elements in both
  // subsets is equal.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,5,11,5]
  // Output: true
  // Explanation: The array can be partitioned as [1, 5, 5] and [11].
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3,5]
  // Output: false
  // Explanation: The array cannot be partitioned into equal sum subsets.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 200
  // 1 <= nums[i] <= 100
  //
  // Related Topics Array Dynamic Programming 👍 7736 👎 123

  public static void main(String[] args) {
    Solution solution = new PartitionEqualSubsetSum().new Solution();
    String[] data = """
          [1,5,11,5]
      [1,2,3,5]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.canPartition((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canPartition(int[] nums) {
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
