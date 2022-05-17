package edu.neu.algo.leetcode.editor.en._20220516;

import java.util.Arrays;

public class VerifyingAnAlienDictionary {

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
  // Related Topics Array Hash Table String 👍 2807 👎 934

  public static void main(String[] args) {
    Solution solution = new VerifyingAnAlienDictionary().new Solution();
    boolean result = solution.isAlienSorted(new String[] {"apple", "app"}, "abcdefghijklmnopqrstuvwxyz");
    System.out.println(result);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isAlienSorted(String[] words, String order) {
      int[] orders = new int[26];
      for (int i = 0; i < order.length(); i++) {
        orders[order.charAt(i) - 'a'] = i;
      }
      String[] tmp = new String[words.length];
      System.arraycopy(words, 0, tmp, 0, words.length);
      Arrays.sort(tmp, ((o1, o2) -> {
        int n = Math.min(o1.length(), o2.length());
        for (int i = 0; i < n; i++) {
          if (o1.charAt(i) != o2.charAt(i)) {
            return orders[o1.charAt(i) - 'a'] - orders[o2.charAt(i) - 'a'];
          }
        }
        return o1.length() - o2.length();
      }));
      System.out.println(Arrays.toString(tmp));
      for (int i = 0; i < tmp.length; i++) {
        if (!tmp[i].equals(words[i])) {
          return false;
        }
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
