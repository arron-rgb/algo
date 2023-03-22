package edu.neu.algo.review.leetcode.editor.en._20230320;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class JumpGameII {
  // 45
  // You are given a 0-indexed array of integers nums of length n. You are
  // initially positioned at nums[0].
  //
  // Each element nums[i] represents the maximum length of a forward jump from
  // index i. In other words, if you are at nums[i], you can jump to any nums[i + j]
  // where:
  //
  //
  // 0 <= j <= nums[i] and
  // i + j < n
  //
  //
  // Return the minimum number of jumps to reach nums[n - 1]. The test cases are
  // generated such that you can reach nums[n - 1].
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [2,3,1,1,4]
  // Output: 2
  // Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
  // step from index 0 to 1, then 3 steps to the last index.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [2,3,0,1,4]
  // Output: 2
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // 0 <= nums[i] <= 1000
  // It's guaranteed that you can reach nums[n - 1].
  //
  //
  // Related Topics Array Dynamic Programming Greedy 👍 11929 👎 416

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] data = """
                  [2,3,1,1,4]
      [2,3,0,1,4]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.jump((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int jump(int[] nums) {
      int n = nums.length;
      if (n == 1)
        return 0;
      int steps = 1;
      int left = 0;
      int right = nums[0];
      while (true) {
        if (right >= n - 1)
          return steps;
        int max = 0;
        for (int i = left; i <= right; i++) {
          max = Math.max(max, i + nums[i]);
        }
        left = right;
        right = max;
        steps++;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
