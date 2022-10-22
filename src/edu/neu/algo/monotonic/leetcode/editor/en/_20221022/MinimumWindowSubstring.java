package edu.neu.algo.monotonic.leetcode.editor.en._20221022;

import java.util.*;
import edu.neu.util.InputUtil;

public class MinimumWindowSubstring {
  // 76
  // Given two strings s and t of lengths m and n respectively, return the minimum
  // window substring of s such that every character in t (including duplicates) is
  // included in the window. If there is no such substring, return the empty string
  // "".
  //
  // The testcases will be generated such that the answer is unique.
  //
  // A substring is a contiguous sequence of characters within the string.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "ADOBECODEBANC", t = "ABC"
  // Output: "BANC"
  // Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
  // from string t.
  //
  //
  // Example 2:
  //
  //
  // Input: s = "a", t = "a"
  // Output: "a"
  // Explanation: The entire string s is the minimum window.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "a", t = "aa"
  // Output: ""
  // Explanation: Both 'a's from t must be included in the window.
  // Since the largest window of s only has one 'a', return empty string.
  //
  //
  //
  // Constraints:
  //
  //
  // m == s.length
  // n == t.length
  // 1 <= m, n <= 10⁵
  // s and t consist of uppercase and lowercase English letters.
  //
  //
  //
  // Follow up: Could you find an algorithm that runs in O(m + n) time?
  // Related Topics Hash Table String Sliding Window 👍 13083 👎 579

  public static void main(String[] args) {
    Solution solution = new MinimumWindowSubstring().new Solution();
    String[] data = """
          "ADOBECODEBANC"
      "ABC"
      "a"
      "a"
      "a"
      "aa"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.minWindow((String)params[1 + i * paramTypes.length - 1],
        (String)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String minWindow(String s, String t) {
      int m = s.length(), n = t.length();
      if (m < n) {
        return "";
      }
      String res = "";
      int left = 0, right = 0;
      Map<Character, Integer> tMap = count(t);
      Map<Character, Integer> windows = new HashMap<>();
      while (right < m) {
        windows.put(s.charAt(right), windows.getOrDefault(s.charAt(right), 0) + 1);
        // ? 什么时候添加当前的
        while (right < m && !verify(windows, tMap)) {
          right++;
          // 添加右边新增的
          windows.put(s.charAt(right), windows.getOrDefault(s.charAt(right), 0) + 1);
        }

        // todo 有问题
        while (left < right && verify(windows, tMap)) {
          left++;
          windows.put(s.charAt(left), windows.get(s.charAt(left)) - 1);
          if (windows.get(s.charAt(left)) == 0) {
            windows.remove(s.charAt(left));
          }
        }
        if ("".equals(res) || right - left + 1 < res.length()) {
          res = s.substring(left, right + 1);
        }
        right++;
      }
      return res;
    }

    Map<Character, Integer> count(String s) {
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0, n = s.length(); i < n; i++) {
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      }
      return map;
    }

    // c1: map for window
    boolean verify(Map<Character, Integer> c1, Map<Character, Integer> c2) {
      if (c1.size() < c2.size()) {
        return false;
      }
      for (Character k : c2.keySet()) {
        if (c1.getOrDefault(k, 0) < c2.get(k)) {
          return false;
        }
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
