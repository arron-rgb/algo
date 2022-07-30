package edu.neu.algo.monotonic.leetcode.editor.en._20220729;

import java.util.*;
import java.util.stream.Collectors;

import edu.neu.util.InputUtil;

public class WordSubsets {
  // 916
  // You are given two string arrays words1 and words2.
  //
  // A string b is a subset of string a if every letter in b occurs in a
  // including multiplicity.
  //
  //
  // For example, "wrr" is a subset of "warrior" but is not a subset of "world".
  //
  //
  // A string a from words1 is universal if for every string b in words2, b is a
  // subset of a.
  //
  // Return an array of all the universal strings in words1. You may return the
  // answer in any order.
  //
  //
  // Example 1:
  //
  //
  // Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = [
  // "e","o"]
  // Output: ["facebook","google","leetcode"]
  //
  //
  // Example 2:
  //
  //
  // Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = [
  // "l","e"]
  // Output: ["apple","google","leetcode"]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= words1.length, words2.length <= 10⁴
  // 1 <= words1[i].length, words2[i].length <= 10
  // words1[i] and words2[i] consist only of lowercase English letters.
  // All the strings of words1 are unique.
  //
  // Related Topics Array Hash Table String 👍 1077 👎 138

  public static void main(String[] args) {
    Solution solution = new WordSubsets().new Solution();
    String[] data = """
          ["amazon","apple","facebook","google","leetcode"]
      ["e","o"]
      ["amazon","apple","facebook","google","leetcode"]
      ["l","e"]
      ["amazon","apple","facebook","google","leetcode"]
      ["lo","eo"]
      ["amazon","apple","facebook","google","leetcode"]
      ["ec","oc","ceo"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[], String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.wordSubsets((String[])params[1 + i * paramTypes.length - 1],
        (String[])params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
      int[] max = count("");
      for (String word : words2) {
        int[] count = count(word);
        for (int i = 0; i < 26; ++i) {
          max[i] = Math.max(max[i], count[i]);
        }
      }
      return Arrays.stream(words1).filter(word -> {
        int[] count = count(word);
        for (int i = 0; i < 26; i++) {
          if (count[i] < max[i]) {
            return false;
          }
        }
        return true;
      }).collect(Collectors.toList());
    }

    public int[] count(String word) {
      int[] count = new int[26];
      for (char c : word.toCharArray()) {
        count[c - 'a']++;
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  public List<String> wordSubsets(String[] words1, String[] words2) {
    Map<Character, Integer> source = count(words2);
    return Arrays.stream(words1).filter((word) -> {
      Map<Character, Integer> map = new HashMap<>(source);
      for (int i = 0; i < word.length(); i++) {
        char index = word.charAt(i);
        if (!map.containsKey(index)) {
          continue;
        }
        if (map.get(index) == 1) {
          map.remove(index);
        } else {
          map.put(index, map.get(index) - 1);
        }
      }
      return map.isEmpty();
    }).collect(Collectors.toList());
  }

  Map<Character, Integer> count(String[] ss) {
    Map<Character, Integer> map = new HashMap<>();
    for (String s : ss) {
      for (int i = 0; i < s.length(); i++) {
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      }
    }
    return map;
  }
}
