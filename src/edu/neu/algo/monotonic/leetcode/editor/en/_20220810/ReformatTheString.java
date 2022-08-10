package edu.neu.algo.monotonic.leetcode.editor.en._20220810;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReformatTheString {
  // 1417
  // You are given an alphanumeric string s. (Alphanumeric string is a string
  // consisting of lowercase English letters and digits).
  //
  // You have to find a permutation of the string where no letter is followed by
  // another letter and no digit is followed by another digit. That is, no two
  // adjacent characters have the same type.
  //
  // Return the reformatted string or return an empty string if it is impossible
  // to reformat the string.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "a0b1c2"
  // Output: "0a1b2c"
  // Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1
  // c2", "0a1b2c", "0c2a1b" are also valid permutations.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "leetcode"
  // Output: ""
  // Explanation: "leetcode" has only characters so we cannot separate them by
  // digits.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "1229857369"
  // Output: ""
  // Explanation: "1229857369" has only digits so we cannot separate them by
  // characters.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 500
  // s consists of only lowercase English letters and/or digits.
  //
  // Related Topics String 👍 423 👎 77

  public static void main(String[] args) {
    Solution solution = new ReformatTheString().new Solution();
    String[] data = """
          "a0b1c2"
      "leetcode"
      "1229857369"
      "covid2019"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.reformat((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reformat(String s) {
      char[] c = s.toCharArray();
      int count1 = 0, count2 = 0;
      for (char value : c) {
        if (value >= '0' && value <= '9') {
          count1++;
        } else {
          count2++;
        }
      }
      if (Math.abs(count1 - count2) > 1) {
        return "";
      }
      int i = 0, j = 0;
      if (count1 >= count2) {
        j++;
      } else {
        i++;
      }
      char[] ans = new char[c.length];
      for (char value : c) {
        if (value >= '0' && value <= '9') {
          ans[i] = value;
          i += 2;
        } else {
          ans[j] = value;
          j += 2;
        }
      }
      return new String(ans);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
