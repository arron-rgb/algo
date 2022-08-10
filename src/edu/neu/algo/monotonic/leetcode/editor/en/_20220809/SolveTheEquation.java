package edu.neu.algo.monotonic.leetcode.editor.en._20220809;

import java.util.*;
import edu.neu.util.InputUtil;

public class SolveTheEquation {
  // 640
  // Solve a given equation and return the value of 'x' in the form of a string "x=
  // #value". The equation contains only '+', '-' operation, the variable 'x' and
  // its coefficient. You should return "No solution" if there is no solution for the
  // equation, or "Infinite solutions" if there are infinite solutions for the
  // equation.
  //
  // If there is exactly one solution for the equation, we ensure that the value
  // of 'x' is an integer.
  //
  //
  // Example 1:
  //
  //
  // Input: equation = "x+5-3+x=6+x-2"
  // Output: "x=2"
  //
  //
  // Example 2:
  //
  //
  // Input: equation = "x=x"
  // Output: "Infinite solutions"
  //
  //
  // Example 3:
  //
  //
  // Input: equation = "2x=x"
  // Output: "x=0"
  //
  //
  //
  // Constraints:
  //
  //
  // 3 <= equation.length <= 1000
  // equation has exactly one '='.
  // equation consists of integers with an absolute value in the range [0, 100]
  // without any leading zeros, and the variable 'x'.
  //
  // Related Topics Math String Simulation 👍 376 👎 724

  public static void main(String[] args) {
    Solution solution = new SolveTheEquation().new Solution();
    String[] data = """
          "x+5-3+x=6+x-2"
      "x=x"
      "2x=x"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      String q = solution.solveEquation((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String solveEquation(String equation) {
      int factor = 0, val = 0;
      int index = 0, n = equation.length(), sign1 = 1; // 等式左边默认系数为正
      while (index < n) {
        if (equation.charAt(index) == '=') {
          sign1 = -1; // 等式右边默认系数为负
          index++;
          continue;
        }

        int sign2 = sign1, number = 0;
        boolean valid = false; // 记录 number 是否有效
        if (equation.charAt(index) == '-' || equation.charAt(index) == '+') { // 去掉前面的符号
          sign2 = (equation.charAt(index) == '-') ? -sign1 : sign1;
          index++;
        }
        while (index < n && Character.isDigit(equation.charAt(index))) {
          number = number * 10 + (equation.charAt(index) - '0');
          index++;
          valid = true;
        }

        if (index < n && equation.charAt(index) == 'x') { // 变量
          factor += valid ? sign2 * number : sign2;
          index++;
        } else { // 数值
          val += sign2 * number;
        }
      }

      if (factor == 0) {
        return val == 0 ? "Infinite solutions" : "No solution";
      }
      if (val % factor != 0) {
        return "No solution";
      }
      return "x=" + (-val / factor);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
