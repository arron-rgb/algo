package edu.neu.algo.review.leetcode.editor.en._20230118;

import edu.neu.util.InputUtil;
import java.util.*;

public class ThreeSumClosest {

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
  // Related Topics Array Two Pointers Sorting 👍 8480 👎 462

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
      int q = solution.threeSumClosest((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int threeSumClosest(int[] nums, int target) {
      int resDistance = Integer.MAX_VALUE;
      int res = nums[0] + nums[1] + nums[2];
      Arrays.sort(nums);
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }
        int left = i + 1, right = n - 1;
        while (left < right) {
          int sum = nums[left] + nums[right] + nums[i];
          if (sum == target) {
            return target;
          } else if (sum > target) {
            int tmp = nums[right];
            while (left < right && nums[right] == tmp) {
              right--;
            }
          } else {
            int tmp = nums[left];
            while (left < right && nums[left] == tmp) {
              left++;
            }
          }
          if (Math.abs(sum - target) < resDistance) {
            res = sum;
            resDistance = Math.abs(sum - target);
          }
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
