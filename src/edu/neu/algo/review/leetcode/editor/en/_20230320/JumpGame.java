package edu.neu.algo.review.leetcode.editor.en._20230320;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class JumpGame {
  // 55
  // You are given an integer array nums. You are initially positioned at the
  // array's first index, and each element in the array represents your maximum jump
  // length at that position.
  //
  // Return true if you can reach the last index, or false otherwise.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [2,3,1,1,4]
  // Output: true
  // Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [3,2,1,0,4]
  // Output: false
  // Explanation: You will always arrive at index 3 no matter what. Its maximum
  // jump length is 0, which makes it impossible to reach the last index.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // 0 <= nums[i] <= 10⁵
  //
  //
  // Related Topics Array Dynamic Programming Greedy 👍 15671 👎 803

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] data = """
                  [2,3,1,1,4]
      [3,2,1,0,4]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.canJump((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canJump(int[] nums) {
      int max = 0;
      int n = nums.length;
      for (int j = 0; j < n; j++) {
        if (max < j) {
          return false;
        }
        max = Math.max(j + nums[j], max);
      }
      return max >= n - 1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
