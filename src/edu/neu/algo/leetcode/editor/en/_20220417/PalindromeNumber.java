package edu.neu.algo.leetcode.editor.en._20220417;

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
  // Related Topics Math 👍 5603 👎 2094

  public static void main(String[] args) {
    Solution solution = new PalindromeNumber().new Solution();
    System.out.println(solution.isPalindrome(10));
    System.out.println(solution.isPalindrome(88888));
    System.out.println(solution.isPalindrome(333));
    System.out.println(solution.isPalindrome(10));
    System.out.println(solution.isPalindrome(1221));
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isPalindrome(int x) {
      if (x < 0) {
        return false;
      }
      if (x < 10) {
        return true;
      }
      if (x % 10 == 0) {
        return false;
      }

      int tmp = 0;
      while (x > tmp) {
        tmp = tmp * 10 + x % 10;
        x /= 10;
      }
      return x == tmp || (x == tmp / 10);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
