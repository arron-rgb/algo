package edu.neu.algo.review.leetcode.editor.en._20230206;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class PalindromePartitioning {
  // 131
  // Given a string s, partition s such that every substring of the partition is a
  // palindrome. Return all possible palindrome partitioning of s.
  //
  //
  // Example 1:
  // Input: s = "aab"
  // Output: [["a","a","b"],["aa","b"]]
  //
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
  //
  // Related Topics String Dynamic Programming Backtracking 👍 10138 👎 323

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
      List<List<String>> q = solution.partition((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
      res = new ArrayList<>();
      dfs(new ArrayList<>(), s, 0);
      return res;
    }

    void dfs(List<String> tmp, String s, int index) {
      if (index == s.length()) {
        res.add(new ArrayList<>(tmp));
        return;
      }
      for (int i = index; i < s.length(); i++) {
        if (check(s, index, i)) {
          tmp.add(s.substring(index, i + 1));
          dfs(tmp, s, i + 1);
          tmp.remove(tmp.size() - 1);
        }
      }
    }

    boolean check(String s, int left, int right) {
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
