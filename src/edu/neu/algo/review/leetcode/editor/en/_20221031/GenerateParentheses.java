package edu.neu.algo.review.leetcode.editor.en._20221031;

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
  // Related Topics String Dynamic Programming Backtracking 👍 15724 👎 605

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
      List<String> res = new ArrayList<>();
      dfs(0, 0, "", n, res);
      return res;
    }

    void dfs(int open, int close, String cur, int max, List<String> res) {
      if (cur.length() == max * 2) {
        res.add(cur);
        return;
      }
      if (open < max) {
        dfs(open + 1, close, cur + "(", max, res);
      }
      if (close < open) {
        dfs(open, close + 1, cur + ")", max, res);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
