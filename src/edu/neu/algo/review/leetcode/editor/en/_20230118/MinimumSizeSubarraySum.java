package edu.neu.algo.review.leetcode.editor.en._20230118;

import edu.neu.util.InputUtil;
import java.util.*;

public class MinimumSizeSubarraySum {

  // Given an array of positive integers nums and a positive integer target,
  // return the minimal length of a subarray whose sum is greater than or equal to target.
  // If there is no such subarray, return 0 instead.
  //
  //
  // Example 1:
  //
  //
  // Input: target = 7, nums = [2,3,1,2,4,3]
  // Output: 2
  // Explanation: The subarray [4,3] has the minimal length under the problem
  // constraint.
  //
  //
  // Example 2:
  //
  //
  // Input: target = 4, nums = [1,4,4]
  // Output: 1
  //
  //
  // Example 3:
  //
  //
  // Input: target = 11, nums = [1,1,1,1,1,1,1,1]
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= target <= 10⁹
  // 1 <= nums.length <= 10⁵
  // 1 <= nums[i] <= 10⁴
  //
  //
  //
  // Follow up: If you have figured out the O(n) solution, try coding another
  // solution of which the time complexity is O(n log(n)). Related Topics Array Binary
  // Search Sliding Window Prefix Sum 👍 8562 👎 238

  public static void main(String[] args) {
    Solution solution = new MinimumSizeSubarraySum().new Solution();
    String[] data = """
                  7
      [2,3,1,2,4,3]
      4
      [1,4,4]
      11
      [1,1,1,1,1,1,1,1]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minSubArrayLen((int)params[1 - 1 + i * paramTypes.length],
        (int[])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      return 0;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
