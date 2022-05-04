package edu.neu.algo.leetcode.editor.en._20220504;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorII {

  // Given a string s which represents an expression, evaluate this expression and
  // return its value.
  //
  // The integer division should truncate toward zero.
  //
  // You may assume that the given expression is always valid. All intermediate
  // results will be in the range of [-2³¹, 2³¹ - 1].
  //
  // Note: You are not allowed to use any built-in function which evaluates
  // strings as mathematical expressions, such as eval().
  //
  //
  // Example 1:
  // Input: s = "3+2*2"
  // Output: 7
  // Example 2:
  // Input: s = " 3/2 "
  // Output: 1
  // Example 3:
  // Input: s = " 3+5 / 2 "
  // Output: 5
  //
  //
  // Constraints:
  //
  //
  // 1 <= s.length <= 3 * 10⁵
  // s consists of integers and operators ('+', '-', '*', '/') separated by some
  // number of spaces.
  // s represents a valid expression.
  // All the integers in the expression are non-negative integers in the range [0,
  // 2³¹ - 1].
  // The answer is guaranteed to fit in a 32-bit integer.
  //
  // Related Topics Math String Stack 👍 4255 👎 563

  public static void main(String[] args) {
    Solution solution = new BasicCalculatorII().new Solution();
    // int calculate = solution.calculate("3+2*2");
    // System.out.println(calculate);
    // calculate = solution.calculate(" 3/2 ");
    // System.out.println(calculate);
    int calculate = solution.calculate(" 3+5 / 2 ");
    System.out.println(calculate);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int calculate(String s) {
      Deque<Integer> deque = new ArrayDeque<>();
      char[] chars = s.trim().toCharArray();
      int i = 0;
      char operation = '~';
      while (i < chars.length) {
        int start = i;
        int num = 0;
        while (start < chars.length && chars[start] == ' ') {
          start++;
        }
        // get the number
        while (start < chars.length && Character.isDigit(chars[start])) {
          num = num * 10 + chars[start] - '0';
          start++;
        }
        if (operation == '+' || operation == '~') {
          deque.offerLast(num);
        } else if (operation == '-') {
          deque.offerLast(-num);
        } else if (operation == '*') {
          deque.offerLast(deque.pollLast() * num);
        } else if (operation == '/') {
          deque.offerLast(deque.pollLast() / num);
        }
        // go to the next operation
        while (start < chars.length && chars[start] == ' ') {
          start++;
        }
        if (start > chars.length - 1) {
          break;
        }
        operation = chars[start];
        i = ++start;
      }
      return deque.stream().mapToInt(t -> t).sum();
    }

    int[] getNumber(char[] tmp, int start) {
      int num = 0;
      while (start < tmp.length && Character.isDigit(tmp[start])) {
        num = num * 10 + tmp[start] - '0';
        start++;
      }
      return new int[] {num, start};
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
