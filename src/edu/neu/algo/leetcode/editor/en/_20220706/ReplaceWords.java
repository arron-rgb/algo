package edu.neu.algo.leetcode.editor.en._20220706;

import java.util.List;

import edu.neu.util.InputUtil;

public class ReplaceWords {
  // 648
  // In English, we have a concept called root, which can be followed by some
  // other word to form another longer word - let's call this word successor. For example,
  // when the root "an" is followed by the successor word "other", we can form a
  // new word "another".
  //
  // Given a dictionary consisting of many roots and a sentence consisting of
  // words separated by spaces, replace all the successors in the sentence with the root
  // forming it. If a successor can be replaced by more than one root, replace it
  // with the root that has the shortest length.
  //
  // Return the sentence after the replacement.
  //
  //
  // Example 1:
  //
  //
  // Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled
  // by the battery"
  // Output: "the cat was rat by the bat"
  //
  //
  // Example 2:
  //
  //
  // Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
  // Output: "a a b c"
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= dictionary.length <= 1000
  // 1 <= dictionary[i].length <= 100
  // dictionary[i] consists of only lower-case letters.
  // 1 <= sentence.length <= 10⁶
  // sentence consists of only lower-case letters and spaces.
  // The number of words in sentence is in the range [1, 1000]
  // The length of each word in sentence is in the range [1, 1000]
  // Every two consecutive words in sentence will be separated by exactly one
  // space.
  // sentence does not have leading or trailing spaces.
  //
  // Related Topics Array Hash Table String Trie 👍 1604 👎 156

  public static void main(String[] args) {
    Solution solution = new ReplaceWords().new Solution();
    String[] data = """
          ["cat","bat","rat"]
      "the cattle was rattled by the battery"
      ["a","b","c"]
      "aadsfasf absbs bbab cadsfafs"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[list<String>, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.replaceWords((List<String>)params[1 - 1 + i * paramTypes.length],
        (String)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
      Trie root = new Trie();
      for (String s : dictionary) {
        root.insert(s);
      }
      String[] s = sentence.split(" ");
      StringBuilder res = new StringBuilder();
      for (String s1 : s) {
        String tmp = root.hasPrefix(s1);
        if (!"".equals(tmp)) {
          res.append(tmp).append(" ");
        } else {
          res.append(s1).append(" ");
        }
      }
      return res.toString();
    }

    class Trie {
      Trie[] children;
      boolean isEnd;

      public Trie() {
        children = new Trie[26];
      }

      public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
          char ch = word.charAt(i);
          int index = ch - 'a';
          if (node.children[index] == null) {
            node.children[index] = new Trie();
          }
          node = node.children[index];
        }
        node.isEnd = true;
      }

      public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
          char ch = word.charAt(i);
          int index = ch - 'a';
          if (node.children[index] == null || !node.children[index].isEnd) {
            return false;
          }
          node = node.children[index];
        }
        return node != null && node.isEnd;
      }

      public String hasPrefix(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
          char ch = word.charAt(i);
          int index = ch - 'a';
          //
          if (node.children[index] != null) {
            if (node.children[index].isEnd) {
              return word.substring(0, i + 1);
            }
          } else {
            return "";
          }
          node = node.children[index];
        }
        return (node != null && node.isEnd) ? word : "";
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
