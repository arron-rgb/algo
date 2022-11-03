package edu.neu.algo.review.leetcode.editor.en._20221102;

import java.util.*;
import edu.neu.util.InputUtil;

public class ValidParentheses {
  // 20
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
  // Related Topics String Stack 👍 16466 👎 838

  public static void main(String[] args) {
    Solution solution = new ValidParentheses().new Solution();
    String[] data = """
          "()"
      "()[]{}"
      "(]"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.isValid((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // todo
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    Map<Character, Character> match = new HashMap<>() {
      {
        put('[', ']');
        put('(', ')');
        put('{', '}');
      }
    };

    Set<Character> left = new HashSet<>() {
      {
        addAll(Arrays.asList('(', '[', '{'));
      }
    };

    public boolean isValid(String s) {
      Deque<Character> deque = new ArrayDeque<>();
      int n = s.length();
      for (int i = 0; i < n; i++) {
        char cur = s.charAt(i);
        if (deque.isEmpty()) {
          if (!left.contains(cur)) {
            return false;
          }
          deque.addLast(cur);
        } else {
          // 是左括号
          if (left.contains(cur)) {
            deque.addLast(cur);
          } else {
            // 右括号
            if (deque.peekLast().charValue() == match.get(cur)) {
              deque.pollLast();
            } else {
              return false;
            }
          }
        }
      }
      return deque.isEmpty();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
