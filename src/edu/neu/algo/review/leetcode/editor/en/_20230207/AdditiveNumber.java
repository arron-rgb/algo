package edu.neu.algo.review.leetcode.editor.en._20230207;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class AdditiveNumber {
  // 306
  // An additive number is a string whose digits can form an additive sequence.
  //
  // A valid additive sequence should contain at least three numbers. Except for
  // the first two numbers, each subsequent number in the sequence must be the sum of
  // the preceding two.
  //
  // Given a string containing only digits, return true if it is an additive
  // number or false otherwise.
  //
  // Note: Numbers in the additive sequence cannot have leading zeros, so
  // sequence 1, 2, 03 or 1, 02, 3 is invalid.
  //
  //
  // Example 1:
  //
  //
  // Input: "112358"
  // Output: true
  // Explanation:
  // The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
  // 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
  //
  //
  // Example 2:
  //
  //
  // Input: "199100199"
  // Output: true
  // Explanation:
  // The additive sequence is: 1, 99, 100, 199. 
  // 1 + 99 = 100, 99 + 100 = 199
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= num.length <= 35
  // num consists only of digits.
  //
  //
  //
  // Follow up: How would you handle overflow for very large input integers?
  //
  // Related Topics String Backtracking 👍 919 👎 715

  public static void main(String[] args) {
    Solution solution = new AdditiveNumber().new Solution();
    String[] data = """
                  "112358"
      "199100199"
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isAdditiveNumber((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isAdditiveNumber(String num) {
      int n = num.length();

      // choose the first number A
      for (int i = 1; i <= (n - 1) / 2; i++) {
        // A cannot start with a 0 if its length is more than 1
        if (num.charAt(0) == '0' && i >= 2)
          break; // previous code: continue;

        // choose the second number B
        for (int j = i + 1; n - j >= j - i && n - j >= i; j++) {
          // B cannot start with a 0 if its length is more than 1
          if (num.charAt(i) == '0' && j - i >= 2)
            break; // previous: continue;

          long num1 = Long.parseLong(num.substring(0, i)); // A
          long num2 = Long.parseLong(num.substring(i, j)); // B
          String substr = num.substring(j); // remaining string

          if (isAdditive(substr, num1, num2))
            return true; // return true if passes isAdditive test
          // else continue; // continue for loop if does not pass isAdditive test
        }
      }
      return false; // does not pass isAdditive test, thus is not additive
    }

    // Recursively checks if a string is additive
    public boolean isAdditive(String str, long num1, long num2) {
      if (str.equals(""))
        return true; // reaches the end of string means a yes

      long sum = num1 + num2;
      String s = ((Long)sum).toString();
      if (!str.startsWith(s))
        return false; // if string does not start with sum of num1 and num2, returns false

      return isAdditive(str.substring(s.length()), num2, sum); // recursively checks the remaining string
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
