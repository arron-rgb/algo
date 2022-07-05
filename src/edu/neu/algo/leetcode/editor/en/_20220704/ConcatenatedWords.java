package edu.neu.algo.leetcode.editor.en._20220704;

import java.util.*;

import edu.neu.util.InputUtil;

public class ConcatenatedWords {
  // 472
  // Given an array of strings words (without duplicates), return all the
  // concatenated words in the given list of words.
  //
  // A concatenated word is defined as a string that is comprised entirely of at
  // least two shorter words in the given array.
  //
  //
  // Example 1:
  //
  //
  // Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog",
  // "hippopotamuses","rat","ratcatdogcat"]
  // Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
  // Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
  // "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
  // "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
  //
  // Example 2:
  //
  //
  // Input: words = ["cat","dog","catdog"]
  // Output: ["catdog"]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= words.length <= 10⁴
  // 1 <= words[i].length <= 30
  // words[i] consists of only lowercase English letters.
  // All the strings of words are unique.
  // 1 <= sum(words[i].length) <= 10⁵
  //
  // Related Topics Array String Dynamic Programming Depth-First Search Trie 👍 20
  // 28 👎 226

  public static void main(String[] args) {
    Solution solution = new ConcatenatedWords().new Solution();
    String[] data = """
          ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
      ["cat","dog","catdog"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.findAllConcatenatedWordsInADict((String[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
      // sort the array in asc order of word length, since longer words are formed by shorter words.
      Arrays.sort(words, Comparator.comparingInt(String::length));

      List<String> result = new ArrayList<>();
      Set<String> preWords = new HashSet<>();
      for (String word : words) {
        // // Word Break-I problem.
        if (wordBreak(word, preWords)) {
          // if (topDown(word, preWords, 0, new Boolean[word.length()])) {
          result.add(word);
        }
        preWords.add(word);
      }
      return result;
    }

    private boolean wordBreak(String s, Set<String> preWords) {
      if (preWords.isEmpty()) {
        return false;
      }

      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;

      for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
          if (dp[j] && preWords.contains(s.substring(j, i))) {
            dp[i] = true;
            break;
          }
        }
      }
      return dp[s.length()];
    }

    private boolean topDown(String s, Set<String> wordDict, int startIndex, Boolean[] memo) {
      if (wordDict.isEmpty()) {
        return false;
      }
      // if we reach the beyond the string, then return true
      // s = "leetcode" when "code" is being checked in the IF() of the loop, we reach endIndex == s.length(),
      // and wordDict.contains("code") => true and topDown(s, wordDict, endIndex, memo) needs to return true.
      if (startIndex == s.length()) {
        return true;
      }

      // memo[i] = true means => that the substring from index i can be segmented.
      // memo[startIndex] means => wordDict contains substring from startIndex and it can be segemented.
      if (memo[startIndex] != null) { // Boolean[] array's default value is "null"
        return memo[startIndex];
      }

      for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
        if (wordDict.contains(s.substring(startIndex, endIndex)) && topDown(s, wordDict, endIndex, memo)) {
          memo[startIndex] = true;
          return true;
        }
      }
      memo[startIndex] = false;
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
