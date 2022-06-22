package edu.neu.algo.leetcode.editor.en._20220621;

import edu.neu.util.InputUtil;

public class SignOfTheProductOfAnArray {

  // There is a function signFunc(x) that returns:
  //
  //
  // 1 if x is positive.
  // -1 if x is negative.
  // 0 if x is equal to 0.
  //
  //
  // You are given an integer array nums. Let product be the product of all
  // values in the array nums.
  //
  // Return signFunc(product).
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [-1,-2,-3,-4,3,2,1]
  // Output: 1
  // Explanation: The product of all values in the array is 144, and signFunc(144)
  // = 1
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,5,0,2,-3]
  // Output: 0
  // Explanation: The product of all values in the array is 0, and signFunc(0) = 0
  //
  //
  // Example 3:
  //
  //
  // Input: nums = [-1,1,-1,1,-1]
  // Output: -1
  // Explanation: The product of all values in the array is -1, and signFunc(-1) =
  // -1
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 1000
  // -100 <= nums[i] <= 100
  //
  // Related Topics Array Math 👍 602 👎 81

  public static void main(String[] args) {
    Solution solution = new SignOfTheProductOfAnArray().new Solution();
    String[] data = """
          [-1,-2,-3,-4,3,2,1]
      [1,5,0,2,-3]
      [-1,1,-1,1,-1]""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.arraySign((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int arraySign(int[] nums) {
      int negative = 0;
      for (int num : nums) {
        if (num == 0) {
          return 0;
        }
        if (num < 0) {
          negative++;
        }
      }
      if (negative % 2 == 0) {
        return 1;
      }
      return -1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
