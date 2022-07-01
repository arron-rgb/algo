package edu.neu.algo.leetcode.editor.en._20220701;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.util.InputUtil;

public class DifferentWaysToAddParentheses {
  //
  //
  // 241 Given a string expression of numbers and operators, return all possible
  // results from computing all the different possible ways to group numbers and operators.
  // You may return the answer in any order.
  //
  // The test cases are generated such that the output values fit in a 32-bit
  // integer and the number of different results does not exceed 10⁴.
  //
  //
  // Example 1:
  //
  //
  // Input: expression = "2-1-1"
  // Output: [0,2]
  // Explanation:
  // ((2-1)-1) = 0
  // (2-(1-1)) = 2
  //
  //
  // Example 2:
  //
  //
  // Input: expression = "2*3-4*5"
  // Output: [-34,-14,-10,-10,10]
  // Explanation:
  // (2*(3-(4*5))) = -34
  // ((2*3)-(4*5)) = -14
  // ((2*(3-4))*5) = -10
  // (2*((3-4)*5)) = -10
  // (((2*3)-4)*5) = 10
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= expression.length <= 20
  // expression consists of digits and the operator '+', '-', and '*'.
  // All the integer values in the input expression are in the range [0, 99].
  //
  // Related Topics Math String Dynamic Programming Recursion Memoization 👍 3793
  // 👎 189

  public static void main(String[] args) {
    Solution solution = new DifferentWaysToAddParentheses().new Solution();
    String[] data = """
          "2-1-1"
      "2*3-4*5"
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.diffWaysToCompute((String)params[i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c == '+' || c == '-' || c == '*') {
          String p1 = input.substring(0, i);
          String p2 = input.substring(i + 1);
          List<Integer> l1 = map.getOrDefault(p1, diffWaysToCompute(p1));
          List<Integer> l2 = map.getOrDefault(p2, diffWaysToCompute(p2));
          for (int i1 : l1) {
            for (int i2 : l2) {
              int r = switch (c) {
                case '+' -> i1 + i2;
                case '-' -> i1 - i2;
                case '*' -> i1 * i2;
                default -> 0;
              };
              res.add(r);
            }
          }
        }
      }
      if (res.size() == 0) {
        res.add(Integer.valueOf(input));
      }
      map.put(input, res);
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
