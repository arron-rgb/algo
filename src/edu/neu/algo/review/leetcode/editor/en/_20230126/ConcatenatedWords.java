package edu.neu.algo.review.leetcode.editor.en._20230126;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

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
  //
  // Related Topics Array String Dynamic Programming Depth-First Search Trie 👍 24
  // 27 👎 240

  public static void main(String[] args) {
    ConcatenatedWords solution = new ConcatenatedWords();
    String[] data = """
      3
      [[1,3],[2,3]]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int[][]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.minimumSemesters((int)params[1 - 1 + i * paramTypes.length],
        (int[][])params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    class Trie {
      boolean isEnd;
      Trie[] children;

      public Trie(boolean isEnd, Trie[] children) {
        this.isEnd = isEnd;
        this.children = children;
      }

      public Trie() {
        this.isEnd = false;
        this.children = new Trie[26];
      }

      void addWord(String word) {
        char[] charArray = word.toCharArray();
        Trie root = this;
        for (char c : charArray) {
          if (root.children[c - 'a'] == null) {
            root.children[c - 'a'] = new Trie();
          }
          root = root.children[c - 'a'];
        }
        root.isEnd = true;
      }

      boolean search(String word, int i) {
        if (i == word.length()) {
          return true;
        }
        // search的逻辑
        // 1. 长度到了 就是找到了
        Trie node = this;
        while (i < word.length()) {
          // 不然每一个字符到结尾都可以继续往下找
          if (node.children[word.charAt(i) - 'a'] == null) {
            return false;
          }
          node = node.children[word.charAt(i) - 'a'];
          if (node.isEnd && search(word, i + 1)) {
            return true;
          }
          // 因为需要由其他单词拼接成
          // 所以要保证node.isEnd并且有其他的词一起组成
          i++;
        }
        return false;
      }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
      Trie root = new Trie();
      Arrays.sort(words, Comparator.comparingInt(String::length));
      List<String> res = new ArrayList<>();
      for (String word : words) {
        if ("".equals(word)) {
          continue;
        }
        // 大的肯定是由小的组成的
        // 排序保证了不会因大的先插入造成的search出现问题
        if (root.search(word, 0)) {
          res.add(word);
        }
        root.addWord(word);
      }
      return res;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

  public int minimumSemesters(int n, int[][] relations) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] pre = new int[n + 1];
    for (int[] relation : relations) {
      pre[relation[1]]++;
      map.computeIfAbsent(relation[0], t -> new ArrayList<>()).add(relation[1]);
    }
    int course = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n + 1];
    for (int j = 1; j < pre.length; j++) {
      if (pre[j] == 0) {
        queue.add(j);
        visited[j] = true;
        course++;
      }
    }
    int res = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int poll = queue.poll();
        List<Integer> list = map.getOrDefault(poll, List.of());
        for (int j : list) {
          pre[j]--;
          if (pre[j] == 0 && !visited[j]) {
            queue.add(j);
            visited[j] = true;
            course++;
          }
        }
      }
      res++;
    }
    return course == n ? res : -1;
  }

}
