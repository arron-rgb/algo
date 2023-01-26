package edu.neu.algo.review.leetcode.editor.en._20221216;

import edu.neu.util.InputUtil;

import java.util.*;

public class WordLadder {

  // A transformation sequence from word beginWord to word endWord using a
  // dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
  //
  //
  //
  // Every adjacent pair of words differs by a single letter.
  // Every si for 1 <= i <= k is in wordList. Note that beginWord does not need
  // to be in wordList.
  // sk == endWord
  //
  //
  // Given two words, beginWord and endWord, and a dictionary wordList, return
  // the number of words in the shortest transformation sequence from beginWord to
  // endWord, or 0 if no such sequence exists.
  //
  //
  // Example 1:
  //
  //
  // Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
  // "lot","log","cog"]
  // Output: 5
  // Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -
  // > "dog" -> cog", which is 5 words long.
  //
  //
  // Example 2:
  //
  //
  // Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
  // "lot","log"]
  // Output: 0
  // Explanation: The endWord "cog" is not in wordList, therefore there is no
  // valid transformation sequence.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= beginWord.length <= 10
  // endWord.length == beginWord.length
  // 1 <= wordList.length <= 5000
  // wordList[i].length == beginWord.length
  // beginWord, endWord, and wordList[i] consist of lowercase English letters.
  // beginWord != endWord
  // All the words in wordList are unique.
  //
  // Related Topics Hash Table String Breadth-First Search 👍 9583 👎 1749

  public static void main(String[] args) {
    Solution solution = new WordLadder().new Solution();
    String[] data = """
                  "hit"
      "cog"
      ["hot","dot","dog","lot","log","cog"]
      "hit"
      "cog"
      ["hot","dot","dog","lot","log"]
      "hot"
      "dog"
      ["hot", "dog"]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String, List<String>]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.ladderLength((String)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length], (List<String>)params[3 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> words = new HashSet<>(wordList);
      if (!words.contains(endWord)) {
        return 0;
      }
      Set<String> visited = new HashSet<>();
      visited.add(beginWord);
      Deque<String> deque = new ArrayDeque<>();
      deque.addLast(beginWord);
      int steps = 1;

      while (!deque.isEmpty()) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
          String s = deque.pollFirst();
          if (next(s, endWord, deque, visited, words)) {
            return steps + 1;
          }
        }
        steps++;
      }
      return 0;
    }

    boolean next(String cur, String end, Deque<String> deque, Set<String> visited, Set<String> words) {
      char[] chars = cur.toCharArray();
      int n = chars.length;
      for (int i = 0; i < n; i++) {
        char tmp = chars[i];
        for (char c = 'a'; c <= 'z'; c++) {
          if (c == tmp) {
            continue;
          }
          chars[i] = c;
          String next = new String(chars);
          if (words.contains(next)) {
            if (end.equals(next)) {
              return true;
            }
            if (visited.contains(next)) {
              continue;
            }
            visited.add(next);
            deque.addLast(next);
          }
        }
        chars[i] = tmp;
      }
      return false;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
