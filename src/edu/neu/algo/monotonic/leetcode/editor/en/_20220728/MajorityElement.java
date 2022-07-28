package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class MajorityElement {
  // 169
  // Given an array nums of size n, return the majority element.
  //
  // The majority element is the element that appears more than ⌊n / 2⌋ times.
  // You may assume that the majority element always exists in the array.
  //
  //
  // Example 1:
  // Input: nums = [3,2,3]
  // Output: 3
  // Example 2:
  // Input: nums = [2,2,1,1,1,2,2]
  // Output: 2
  //
  //
  // Constraints:
  //
  //
  // n == nums.length
  // 1 <= n <= 5 * 10⁴
  // -10⁹ <= nums[i] <= 10⁹
  //
  //
  //
  // Follow-up: Could you solve the problem in linear time and in O(1) space?
  // Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 10932 👎 362

  public static void main(String[] args) {
    Solution solution = new MajorityElement().new Solution();
    String[] data = """
          [3,2,3]
      [2,2,1,1,1,2,2]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.majorityElement((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int majorityElement(int[] nums) {
      int pre = nums[0];
      int count = 1;
      for (int i = 1; i < nums.length; i++) {
        if (count == 0) {
          pre = nums[i];
          count = 1;
          continue;
        }
        if (pre == nums[i]) {
          count++;
        } else {
          count--;
        }
      }
      return pre;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
