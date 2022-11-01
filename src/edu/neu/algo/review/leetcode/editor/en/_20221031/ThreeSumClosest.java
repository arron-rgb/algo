package edu.neu.algo.review.leetcode.editor.en._20221031;

import java.util.*;
import edu.neu.util.InputUtil;

public class ThreeSumClosest {
  // 16
  // Given an integer array nums of length n and an integer target, find three
  // integers in nums such that the sum is closest to target.
  //
  // Return the sum of the three integers.
  //
  // You may assume that each input would have exactly one solution.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [-1,2,1,-4], target = 1
  // Output: 2
  // Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [0,0,0], target = 1
  // Output: 0
  // Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
  //
  //
  //
  // Constraints:
  //
  //
  // 3 <= nums.length <= 500
  // -1000 <= nums[i] <= 1000
  // -10⁴ <= target <= 10⁴
  //
  // Related Topics Array Two Pointers Sorting 👍 8087 👎 447

  public static void main(String[] args) {
    Solution solution = new ThreeSumClosest().new Solution();
    String[] data = """
          [-1,2,1,-4]
      1
      [0,0,0]
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.threeSumClosest((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int res = nums[0] + nums[1] + nums[2];
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        if (i > 1 && nums[i] == nums[i - 1]) {
          continue;
        }
        int left = i + 1, right = n - 1;
        while (left < right) {
          // 跳过一样的
          while (left > i + 1 && left < n && nums[left] == nums[left - 1]) {
            left++;
          }
          if (left >= right) {
            break;
          }
          int tmp = nums[i] + nums[left] + nums[right];
          if (tmp == target) {
            return target;
          } else {
            if (Math.abs(tmp - target) < Math.abs(res - target)) {
              res = tmp;
            }
            if (tmp > target) {
              right--;
            } else {
              left++;
            }
          }
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
