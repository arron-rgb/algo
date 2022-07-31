package edu.neu.algo.monotonic.leetcode.editor.en._20220730;

import java.util.*;
import edu.neu.util.InputUtil;

public class AppendKIntegersWithMinimalSum {
  // 2195
  // You are given an integer array nums and an integer k. Append k unique
  // positive integers that do not appear in nums to nums such that the resulting total sum
  // is minimum.
  //
  // Return the sum of the k integers appended to nums.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,4,25,10,25], k = 2
  // Output: 5
  // Explanation: The two unique positive integers that do not appear in nums
  // which we append are 2 and 3.
  // The resulting sum of nums is 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70, which is the
  // minimum.
  // The sum of the two integers appended is 2 + 3 = 5, so we return 5.
  //
  // Example 2:
  //
  //
  // Input: nums = [5,6], k = 6
  // Output: 25
  // Explanation: The six unique positive integers that do not appear in nums
  // which we append are 1, 2, 3, 4, 7, and 8.
  // The resulting sum of nums is 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36, which is the
  // minimum.
  // The sum of the six integers appended is 1 + 2 + 3 + 4 + 7 + 8 = 25, so we
  // return 25.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // 1 <= nums[i] <= 10⁹
  // 1 <= k <= 10⁸
  //
  // Related Topics Array Math Greedy Sorting 👍 400 👎 240

  public static void main(String[] args) {
    Solution solution = new AppendKIntegersWithMinimalSum().new Solution();
    String[] data = """
          [1,4,25,10,25]
      2
      [5,6]
      6
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      long q =
        solution.minimalKSum((int[])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public long minimalKSum(int[] nums, int k) {
      Arrays.sort(nums);
      Set<Integer> set = new HashSet<>();
      long sum = 0;

      for (int num : nums) {
        if (!set.contains(num) && num <= k) {
          k++;
          sum += num;
        }
        set.add(num);
      }

      return (long)(1 + k) * k / 2 - sum;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
