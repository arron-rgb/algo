package edu.neu.algo.review.leetcode.editor.en._20221101;

import java.util.*;
import edu.neu.util.InputUtil;

public class RemoveAllAdjacentDuplicatesInString {
  // 1047
  // You are given a string s consisting of lowercase English letters. A duplicate
  // removal consists of choosing two adjacent and equal letters and removing them.
  //
  // We repeatedly make duplicate removals on s until we no longer can.
  //
  // Return the final string after all such duplicate removals have been made. It
  // can be proven that the answer is unique.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "abbaca"
  // Output: "ca"
  // Explanation:
  // For example, in "abbaca" we could remove "bb" since the letters are adjacent
  // and equal, and this is the only possible move. The result of this move is that
  // the string is "aaca", of which only "aa" is possible, so the final string is
  // "ca".
  //
  //
  // Example 2:
  //
  //
  // Input: s = "azxxzy"
  // Output: "ay"
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁵
  // s consists of lowercase English letters.
  //
  // Related Topics String Stack 👍 4145 👎 179

  public static void main(String[] args) {
    Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
    String[] data = """
          "abbaca"
      "azxxzy"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.removeDuplicates((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String removeDuplicates(String s) {
      Deque<Character> deque = new ArrayDeque<>();
      int n = s.length();
      for (int i = 0; i < n; i++) {
        if (!deque.isEmpty() && deque.peekLast() == s.charAt(i)) {
          deque.pollLast();
          continue;
        }
        deque.addLast(s.charAt(i));
      }
      StringBuilder res = new StringBuilder();
      for (char t : deque) {
        res.append(t);
      }
      return res.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
