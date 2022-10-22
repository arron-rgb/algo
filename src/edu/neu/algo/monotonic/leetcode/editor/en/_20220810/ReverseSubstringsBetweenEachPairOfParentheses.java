package edu.neu.algo.monotonic.leetcode.editor.en._20220810;

import java.util.*;
import java.util.stream.Collectors;

import edu.neu.util.InputUtil;

public class ReverseSubstringsBetweenEachPairOfParentheses {
  // 1190
  // You are given a string s that consists of lower case English letters and
  // brackets.
  //
  // Reverse the strings in each pair of matching parentheses, starting from the
  // innermost one.
  //
  // Your result should not contain any brackets.
  //
  //
  // Example 1:
  //
  //
  // Input: s = "(abcd)"
  // Output: "dcba"
  //
  //
  // Example 2:
  //
  //
  // Input: s = "(u(love)i)"
  // Output: "iloveu"
  // Explanation: The substring "love" is reversed first, then the whole string is
  // reversed.
  //
  //
  // Example 3:
  //
  //
  // Input: s = "(ed(et(oc))el)"
  // Output: "leetcode"
  // Explanation: First, we reverse the substring "oc", then "etco", and finally,
  // the whole string.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 2000
  // s only contains lower case English characters and parentheses.
  // It is guaranteed that all parentheses are balanced.
  //
  // Related Topics String Stack 👍 1404 👎 39

  public static void main(String[] args) {
    Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
    String[] data = """
          "(abcd)"
      "(u(love)i)"
      "(ed(et(oc))el)"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.reverseParentheses((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reverseParentheses(String s) {
      Deque<String> stack = new LinkedList<String>();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == '(') {
          stack.push(sb.toString());
          sb.setLength(0);
        } else if (ch == ')') {
          sb.reverse();
          sb.insert(0, stack.pop());
        } else {
          sb.append(ch);
        }
      }
      return sb.toString();
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
  class AnotherSolution {
    public String reverseParentheses(String s) {
      int n = s.length();
      int[] pair = new int[n];
      Deque<Integer> stack = new LinkedList<Integer>();
      for (int i = 0; i < n; i++) {
        if (s.charAt(i) == '(') {
          stack.push(i);
        } else if (s.charAt(i) == ')') {
          int j = stack.pop();
          pair[i] = j;
          pair[j] = i;
        }
      }

      StringBuilder sb = new StringBuilder();
      int index = 0, step = 1;
      while (index < n) {
        if (s.charAt(index) == '(' || s.charAt(index) == ')') {
          index = pair[index];
          step = -step;
        } else {
          sb.append(s.charAt(index));
        }
        index += step;
      }
      return sb.toString();
    }
  }

}
