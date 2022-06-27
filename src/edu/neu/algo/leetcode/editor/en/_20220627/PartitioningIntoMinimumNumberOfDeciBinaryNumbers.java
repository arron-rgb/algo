package edu.neu.algo.leetcode.editor.en._20220627;

import edu.neu.util.InputUtil;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

  // A decimal number is called deci-binary if each of its digits is either 0 or 1
  // without any leading zeros. For example, 101 and 1100 are deci-binary, while 112
  // and 3001 are not.
  //
  // Given a string n that represents a positive decimal integer, return the
  // minimum number of positive deci-binary numbers needed so that they sum up to n.
  //
  //
  // Example 1:
  //
  //
  // Input: n = "32"
  // Output: 3
  // Explanation: 10 + 11 + 11 = 32
  //
  //
  // Example 2:
  //
  //
  // Input: n = "82734"
  // Output: 8
  //
  //
  // Example 3:
  //
  //
  // Input: n = "27346209830709182346"
  // Output: 9
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n.length <= 10⁵
  // n consists of only digits.
  // n does not contain any leading zeros and represents a positive integer.
  //
  // Related Topics String Greedy 👍 1478 👎 987

  public static void main(String[] args) {
    Solution solution = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers().new Solution();
    String[] data = """
          "32"
      "82734"
      "27346209830709182346"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minPartitions((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minPartitions(String n) {
      int res = 0;
      for (int i = 0; i < n.length(); ++i) {
        res = Math.max(res, n.charAt(i) - '0');
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
