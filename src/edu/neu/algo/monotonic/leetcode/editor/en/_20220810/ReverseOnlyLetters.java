package edu.neu.algo.monotonic.leetcode.editor.en._20220810;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReverseOnlyLetters {
  // 917
  // Given a string s, reverse the string according to the following rules:
  //
  //
  // All the characters that are not English letters remain in the same position.
  //
  // All the English letters (lowercase or uppercase) should be reversed.
  //
  //
  // Return s after reversing it.
  //
  //
  // Example 1:
  // Input: s = "ab-cd"
  // Output: "dc-ba"
  // Example 2:
  // Input: s = "a-bC-dEf-ghIj"
  // Output: "j-Ih-gfE-dCba"
  // Example 3:
  // Input: s = "Test1ng-Leet=code-Q!"
  // Output: "Qedo1ct-eeLg=ntse-T!"
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 100
  // s consists of characters with ASCII values in the range [33, 122].
  // s does not contain '\"' or '\\'.
  //
  // Related Topics Two Pointers String 👍 1548 👎 53

  public static void main(String[] args) {
    Solution solution = new ReverseOnlyLetters().new Solution();
    String[] data = """
          "ab-cd"
      "a-bC-dEf-ghIj"
      "Test1ng-Leet=code-Q!"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.reverseOnlyLetters((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reverseOnlyLetters(String s) {
      char[] chars = s.toCharArray();
      int left = 0, right = chars.length - 1;
      while (left < right) {
        while (left < right && !Character.isAlphabetic(chars[left])) {
          left++;
        }
        while (left < right && !Character.isAlphabetic(chars[right])) {
          right--;
        }
        swap(chars, left++, right--);
      }
      return new String(chars);
    }

    void swap(char[] s, int i, int j) {
      char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
