package edu.neu.algo.monotonic.leetcode.editor.en._20220728;

import java.util.*;
import edu.neu.util.InputUtil;

public class SubstringWithConcatenationOfAllWords {
  // 30
  // You are given a string s and an array of strings words of the same length.
  // Return all starting indices of substring(s) in s that is a concatenation of each
  // word in words exactly once, in any order, and without any intervening characters.
  //
  //
  // You can return the answer in any order.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "barfoothefoobarman", words = ["foo","bar"]
  // Output: [0,9]
  // Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar"
  // respectively.
  // The output order does not matter, returning [9,0] is fine too.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
  // Output: []
  //
  //
  // Example 3:
  //
  //
  // Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
  // Output: [6,9,12]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁴
  // 1 <= words.length <= 5000
  // 1 <= words[i].length <= 30
  // s and words[i] consist of lowercase English letters.
  //
  // Related Topics Hash Table String Sliding Window 👍 2184 👎 1938

  public static void main(String[] args) {
    Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
    String[] data = """
          "barfoothefoobarman"
      ["foo","bar"]
      "wordgoodgoodgoodbestword"
      ["word","good","best","word"]
      "barfoofoobarthefoobarman"
      ["bar","foo","the"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.findSubstring((String)params[1 + i * paramTypes.length - 1],
        (String[])params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    private int wordLength;
    private int substringSize;
    private int k;

    private boolean check(int i, String s) {
      // Copy the original dictionary to use for this index
      HashMap<String, Integer> remaining = new HashMap<>(wordCount);
      int wordsUsed = 0;

      // Each iteration will check for a match in words
      for (int j = i; j < i + substringSize; j += wordLength) {
        String sub = s.substring(j, j + wordLength);
        if (remaining.getOrDefault(sub, 0) != 0) {
          remaining.put(sub, remaining.get(sub) - 1);
          wordsUsed++;
        } else {
          break;
        }
      }

      return wordsUsed == k;
    }

    public List<Integer> findSubstring(String s, String[] words) {
      int n = s.length();
      k = words.length;
      wordLength = words[0].length();
      substringSize = wordLength * k;

      for (String word : words) {
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
      }

      List<Integer> answer = new ArrayList<>();
      for (int i = 0; i < n - substringSize + 1; i++) {
        if (check(i, s)) {
          answer.add(i);
        }
      }

      return answer;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
