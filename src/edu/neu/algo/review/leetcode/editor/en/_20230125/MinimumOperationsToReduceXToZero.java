package edu.neu.algo.review.leetcode.editor.en._20230125;

import edu.neu.util.InputUtil;

import java.util.*;

public class MinimumOperationsToReduceXToZero {
  // 1658
  // You are given an integer array nums and an integer x. In one operation, you
  // can either remove the leftmost or the rightmost element from the array nums and
  // subtract its value from x. Note that this modifies the array for future
  // operations.
  //
  // Return the minimum number of operations to reduce x to exactly 0 if it is
  // possible, otherwise, return -1.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,1,4,2,3], x = 5
  // Output: 2
  // Explanation: The optimal solution is to remove the last two elements to
  // reduce x to zero.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [5,6,7,8,9], x = 4
  // Output: -1
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [3,2,20,1,1,3], x = 10
  // Output: 5
  // Explanation: The optimal solution is to remove the last three elements and
  // the first two elements (5 operations in total) to reduce x to zero.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // 1 <= nums[i] <= 10⁴
  // 1 <= x <= 10⁹
  //
  //
  // Related Topics Array Hash Table Binary Search Sliding Window Prefix Sum 👍 38
  // 42 👎 80

  public static void main(String[] args) {
    Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
    String[] data = """
                  [1,1,4,2,3]
      5
      [5,6,7,8,9]
      4
      [3,2,20,1,1,3]
      10
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minOperations((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minOperations(int[] nums, int x) {
      int n = nums.length;
      int sum = Arrays.stream(nums).sum();
      if (sum < x) {
        return -1;
      }
      int ans = Integer.MIN_VALUE;
      int left = 0, right = 0, tmp = 0;
      // 找一个subarray sum为 sum - x
      // 求最大长度
      int target = sum - x;
      while (right < n) {
        tmp += nums[right];
        while (tmp > target && left <= right) {
          tmp -= nums[left];
          left++;
        }
        if (tmp == target) {
          ans = Math.max(ans, right - left + 1);
        }
        right++;
      }

      return ans == Integer.MIN_VALUE ? -1 : n - ans;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
