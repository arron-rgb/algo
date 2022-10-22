package edu.neu.algo.monotonic.leetcode.editor.en._20221019;

import java.util.*;
import edu.neu.util.InputUtil;

public class VerifyingAnAlienDictionary {
  // 953
  // In an alien language, surprisingly, they also use English lowercase letters,
  // but possibly in a different order. The order of the alphabet is some permutation
  // of lowercase letters.
  //
  // Given a sequence of words written in the alien language, and the order of
  // the alphabet, return true if and only if the given words are sorted
  // lexicographically in this alien language.
  //
  //
  // Example 1:
  //
  //
  // Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
  // Output: true
  // Explanation: As 'h' comes before 'l' in this language, then the sequence is
  // sorted.
  //
  //
  // Example 2:
  //
  //
  // Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
  // Output: false
  // Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1]
  // , hence the sequence is unsorted.
  //
  //
  // Example 3:
  //
  //
  // Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
  // Output: false
  // Explanation: The first three characters "app" match, and the second string is
  // shorter (in size.) According to lexicographical rules "apple" > "app", because
  // 'l' > '∅', where '∅' is defined as the blank character which is less than any
  // other character (More info).
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= words.length <= 100
  // 1 <= words[i].length <= 20
  // order.length == 26
  // All characters in words[i] and order are English lowercase letters.
  //
  // Related Topics Array Hash Table String 👍 3136 👎 1002

  public static void main(String[] args) {
    Solution solution = new VerifyingAnAlienDictionary().new Solution();
    String[] data = """
          ["hello","leetcode"]
      "hlabcdefgijkmnopqrstuvwxyz"
      ["word","world","row"]
      "worldabcefghijkmnpqstuvxyz"
      ["apple","app"]
      "abcdefghijklmnopqrstuvwxyz"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[], String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isAlienSorted((String[])params[1 + i * paramTypes.length - 1],
        (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isAlienSorted(String[] words, String order) {
      String[] strings = Arrays.copyOf(words, words.length);
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0, n = order.length(); i < n; i++) {
        map.put(order.charAt(i), i);
      }
      Arrays.sort(strings, (o1, o2) -> {
        int n = Math.min(o1.length(), o2.length());
        for (int i = 0; i < n; i++) {
          Integer v1 = map.get(o1.charAt(i));
          Integer v2 = map.get(o2.charAt(i));
          if (v1.equals(v2)) {
            continue;
          }
          return v1.compareTo(v2);
        }
        return o1.length() - o2.length();
      });
      return Arrays.equals(words, strings);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
