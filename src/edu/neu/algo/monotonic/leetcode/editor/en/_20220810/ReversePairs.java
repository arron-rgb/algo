package edu.neu.algo.monotonic.leetcode.editor.en._20220810;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReversePairs {
  // 493
  // Given an integer array nums, return the number of reverse pairs in the array.
  //
  //
  // A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] >
  // 2 * nums[j].
  //
  //
  // Example 1:
  // Input: nums = [1,3,2,3,1]
  // Output: 2
  // Example 2:
  // Input: nums = [2,4,3,5,1]
  // Output: 3
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 5 * 10⁴
  // -2³¹ <= nums[i] <= 2³¹ - 1
  //
  // Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree
  // Segment Tree Merge Sort Ordered Set 👍 3615 👎 198

  public static void main(String[] args) {
    Solution solution = new ReversePairs().new Solution();
    String[] data = """
          [1,3,2,3,1]
      [2,4,3,5,1]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.reversePairs((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int reversePairs(int[] nums) {
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
