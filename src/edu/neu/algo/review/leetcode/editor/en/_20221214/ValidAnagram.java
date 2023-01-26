package edu.neu.algo.review.leetcode.editor.en._20221214;

import edu.neu.util.InputUtil;

import java.util.Arrays;

public class ValidAnagram {

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
  // Related Topics Hash Table String Sorting 👍 7703 👎 249

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
      boolean q = solution.isAnagram((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isAnagram(String s, String t) {
      return Arrays.equals(count(s), count(t));
    }

    int[] count(String s) {
      int[] c = new int[26];
      for (int i = 0, n = s.length(); i < n; i++) {
        c[s.charAt(i) - 'a']++;
      }
      return c;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
