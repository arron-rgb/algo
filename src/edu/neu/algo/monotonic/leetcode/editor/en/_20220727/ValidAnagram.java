package edu.neu.algo.monotonic.leetcode.editor.en._20220727;

import java.util.*;
import edu.neu.util.InputUtil;

public class ValidAnagram {
  // 242
  // Given two strings s and t, return true if t is an anagram of s, and false
  // otherwise.
  //
  // An Anagram is a word or phrase formed by rearranging the letters of a
  // different word or phrase, typically using all the original letters exactly once.
  //
  //
  // Example 1:
  // Input: s = "anagram", t = "nagaram"
  // Output: true
  // Example 2:
  // Input: s = "rat", t = "car"
  // Output: false
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length, t.length <= 5 * 10⁴
  // s and t consist of lowercase English letters.
  //
  //
  //
  // Follow up: What if the inputs contain Unicode characters? How would you
  // adapt your solution to such a case?
  // Related Topics Hash Table String Sorting 👍 5761 👎 232

  public static void main(String[] args) {
    Solution solution = new ValidAnagram().new Solution();
    String[] data = """
          "anagram"
      "nagaram"
      "rat"
      "car"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isAnagram((String)params[1 + i * paramTypes.length - 1],
        (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      char[] a = s.toCharArray();
      Arrays.sort(a);
      char[] b = t.toCharArray();
      Arrays.sort(b);

      for (int i = 0; i < a.length; i++) {
        if (a[i] != b[i]) {
          return false;
        }
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
