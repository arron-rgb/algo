package edu.neu.algo.monotonic.leetcode.editor.en._20220812;

import java.util.*;
import edu.neu.util.InputUtil;

public class FindAllAnagramsInAString {
  // 438
  // Given two strings s and p, return an array of all the start indices of p's
  // anagrams in s. You may return the answer in any order.
  //
  // An Anagram is a word or phrase formed by rearranging the letters of a
  // different word or phrase, typically using all the original letters exactly once.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "cbaebabacd", p = "abc"
  // Output: [0,6]
  // Explanation:
  // The substring with start index = 0 is "cba", which is an anagram of "abc".
  // The substring with start index = 6 is "bac", which is an anagram of "abc".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "abab", p = "ab"
  // Output: [0,1,2]
  // Explanation:
  // The substring with start index = 0 is "ab", which is an anagram of "ab".
  // The substring with start index = 1 is "ba", which is an anagram of "ab".
  // The substring with start index = 2 is "ab", which is an anagram of "ab".
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length, p.length <= 3 * 10⁴
  // s and p consist of lowercase English letters.
  //
  // Related Topics Hash Table String Sliding Window 👍 8327 👎 266

  public static void main(String[] args) {
    Solution solution = new FindAllAnagramsInAString().new Solution();
    String[] data = """
          "cbaebabacd"
      "abc"
      "abab"
      "ab"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.findAnagrams((String)params[1 + i * paramTypes.length - 1],
        (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      int sLen = s.length(), pLen = p.length();

      if (sLen < pLen) {
        return new ArrayList<>();
      }

      List<Integer> ans = new ArrayList<>();
      int[] count = new int[26];
      for (int i = 0; i < pLen; ++i) {
        ++count[s.charAt(i) - 'a'];
        --count[p.charAt(i) - 'a'];
      }

      int differ = 0;
      for (int j = 0; j < 26; ++j) {
        if (count[j] != 0) {
          ++differ;
        }
      }

      if (differ == 0) {
        ans.add(0);
      }

      for (int i = 0; i < sLen - pLen; ++i) {
        if (count[s.charAt(i) - 'a'] == 1) {
          // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
          --differ;
        } else if (count[s.charAt(i) - 'a'] == 0) {
          // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
          ++differ;
        }
        --count[s.charAt(i) - 'a'];

        if (count[s.charAt(i + pLen) - 'a'] == -1) { // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
          --differ;
        } else if (count[s.charAt(i + pLen) - 'a'] == 0) { // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
          ++differ;
        }
        ++count[s.charAt(i + pLen) - 'a'];

        if (differ == 0) {
          ans.add(i + 1);
        }
      }

      return ans;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
