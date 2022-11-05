package edu.neu.algo.review.leetcode.editor.en._20221104;

import java.util.*;
import edu.neu.util.InputUtil;

public class ParsingABooleanExpression {
  // 1106
  // A boolean expression is an expression that evaluates to either true or false.
  // It can be in one of the following shapes:
  //
  //
  // 't' that evaluates to true.
  // 'f' that evaluates to false.
  // '!(subExpr)' that evaluates to the logical NOT of the inner expression
  // subExpr.
  // '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of
  // the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
  // '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of
  // the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
  //
  //
  // Given a string expression that represents a boolean expression, return the
  // evaluation of that expression.
  //
  // It is guaranteed that the given expression is valid and follows the given
  // rules.
  //
  //
  // Example 1:
  //
  //
  // Input: expression = "&(|(f))"
  // Output: false
  // Explanation:
  // First, evaluate |(f) --> f. The expression is now "&(f)".
  // Then, evaluate &(f) --> f. The expression is now "f".
  // Finally, return false.
  //
  //
  // Example 2:
  //
  //
  // Input: expression = "|(f,f,f,t)"
  // Output: true
  // Explanation: The evaluation of (false OR false OR false OR true) is true.
  //
  //
  // Example 3:
  //
  //
  // Input: expression = "!(&(f,t))"
  // Output: true
  // Explanation:
  // First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression
  // is now "!(f)".
  // Then, evaluate !(f) --> NOT false --> true. We return true.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= expression.length <= 2 * 10⁴
  // expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f',
  // and ','.
  //
  // Related Topics String Stack Recursion 👍 801 👎 44

  public static void main(String[] args) {
    Solution solution = new ParsingABooleanExpression().new Solution();
    String[] data = """
      "!(f)"
      "&(t,f)"
      "|(f,t)"
      """.trim().replaceAll("\n", "<newLine>").split("<newLine>");
    String[] paramTypes = InputUtil.param("[String]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.parseBoolExpr((String)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean parseBoolExpr(String ex) {
      if ("t".equals(ex)) {
        return true;
      }
      if ("f".equals(ex)) {
        return false;
      }
      char start = ex.charAt(0);
      int n = ex.length();
      if (start == '!') {
        // 2: pass !(
        // n-1: pass )
        return !parseBoolExpr(ex.substring(2, n - 1));
      }
      ex = ex.substring(2, n - 1) + ",";
      for (int i = 0, j = 0, count = 0; i < n - 2; i++) {
        char ch = ex.charAt(i);
        // start
        if (ch == '(') {
          count++;
        } else if (ch == ')') {
          // end
          count--;
        } else if (ch == ',' && count == 0) {
          boolean b = parseBoolExpr(ex.substring(j, i));
          if (start == '|' && b) {
            return true;
          }
          if (start == '&' && !b) {
            return false;
          }
          j = i + 1;
        }
      }
      return start == '&';
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
