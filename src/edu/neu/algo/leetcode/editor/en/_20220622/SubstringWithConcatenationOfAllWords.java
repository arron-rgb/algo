package edu.neu.algo.leetcode.editor.en._20220622;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

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
  // s consists of lower-case English letters.
  // 1 <= words.length <= 5000
  // 1 <= words[i].length <= 30
  // words[i] consists of lower-case English letters.
  //
  // Related Topics Hash Table String Sliding Window 👍 2072 👎 1901

  public static void main(String[] args) {
    Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
    // String[] data = """
    // "barfoothefoobarman"
    // ["foo","bar"]
    // "wordgoodgoodgoodbestword"
    // ["word","good","best","word"]
    // "barfoofoobarthefoobarman"
    // ["bar","foo","the"]
    // """.trim().replaceAll("\n", "|").split("\\|");
    // String[] paramTypes = InputUtil.param("[String, String[]]");
    // Object[] params = new Object[data.length];
    // for (int i = 0; i < data.length; i++) {
    // params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    // }
    // int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // List<Integer> q = solution.findSubstring((String)params[1 - 1 + i * paramTypes.length],
    // (String[])params[2 - 1 + i * paramTypes.length]);
    // System.out.println(q);
    // }
    SubstringWithConcatenationOfAllWords a = new SubstringWithConcatenationOfAllWords();
    String[] asds = a.permutation("asd");
    System.out.println(Arrays.toString(asds));
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      if (s == null || words == null || s.length() == 0 || words.length == 0) {
        return new ArrayList<>();
      }
      Map<String, Integer> counts = new HashMap<>();
      for (String word : words) {
        counts.put(word, counts.getOrDefault(word, 0) + 1);
      }

      List<Integer> r = new ArrayList<>();
      int sLen = s.length();
      int num = words.length;
      int wordLen = words[0].length();

      for (int i = 0; i < sLen - num * wordLen + 1; i++) {
        String sub = s.substring(i, i + num * wordLen);
        if (isConcat(sub, counts, wordLen)) {
          r.add(i);
        }
      }
      return r;
    }

    /**
     *
     */
    private boolean isConcat(String sub, Map<String, Integer> counts, int wordLen) {
      Map<String, Integer> seen = new HashMap<>();
      for (int i = 0; i < sub.length(); i += wordLen) {
        String sWord = sub.substring(i, i + wordLen);
        seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
      }
      return seen.equals(counts);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public String[] permutation(String s) {
    List<String> res = new ArrayList<>();
    dfs(s.toCharArray(), new StringBuilder(), res, new boolean[s.length()]);
    return res.stream().distinct().toList().toArray(new String[0]);
  }

  void dfs(char[] chars, StringBuilder cur, List<String> res, boolean[] flag) {
    if (cur.length() == chars.length) {
      res.add(cur.toString());
      return;
    }
    for (int j = 0; j < chars.length; j++) {
      if (flag[j]) {
        continue;
      }
      cur.append(chars[j]);
      flag[j] = true;
      dfs(chars, cur, res, flag);
      cur.deleteCharAt(cur.length() - 1);
      flag[j] = false;
    }
  }
}
