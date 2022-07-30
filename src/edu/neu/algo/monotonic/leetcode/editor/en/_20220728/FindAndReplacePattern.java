package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import java.util.stream.Collectors;

import edu.neu.util.InputUtil;

public class FindAndReplacePattern {
  // 890
  // Given a list of strings words and a string pattern, return a list of words[i]
  // that match pattern. You may return the answer in any order.
  //
  // A word matches the pattern if there exists a permutation of letters p so
  // that after replacing every letter x in the pattern with p(x), we get the desired
  // word.
  //
  // Recall that a permutation of letters is a bijection from letters to letters:
  // every letter maps to another letter, and no two letters map to the same letter.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
  // Output: ["mee","aqq"]
  // Explanation: "mee" matches the pattern because there is a permutation {a -> m,
  // b -> e, ...}.
  // "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a
  // permutation, since a and b map to the same letter.
  //
  //
  // Example 2:
  //
  //
  // Input: words = ["a","b","c"], pattern = "a"
  // Output: ["a","b","c"]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= pattern.length <= 20
  // 1 <= words.length <= 50
  // words[i].length == pattern.length
  // pattern and words[i] are lowercase English letters.
  //
  // Related Topics Array Hash Table String 👍 2130 👎 124

  public static void main(String[] args) {
    Solution solution = new FindAndReplacePattern().new Solution();
    String[] data = """
          ["abc","deq","mee","aqq","dkd","ccc"]
      "abb"
      ["a","b","c"]
      "a"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[], String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.findAndReplacePattern((String[])params[1 + i * paramTypes.length - 1],
        (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
      return Arrays.stream(words).filter((word) -> match(word, pattern)).collect(Collectors.toList());
    }

    public boolean match(String word, String pattern) {
      Map<Character, Character> map = new HashMap<>();
      for (int i = 0; i < word.length(); ++i) {
        char w = word.charAt(i);
        char p = pattern.charAt(i);
        if (!map.containsKey(w)) {
          map.put(w, p);
        }
        if (map.get(w) != p) {
          return false;
        }
      }

      boolean[] seen = new boolean[26];
      for (char p : map.values()) {
        if (seen[p - 'a']) {
          return false;
        }
        seen[p - 'a'] = true;
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
