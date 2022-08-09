package edu.neu.algo.monotonic.leetcode.editor.en._20220803;

import java.util.*;
import edu.neu.util.InputUtil;

public class GenerateParentheses {
  // 22
  // Given n pairs of parentheses, write a function to generate all combinations
  // of well-formed parentheses.
  //
  //
  // Example 1:
  // Input: n = 3
  // Output: ["((()))","(()())","(())()","()(())","()()()"]
  // Example 2:
  // Input: n = 1
  // Output: ["()"]
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 8
  //
  // Related Topics String Dynamic Programming Backtracking 👍 14325 👎 539

  public static void main(String[] args) {
    Solution solution = new GenerateParentheses().new Solution();
    String[] data = """
          3
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<String> q = solution.generateParenthesis((int)params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> list = new ArrayList<>();
      backtrack(0, 0, list, "", n);
      return list;
    }

    void backtrack(int open, int close, List<String> ans, String cur, int max) {
      if (cur.length() == max * 2) {
        ans.add(cur);
        return;
      }

      if (open < max) {
        backtrack(open + 1, close, ans, cur + "(", max);
      }
      if (close < open) {
        backtrack(open, close + 1, ans, cur + ")", max);
      }

    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
