package edu.neu.algo.review.leetcode.editor.en._20230320;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class NumberOfZeroFilledSubarrays {
  // 2348
  // Given an integer array nums, return the number of subarrays filled with 0.
  //
  // A subarray is a contiguous non-empty sequence of elements within an array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,3,0,0,2,0,0,4]
  // Output: 6
  // Explanation:
  // There are 4 occurrences of [0] as a subarray.
  // There are 2 occurrences of [0,0] as a subarray.
  // There is no occurrence of a subarray with a size more than 2 filled with 0.
  // Therefore, we return 6.
  //
  // Example 2:
  //
  //
  // Input: nums = [0,0,0,2,0,0]
  // Output: 9
  // Explanation:
  // There are 5 occurrences of [0] as a subarray.
  // There are 3 occurrences of [0,0] as a subarray.
  // There is 1 occurrence of [0,0,0] as a subarray.
  // There is no occurrence of a subarray with a size more than 3 filled with 0.
  // Therefore, we return 9.
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [2,10,2019]
  // Output: 0
  // Explanation: There is no subarray filled with 0. Therefore, we return 0.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // -10⁹ <= nums[i] <= 10⁹
  //
  //
  // Related Topics Array Math 👍 504 👎 21

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] data = """
                  [1,3,0,0,2,0,0,4]
      [0,0,0,2,0,0]
      [2,10,2019]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      long q = solution.zeroFilledSubarray((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public long zeroFilledSubarray(int[] nums) {
      int left = 0, right = 0;
      int n = nums.length;
      long res = 0;
      while (right < n) {
        while (right < n && nums[right] == 0) {
          right++;
          res += (right - left);
        }
        right++;
        left = right;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
