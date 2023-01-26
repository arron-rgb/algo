package edu.neu.algo.review.leetcode.editor.en._20221214;

import edu.neu.util.InputUtil;

import java.util.HashMap;
import java.util.*;

public class ValidParentheses {

  // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
  // ', determine if the input string is valid.
  //
  // An input string is valid if:
  //
  //
  // Open brackets must be closed by the same type of brackets.
  // Open brackets must be closed in the correct order.
  // Every close bracket has a corresponding open bracket of the same type.
  //
  //
  //
  // Example 1:
  //
  //
  // Input: s = "()"
  // Output: true
  //
  //
  // Example 2:
  //
  //
  // Input: s = "()[]{}"
  // Output: true
  //
  //
  // Example 3:
  //
  //
  // Input: s = "(]"
  // Output: false
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 10⁴
  // s consists of parentheses only '()[]{}'.
  //
  // Related Topics String Stack 👍 17125 👎 896

  public static void main(String[] args) {
    Solution solution = new ValidParentheses().new Solution();
    String[] data = """
                  "()"
      "()[]{}"
      "(]"
      "{[]}"
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isValid((String)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    Map<Character, Character> map = new HashMap<>() {
      {
        put(')', '(');
        put('}', '{');
        put(']', '[');
      }
    };

    public boolean isValid(String s) {
      int n = s.length();
      Deque<Character> deque = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        char e = s.charAt(i);
        if (deque.isEmpty()) {
          deque.addLast(e);
        } else {
          if (Objects.equals(map.getOrDefault(e, ' '), deque.peekLast())) {
            deque.pollLast();
          } else {
            deque.addLast(e);
          }
        }
      }
      return deque.isEmpty();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
