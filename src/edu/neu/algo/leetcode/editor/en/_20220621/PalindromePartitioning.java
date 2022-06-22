package edu.neu.algo.leetcode.editor.en._20220621;

import java.util.ArrayList;
import java.util.List;

import edu.neu.util.InputUtil;

public class PalindromePartitioning {

  // Given a string s, partition s such that every substring of the partition is a
  // palindrome. Return all possible palindrome partitioning of s.
  //
  // A palindrome string is a string that reads the same backward as forward.
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
  // Related Topics String Dynamic Programming Backtracking 👍 7109 👎 225

  public static void main(String[] args) {
    Solution solution = new PalindromePartitioning().new Solution();
    String[] data = """
          "aab"
      "a\"""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      // ${question.returnType}
      // list要变成List
      List<List<String>> q = solution.partition((String)params[i * paramTypes.length]);
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

    void dfs(String s, int index, List<String> cur) {
      if (index == s.length()) {
        res.add(new ArrayList<>(cur));
        return;
      }

      for (int i = index; i < s.length(); i++) {
        if (isPalindrome(s, index, i)) {
          cur.add(s.substring(index, i + 1));
          dfs(s, i + 1, cur);
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
