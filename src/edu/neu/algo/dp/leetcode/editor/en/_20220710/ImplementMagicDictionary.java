package edu.neu.algo.dp.leetcode.editor.en._20220710;

import edu.neu.util.InputUtil;

public class ImplementMagicDictionary {
  // 676
  // Design a data structure that is initialized with a list of different words.
  // Provided a string, you should determine if you can change exactly one character
  // in this string to match any word in the data structure.
  //
  // Implement the MagicDictionary class:
  //
  //
  // MagicDictionary() Initializes the object.
  // void buildDict(String[] dictionary) Sets the data structure with an array of
  // distinct strings dictionary.
  // bool search(String searchWord) Returns true if you can change exactly one
  // character in searchWord to match any string in the data structure, otherwise
  // returns false.
  //
  //
  //
  // Example 1:
  //
  //
  // Input
  // ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
  // [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
  // Output
  // [null, null, false, true, false, false]
  //
  // Explanation
  // MagicDictionary magicDictionary = new MagicDictionary();
  // magicDictionary.buildDict(["hello", "leetcode"]);
  // magicDictionary.search("hello"); // return False
  // magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to
  // match "hello" so we return True
  // magicDictionary.search("hell"); // return False
  // magicDictionary.search("leetcoded"); // return False
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= dictionary.length <= 100
  // 1 <= dictionary[i].length <= 100
  // dictionary[i] consists of only lower-case English letters.
  // All the strings in dictionary are distinct.
  // 1 <= searchWord.length <= 100
  // searchWord consists of only lower-case English letters.
  // buildDict will be called only once before search.
  // At most 100 calls will be made to search.
  //
  // Related Topics Hash Table String Design Trie 👍 1068 👎 183

  public static void main(String[] args) {
    MagicDictionary solution = new ImplementMagicDictionary().new MagicDictionary();
    String[] data = """
          ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
      [[], [["hello","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("${question.paramTypes}");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
  }

  class MagicDictionary {

    Trie root;

    public MagicDictionary() {}

    public void buildDict(String[] dictionary) {
      for (String s : dictionary) {
        this.root.addWord(s);
      }
    }

    public boolean search(String searchWord) {
      return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
      if (pos == searchWord.length()) {
        return modified && node.isEnd;
      }
      int idx = searchWord.charAt(pos) - 'a';
      if (node.children[idx] != null) {
        if (dfs(searchWord, node.children[idx], pos + 1, modified)) {
          return true;
        }
      }
      if (modified) {
        return false;
      }
      for (int i = 0; i < 26; ++i) {
        if (i != idx && node.children[i] != null) {
          if (dfs(searchWord, node.children[i], pos + 1, true)) {
            return true;
          }
        }
      }
      return false;
    }

  }

  class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
      this.children = new Trie[26];
    }

    void addWord(String word) {
      Trie root = this;
      int n = word.length();
      for (int i = 0; i < n; i++) {
        int index = word.charAt(i) - 'a';
        if (root.children[index] == null) {
          root.children[index] = new Trie();
        }
        root = root.children[index];
      }
      root.isEnd = true;
    }
  }
}
