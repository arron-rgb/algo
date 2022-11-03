package edu.neu.algo.review.leetcode.editor.en._20221102;

import java.util.*;
import edu.neu.util.InputUtil;

public class PalindromePartitioning {
  // 131
  // Given a string s, partition s such that every substring of the partition is a
  // palindrome. Return all possible palindrome partitioning of s.
  //
  //
  // Example 1:
  // Input: s = "aab"
  // Output: [["a","a","b"],["aa","b"]]
  // Example 2:
  // Input: s = "a"
  // Output: [["a"]]
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 16
  // s contains only lowercase English letters.
  //
  // Related Topics String Dynamic Programming Backtracking 👍 8600 👎 267

  public static void main(String[] args) {
    Solution solution = new PalindromePartitioning().new Solution();
    String[] data = """
          "aab"
      "a"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<String>> q = solution.partition((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
      res = new ArrayList<>();
      dfs(s, 0, new ArrayList<>());
      return res;
    }

    void dfs(String s, int start, List<String> cur) {
      if (start == s.length()) {
        res.add(new ArrayList<>(cur));
        return;
      }

      for (int end = start; end < s.length(); end++) {
        if (isPalindrome(s, start, end)) {
          cur.add(s.substring(start, end + 1));
          dfs(s, end + 1, cur);
          cur.remove(cur.size() - 1);
        }
      }
    }

    boolean isPalindrome(String s, int left, int right) {
      while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
          return false;
        }
        left++;
        right--;
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
