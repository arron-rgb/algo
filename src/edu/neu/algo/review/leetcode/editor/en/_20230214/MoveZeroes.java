package edu.neu.algo.review.leetcode.editor.en._20230214;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MoveZeroes {
  // 283
  // Given an integer array nums, move all 0's to the end of it while maintaining
  // the relative order of the non-zero elements.
  //
  // Note that you must do this in-place without making a copy of the array.
  //
  //
  // Example 1:
  // Input: nums = [0,1,0,3,12]
  // Output: [1,3,12,0,0]
  //
  // Example 2:
  // Input: nums = [0]
  // Output: [0]
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁴
  // -2³¹ <= nums[i] <= 2³¹ - 1
  //
  //
  //
  // Follow up: Could you minimize the total number of operations done?
  //
  // Related Topics Array Two Pointers 👍 12696 👎 322

  public static void main(String[] args) {
    Solution solution = new MoveZeroes().new Solution();
    String[] data = """
                  [0,1,0,3,12]
      [0]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      solution.moveZeroes((int[])params[i * paramTypes.length]);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void moveZeroes(int[] nums) {
      int n = nums.length;
      int left = 0;
      for (int i = 0; i < n; i++) {
        if (nums[i] != 0) {
          nums[left++] = nums[i];
        }
      }
      while (left < n) {
        nums[left++] = 0;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
