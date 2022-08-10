package edu.neu.algo.monotonic.leetcode.editor.en._20220810;

import java.util.*;
import edu.neu.util.InputUtil;

public class ReverseVowelsOfAString {
  // 345
  // Given a string s, reverse only all the vowels in the string and return it.
  //
  // The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both
  // cases.
  //
  //
  // Example 1:
  // Input: s = "hello"
  // Output: "holle"
  // Example 2:
  // Input: s = "leetcode"
  // Output: "leotcede"
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 3 * 10⁵
  // s consist of printable ASCII characters.
  //
  // Related Topics Two Pointers String 👍 1779 👎 1945

  public static void main(String[] args) {
    Solution solution = new ReverseVowelsOfAString().new Solution();
    String[] data = """
          "hello"
      "leetcode"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.reverseVowels((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    Set<Character> set = new HashSet<>() {
      {
        add('e');
        add('a');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
      }
    };

    public String reverseVowels(String s) {
      char[] chars = s.toCharArray();
      int left = 0, right = chars.length - 1;
      while (left < right) {
        while (left < right && !set.contains(chars[left])) {
          left++;
        }
        while (left < right && !set.contains(chars[right])) {
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
