package edu.neu.algo.review.leetcode.editor.en._20221101;

import java.util.*;
import edu.neu.util.InputUtil;

public class TwoSum {
  // 1
  // Given an array of integers nums and an integer target, return indices of the
  // two numbers such that they add up to target.
  //
  // You may assume that each input would have exactly one solution, and you may
  // not use the same element twice.
  //
  // You can return the answer in any order.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [2,7,11,15], target = 9
  // Output: [0,1]
  // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [3,2,4], target = 6
  // Output: [1,2]
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [3,3], target = 6
  // Output: [0,1]
  //
  //
  //
  // Constraints:
  //
  //
  // 2 <= nums.length <= 10⁴
  // -10⁹ <= nums[i] <= 10⁹
  // -10⁹ <= target <= 10⁹
  // Only one valid answer exists.
  //
  //
  //
  // Follow-up: Can you come up with an algorithm that is less than O(n²) time
  // complexity? Related Topics Array Hash Table 👍 39625 👎 1279

  public static void main(String[] args) {
    Solution solution = new TwoSum().new Solution();
    String[] data = """
          [2,7,11,15]
      9
      [3,2,4]
      6
      [3,3]
      6
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q =
        solution.twoSum((int[])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        if (map.containsKey(target - num)) {
          return new int[] {i, map.get(target - num)};
        }
        map.put(num, i);
      }
      return new int[] {-1, -1};
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
