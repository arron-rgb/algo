package edu.neu.algo.leetcode.editor.en._20220708;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import edu.neu.util.InputUtil;

public class EvaluateReversePolishNotation {
  // 150
  // Evaluate the value of an arithmetic expression in Reverse Polish Notation.
  //
  // Valid operators are +, -, *, and /. Each operand may be an integer or
  // another expression.
  //
  // Note that division between two integers should truncate toward zero.
  //
  // It is guaranteed that the given RPN expression is always valid. That means
  // the expression would always evaluate to a result, and there will not be any
  // division by zero operation.
  //
  //
  // Example 1:
  //
  //
  // Input: tokens = ["2","1","+","3","*"]
  // Output: 9
  // Explanation: ((2 + 1) * 3) = 9
  //
  //
  // Example 2:
  //
  //
  // Input: tokens = ["4","13","5","/","+"]
  // Output: 6
  // Explanation: (4 + (13 / 5)) = 6
  //
  //
  // Example 3:
  //
  //
  // Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
  // Output: 22
  // Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
  // = ((10 * (6 / (12 * -11))) + 17) + 5
  // = ((10 * (6 / -132)) + 17) + 5
  // = ((10 * 0) + 17) + 5
  // = (0 + 17) + 5
  // = 17 + 5
  // = 22
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= tokens.length <= 10⁴
  // tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
  // range [-200, 200].
  //
  // Related Topics Array Math Stack 👍 3433 👎 657

  public static void main(String[] args) {
    Solution solution = new EvaluateReversePolishNotation().new Solution();
    String[] data = """
          ["2","1","+","3","*"]
      ["4","13","5","/","+"]
      ["4","3","-"]
      ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.evalRPN((String[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int evalRPN(String[] tokens) {
      Deque<Integer> deque = new ArrayDeque<>();
      Set<String> operations = new HashSet<>() {
        {
          add("+");
          add("/");
          add("*");
          add("-");
        }
      };
      for (String token : tokens) {

        if (operations.contains(token)) {
          switch (token) {
            case "+" -> deque.push(deque.pop() + deque.pop());
            case "-" -> {
              int tmp = deque.pop();
              deque.push(deque.pop() - tmp);
            }
            case "*" -> deque.push(deque.pop() * deque.pop());
            case "/" -> {
              int tmp = deque.pop();
              deque.push(deque.pop() / tmp);
            }
          }
        } else {
          int e = Integer.parseInt(token);
          deque.push(e);
        }
      }
      return deque.peek();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
