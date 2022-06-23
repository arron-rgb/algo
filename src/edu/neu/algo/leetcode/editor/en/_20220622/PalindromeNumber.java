package edu.neu.algo.leetcode.editor.en._20220622;

import edu.neu.util.InputUtil;

public class PalindromeNumber {

  // Given an integer x, return true if x is palindrome integer.
  //
  // An integer is a palindrome when it reads the same backward as forward.
  //
  //
  // For example, 121 is a palindrome while 123 is not.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: x = 121
  // Output: true
  // Explanation: 121 reads as 121 from left to right and from right to left.
  //
  //
  // Example 2:
  //
  //
  // Input: x = -121
  // Output: false
  // Explanation: From left to right, it reads -121. From right to left, it
  // becomes 121-. Therefore it is not a palindrome.
  //
  //
  // Example 3:
  //
  //
  // Input: x = 10
  // Output: false
  // Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
  //
  //
  //
  // Constraints:
  //
  //
  // -2³¹ <= x <= 2³¹ - 1
  //
  //
  //
  // Follow up: Could you solve it without converting the integer to a string?
  // Related Topics Math 👍 6145 👎 2175

  public static void main(String[] args) {
    Solution solution = new PalindromeNumber().new Solution();
    String[] data = """
          121
      -121
      10
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isPalindrome((int)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isPalindrome(int x) {
      if (x < 0) {
        return false;
      }
      int y = 0;
      int tmp = x;
      while (tmp > 0) {
        y = y * 10 + tmp % 10;
        tmp /= 10;
      }
      return y == x;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
