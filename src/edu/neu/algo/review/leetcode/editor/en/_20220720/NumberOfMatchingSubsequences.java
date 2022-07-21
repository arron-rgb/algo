package edu.neu.algo.review.leetcode.editor.en._20220720;

import java.util.*;
import edu.neu.util.InputUtil;

public class NumberOfMatchingSubsequences {
  // 792
  // Given a string s and an array of strings words, return the number of words[i]
  // that is a subsequence of s.
  //
  // A subsequence of a string is a new string generated from the original string
  // with some characters (can be none) deleted without changing the relative order
  // of the remaining characters.
  //
  //
  // For example, "ace" is a subsequence of "abcde".
  //
  //
  //
  // Example 1:
  //
  //
  // Input: s = "abcde", words = ["a","bb","acd","ace"]
  // Output: 3
  // Explanation: There are three strings in words that are a subsequence of s:
  // "a", "acd", "ace".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
  // Output: 2
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 5 * 10⁴
  // 1 <= words.length <= 5000
  // 1 <= words[i].length <= 50
  // s and words[i] consist of only lowercase English letters.
  //
  // Related Topics Hash Table String Trie Sorting 👍 3443 👎 163

  public static void main(String[] args) {
    Solution solution = new NumberOfMatchingSubsequences().new Solution();
    String[] data = """
          "abcde"
      ["a","bb","acd","ace"]
      "dsahjpjauf"
      ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numMatchingSubseq((String)params[1 + i * paramTypes.length - 1],
        (String[])params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numMatchingSubseq(String s, String[] words) {
      int count = 0;
      // 给定s，判断words中有几个word是s的子序列
      // s长度 5*10^4 得On
      List<List<Node>> heads = new ArrayList<>();
      for (int i = 0; i < 26; i++) {
        heads.add(new ArrayList<>());
      }
      for (String word : words) {
        heads.get(word.charAt(0) - 'a').add(new Node(word, 0));
      }
      for (char c : s.toCharArray()) {
        List<Node> list = heads.get(c - 'a');
        heads.set(c - 'a', new ArrayList<>());
        for (Node node : list) {
          node.index++;
          if (node.index == node.word.length()) {
            count++;
          } else {
            heads.get(node.word.charAt(node.index) - 'a').add(node);
          }
        }
        // list.clear();
      }

      return count;
    }

    class Node {
      String word;
      int index;

      public Node(String word, int index) {
        this.word = word;
        this.index = index;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
