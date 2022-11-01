package edu.neu.algo.review.leetcode.editor.en._20221101;

import java.util.*;
import edu.neu.util.InputUtil;

public class ProductOfArrayExceptSelf {
  // 238
  // Given an integer array nums, return an array answer such that answer[i] is
  // equal to the product of all the elements of nums except nums[i].
  //
  // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
  // integer.
  //
  // You must write an algorithm that runs in O(n) time and without using the
  // division operation.
  //
  //
  // Example 1:
  // Input: nums = [1,2,3,4]
  // Output: [24,12,8,6]
  // Example 2:
  // Input: nums = [-1,1,0,-3,3]
  // Output: [0,0,9,0,0]
  //
  //
  // Constraints:
  //
  //
  // 2 <= nums.length <= 10⁵
  // -30 <= nums[i] <= 30
  // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
  // integer.
  //
  //
  //
  // Follow up: Can you solve the problem in O(1) extra space complexity? (The
  // output array does not count as extra space for space complexity analysis.)
  // Related Topics Array Prefix Sum 👍 15176 👎 861

  public static void main(String[] args) {
    Solution solution = new ProductOfArrayExceptSelf().new Solution();
    String[] data = """
          [1,2,3,4]
      [-1,1,0,-3,3]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int[] q = solution.productExceptSelf((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(Arrays.toString(q));
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] left = new int[n + 10], right = new int[n + 10];
      left[0] = right[n + 1] = 1;
      for (int i = 1; i <= n; i++) {
        left[i] = left[i - 1] * nums[i - 1];
      }
      for (int i = n; i >= 1; i--) {
        right[i] = right[i + 1] * nums[i - 1];
      }
      int[] res = new int[n];
      for (int i = 1; i <= n; i++) {
        res[i - 1] = left[i - 1] * right[i + 1];
      }
      return res;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
