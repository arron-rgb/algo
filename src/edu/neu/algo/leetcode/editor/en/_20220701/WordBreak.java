package edu.neu.algo.leetcode.editor.en._20220701;

import java.util.*;

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
    Trie root = new WordBreak().new Trie();
    root.add("apple");
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
      // boolean q =
      // solution.wordBreak((String)params[i * paramTypes.length], (List<String>)params[2 - 1 + i * paramTypes.length]);
      // System.out.println(q);
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

  class DfsSolution {
    public boolean wordBreak(String s, List<String> wordDict) {
      Boolean[] dp = new Boolean[s.length()];
      return wordBreakBacking(s, wordDict, 0, dp);
    }

    private boolean wordBreakBacking(String s, List<String> wordDict, int index, Boolean[] dp) {
      if (index == s.length()) {
        return true;
      }
      if (dp[index] != null) {
        return dp[index];
      }
      boolean b;
      for (String temp : wordDict) {
        if (wordBreakCheck(s, temp, index)) {
          b = wordBreakBacking(s, wordDict, index + temp.length(), dp);
          if (b) {
            dp[index] = b;
            return true;
          }
        }
      }
      dp[index] = false;
      return false;
    }

    private boolean wordBreakCheck(String s, String temp, int index) {
      for (int i = 0; i < temp.length(); i++) {
        if (index + i >= s.length() || s.charAt(index + i) != temp.charAt(i)) {
          return false;
        }
      }
      return true;
    }
  }

  class WordFilter {
    Map<String, List<Integer>> map;
    String[] words;

    public WordFilter(String[] words) {
      this.map = new HashMap<>();
      this.words = words;
      for (int i = 0; i < words.length; i++) {
        String s = words[i];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
          sb.append(c);
          String curPrefix = sb.toString();
          if (!map.containsKey(curPrefix)) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(curPrefix, list);
          } else {
            map.get(curPrefix).add(i);
          }
        }
      }
    }

    public int f(String prefix, String suffix) {
      if (!map.containsKey(prefix)) {
        return -1;
      }
      List<Integer> list = map.get(prefix);
      return find(list, suffix.toCharArray());
    }

    private int find(List<Integer> list, char[] sstr) {
      for (int i = list.size() - 1; i >= 0; i--) {
        int curIndex = list.get(i);
        char[] curstr = words[curIndex].toCharArray();
        if (curstr.length < sstr.length) {
          continue;
        }
        int ii = curstr.length - 1, jj = sstr.length - 1;
        boolean choose = true;
        while (jj >= 0) {
          if (curstr[ii--] != sstr[jj--]) {
            choose = false;
            break;
          }
        }
        if (choose) {
          return curIndex;
        }
      }
      return -1;
    }
  }

  class Trie {
    Trie[] children;
    boolean isEnd;

    Trie[] parent;
    boolean isStart;

    public Trie() {
      this.children = new Trie[26];
      this.parent = new Trie[26];
    }

    void add(String word) {
      Trie root = this;
      char[] chars = word.toCharArray();
      for (char a : chars) {
        int index = a - 'a';
        if (root.children[index] == null) {
          root.children[index] = new Trie();
        }
        root = root.children[index];
      }
      root.isEnd = true;

      root = this;
      for (int j = word.length() - 1; j >= 0; j--) {
        int index = word.charAt(j) - 'a';
        if (root.parent[index] == null) {
          root.parent[index] = new Trie();
        }
        root = root.parent[index];
      }
      root.isStart = true;
    }

    Map<String, Set<String>> cache = new HashMap<>();

    Set<String> searchPrefix(String prefix) {
      if (cache.containsKey(prefix)) {
        return cache.get(prefix);
      }
      Set<String> res = new HashSet<>();
      char[] chars = prefix.toCharArray();
      Trie root = this;
      for (char a : chars) {
        root = root.children[a - 'a'];
        if (root == null) {
          return Set.of();
        }
      }
      dfs(root, res, prefix, true);
      cache.put(prefix, res);
      return res;
    }

    void dfs(Trie root, Set<String> res, String prefix, boolean isPrefix) {
      if (root == null) {
        return;
      }
      if (isPrefix && root.isEnd) {
        res.add(prefix);
        return;
      } else if (!isPrefix && root.isStart) {
        res.add(prefix);
      }
      Trie[] tries = isPrefix ? root.children : root.parent;
      for (int i = 0; i < tries.length; i++) {
        Trie child = tries[i];
        if (child == null) {
          continue;
        }
        dfs(child, res, isPrefix ? prefix + (char)(i + 'a') : (char)(i + 'a') + prefix, isPrefix);
      }
    }

    Map<String, Set<String>> cache2 = new HashMap<>();

    Set<String> searchSuffix(String suffix) {
      if (cache2.containsKey(suffix)) {
        return cache2.get(suffix);
      }
      Set<String> res = new HashSet<>();
      char[] chars = suffix.toCharArray();
      Trie root = this;
      for (int i = chars.length - 1; i >= 0; i--) {
        char a = chars[i];
        root = root.parent[a - 'a'];
        if (root == null) {
          break;
        }
      }
      dfs(root, res, suffix, false);
      cache2.put(suffix, res);
      return res;
    }

  }

  class Best {

    class WordFilter {
      PrefixSuffixTree rootPrefix = new PrefixSuffixTree(true);
      PrefixSuffixTree rootSuffix = new PrefixSuffixTree(false);

      public WordFilter(String[] words) {
        HashSet<String> strings = new HashSet<>();
        for (int i = words.length - 1; i >= 0; i--) {
          if (!strings.add(words[i])) {
            continue;
          }
          char[] ac = words[i].toCharArray();
          rootPrefix.add(i, ac);
          rootSuffix.add(i, ac);
        }
      }

      public int f(String prefix, String suffix) {
        Set<Integer> i = rootPrefix.find(prefix.toCharArray());
        if (i.isEmpty()) {
          return -1;
        }
        Set<Integer> i1 = rootSuffix.find(suffix.toCharArray());
        if (i1.isEmpty()) {
          return -1;
        }
        int ans = -1;
        for (int integer : i) {
          if (i1.contains(integer)) {
            ans = Math.max(ans, integer);
          }
        }
        return ans;
      }
    }

    class PrefixSuffixTree {
      PrefixSuffixTree[] tree = new PrefixSuffixTree[26];
      Set<Integer> index = new HashSet<>();
      boolean f = false;

      public PrefixSuffixTree(boolean f) {
        this.f = f;
      }

      void add(int index, char[] ac) {
        PrefixSuffixTree current = this;
        for (int i = f ? 0 : ac.length - 1; (f) ? i < ac.length : i >= 0; i += f ? 1 : -1) {
          if (current.tree[ac[i] - 'a'] == null) {
            current.tree[ac[i] - 'a'] = new PrefixSuffixTree(f);
          }
          current = current.tree[ac[i] - 'a'];
          current.index.add(index);
        }
      }

      Set<Integer> find(char[] ac) {
        PrefixSuffixTree current = this;
        for (int i = f ? 0 : ac.length - 1; (f) ? i < ac.length : i >= 0; i += f ? 1 : -1) {
          if (current.tree[ac[i] - 'a'] == null) {
            return Set.of();
          }
          current = current.tree[ac[i] - 'a'];
        }
        return current.index;
      }
    }

  }
}
