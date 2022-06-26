package edu.neu.algo.leetcode.editor.en._20220625;

import java.util.ArrayList;
import java.util.List;

import edu.neu.util.InputUtil;

public class ExpressionAddOperators {

  // Given a string num that contains only digits and an integer target, return
  // all possibilities to insert the binary operators '+', '-', and/or '*' between the
  // digits of num so that the resultant expression evaluates to the target value.
  //
  // Note that operands in the returned expressions should not contain leading
  // zeros.
  //
  //
  // Example 1:
  //
  //
  // Input: num = "123", target = 6
  // Output: ["1*2*3","1+2+3"]
  // Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
  //
  //
  // Example 2:
  //
  //
  // Input: num = "232", target = 8
  // Output: ["2*3+2","2+3*2"]
  // Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
  //
  //
  // Example 3:
  //
  //
  // Input: num = "3456237490", target = 9191
  // Output: []
  // Explanation: There are no expressions that can be created from "3456237490"
  // to evaluate to 9191.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= num.length <= 10
  // num consists of only digits.
  // -2³¹ <= target <= 2³¹ - 1
  //
  // Related Topics Math String Backtracking 👍 2561 👎 449

  public static void main(String[] args) {
    Solution solution = new ExpressionAddOperators().new Solution();
    String[] data = """
          "105"
      5
      "232"
      8
      "3456237490"
      9191
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[String, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.addOperators((String)params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)

  class Solution {
    List<String> ans = new ArrayList<>();
    String s;
    int n, t;

    public List<String> addOperators(String num, int target) {
      s = num;
      n = s.length();
      t = target;
      dfs(0, 0, 0, "");
      return ans;
    }

    void dfs(int index, long prev, long cur, String ss) {
      if (index == n) {
        if (cur == t) {
          ans.add(ss);
        }
        return;
      }
      for (int i = index; i < n; i++) {
        if (i != index && s.charAt(index) == '0') {
          break;
        }
        long next = Long.parseLong(s.substring(index, i + 1));
        if (index == 0) {
          dfs(i + 1, next, next, "" + next);
        } else {
          dfs(i + 1, next, cur + next, ss + "+" + next);
          dfs(i + 1, -next, cur - next, ss + "-" + next);
          long x = prev * next;
          dfs(i + 1, x, cur - prev + x, ss + "*" + next);
        }
      }
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
