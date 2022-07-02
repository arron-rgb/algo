package edu.neu.algo.leetcode.editor.en._20220701;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.neu.util.InputUtil;

public class WordBreak {
  // 139
  // Given a string s and a dictionary of strings wordDict, return true if s can
  // be segmented into a space-separated sequence of one or more dictionary words.
  //
  // Note that the same word in the dictionary may be reused multiple times in
  // the segmentation.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "leetcode", wordDict = ["leet","code"]
  // Output: true
  // Explanation: Return true because "leetcode" can be segmented as "leet code".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "applepenapple", wordDict = ["apple","pen"]
  // Output: true
  // Explanation: Return true because "applepenapple" can be segmented as "apple
  // pen apple".
  // Note that you are allowed to reuse a dictionary word.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
  // Output: false
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 300
  // 1 <= wordDict.length <= 1000
  // 1 <= wordDict[i].length <= 20
  // s and wordDict[i] consist of only lowercase English letters.
  // All the strings of wordDict are unique.
  //
  // Related Topics Hash Table String Dynamic Programming Trie Memoization 👍 1107
  // 2 👎 486

  public static void main(String[] args) {
    Solution solution = new WordBreak().new Solution();
    String[] data = """
          "leetcode"
      ["leet","code"]
      "applepenapple"
      ["apple","pen"]
      "catsandog"
      ["cats","dog","sand","and","cat"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, list<String>]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q =
        solution.wordBreak((String)params[i * paramTypes.length], (List<String>)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      Set<String> words = new HashSet<>(wordDict);
      int n = s.length();
      boolean[] dp = new boolean[n + 1];
      dp[0] = true;
      for (int i = 1; i < dp.length; i++) {
        for (int j = 0; j < i; j++) {
          if (words.contains(s.substring(j, i)) && dp[j]) {
            dp[i] = true;
            break;
          }
        }
      }
      return dp[n];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
