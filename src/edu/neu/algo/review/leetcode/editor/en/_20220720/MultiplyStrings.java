package edu.neu.algo.review.leetcode.editor.en._20220720;

import java.util.*;
import edu.neu.util.InputUtil;

public class MultiplyStrings {
  // 43
  // Given two non-negative integers num1 and num2 represented as strings, return
  // the product of num1 and num2, also represented as a string.
  //
  // Note: You must not use any built-in BigInteger library or convert the inputs
  // to integer directly.
  //
  //
  // Example 1:
  // Input: num1 = "2", num2 = "3"
  // Output: "6"
  // Example 2:
  // Input: num1 = "123", num2 = "456"
  // Output: "56088"
  //
  //
  // Constraints:
  //
  //
  // 1 <= num1.length, num2.length <= 200
  // num1 and num2 consist of digits only.
  // Both num1 and num2 do not contain any leading zero, except the number 0
  // itself.
  //
  // Related Topics Math String Simulation 👍 4731 👎 1913

  public static void main(String[] args) {
    Solution solution = new MultiplyStrings().new Solution();
    String[] data = """
          "2"
      "3"
      "123"
      "456"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q =
        solution.multiply((String)params[1 + i * paramTypes.length - 1], (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String multiply(String num1, String num2) {
      if ("0".equals(num1) || "0".equals(num2)) {
        return "0";
      }
      int m = num1.length(), n = num2.length();
      int[] ansArr = new int[m + n];
      for (int i = m - 1; i >= 0; i--) {
        int x = num1.charAt(i) - '0';
        for (int j = n - 1; j >= 0; j--) {
          int y = num2.charAt(j) - '0';
          ansArr[i + j + 1] += x * y;
        }
      }
      for (int i = m + n - 1; i > 0; i--) {
        ansArr[i - 1] += ansArr[i] / 10;
        ansArr[i] %= 10;
      }
      int index = ansArr[0] == 0 ? 1 : 0;
      StringBuilder ans = new StringBuilder();
      while (index < m + n) {
        ans.append(ansArr[index]);
        index++;
      }
      return ans.toString();
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
