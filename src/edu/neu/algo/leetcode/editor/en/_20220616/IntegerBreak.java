package edu.neu.algo.leetcode.editor.en._20220616;

public class IntegerBreak {

  // Given an integer n, break it into the sum of k positive integers, where k >= 2
  // , and maximize the product of those integers.
  //
  // Return the maximum product you can get.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 2
  // Output: 1
  // Explanation: 2 = 1 + 1, 1 × 1 = 1.
  //
  //
  // Example 2:
  //
  //
  // Input: n = 10
  // Output: 36
  // Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
  //
  //
  //
  // Constraints:
  //
  //
  // 2 <= n <= 58
  //
  // Related Topics Math Dynamic Programming 👍 2849 👎 335

  public static void main(String[] args) {
    Solution solution = new IntegerBreak().new Solution();
    // Output:2 6 4 12 8 9 45
    // 4 5 6 7 8 9 10 11
    // Expected:1 1 2 4 6 9 12 18 27 36 54
    // 9
    System.out.println(solution.integerBreak(10));
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int integerBreak(int n) {
      if (n == 2) {
        return 1;
      }
      if (n == 3) {
        return 2;
      }
      int product = 1;
      while (n > 4) {
        product *= 3;
        n -= 3;
      }
      product *= n;

      return product;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
