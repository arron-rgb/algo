package edu.neu.algo.review.leetcode.editor.en._20230211;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class GenerateParentheses {
  // 22
  // Given n pairs of parentheses, write a function to generate all combinations
  // of well-formed parentheses.
  //
  //
  // Example 1:
  // Input: n = 3
  // Output: ["((()))","(()())","(())()","()(())","()()()"]
  //
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
  //
  // Related Topics String Dynamic Programming Backtracking 👍 16890 👎 672

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
      List<String> q = solution.generateParenthesis((int)params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
      res = new ArrayList<>();
      dfs(n, 0, 0, "");
      return res;
    }

    void dfs(int n, int left, int right, String s) {
      if (left < right || left > n) {
        return;
      }
      if (left == right && left == n) {
        res.add(s);
        return;
      }
      // ( 最多可以添加 n个
      if (left > right) {
        dfs(n, left, right + 1, s + ")");
      }
      dfs(n, left + 1, right, s + "(");
      // ) 必须在 left > right的情况下添加
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
