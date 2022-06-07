package edu.neu.algo.leetcode.editor.en._20220526;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

  // Given a string s and a string array dictionary, return the longest string in
  // the dictionary that can be formed by deleting some of the given string
  // characters. If there is more than one possible result, return the longest word with the
  // smallest lexicographical order. If there is no possible result, return the empty
  // string.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
  // Output: "apple"
  //
  //
  // Example 2:
  //
  //
  // Input: s = "abpcplea", dictionary = ["a","b","c"]
  // Output: "a"
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 1000
  // 1 <= dictionary.length <= 1000
  // 1 <= dictionary[i].length <= 1000
  // s and dictionary[i] consist of lowercase English letters.
  //
  // Related Topics Array Two Pointers String Sorting 👍 1343 👎 331

  public static void main(String[] args) {
    Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
      dictionary.sort((a, b) -> {
        if (a.length() == b.length()) {
          return a.compareTo(b);
        }
        return Integer.compare(b.length(), a.length());
      });
      for (String word : dictionary) {
        int i = 0;
        for (char c : s.toCharArray()) {
          if (i < word.length() && c == word.charAt(i)) {
            i++;
          }
        }
        if (i == word.length()) {
          return word;
        }
      }
      return "";
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
