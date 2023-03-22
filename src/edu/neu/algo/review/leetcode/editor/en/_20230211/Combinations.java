package edu.neu.algo.review.leetcode.editor.en._20230211;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class Combinations {
  // 77
  // Given two integers n and k, return all possible combinations of k numbers
  // chosen from the range [1, n].
  //
  // You may return the answer in any order.
  //
  //
  // Example 1:
  //
  //
  // Input: n = 4, k = 2
  // Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
  // Explanation: There are 4 choose 2 = 6 total combinations.
  // Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to
  // be the same combination.
  //
  //
  // Example 2:
  //
  //
  // Input: n = 1, k = 1
  // Output: [[1]]
  // Explanation: There is 1 choose 1 = 1 total combination.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= n <= 20
  // 1 <= k <= n
  //
  //
  // Related Topics Backtracking 👍 5676 👎 177

  public static void main(String[] args) {
    Solution solution = new Combinations().new Solution();
    String[] data = """
                  4
      2
      1
      1
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q =
        solution.combine((int)params[1 - 1 + i * paramTypes.length], (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
      res = new ArrayList<>();
      dfs(new ArrayList<>(), n, k, 1);
      return res;
    }

    void dfs(List<Integer> tmp, int n, int k, int s) {
      if (tmp.size() == k) {
        res.add(new ArrayList<>(tmp));
        return;
      }
      for (int i = s; i <= n; i++) {
        tmp.add(i);
        dfs(tmp, n, k, i + 1);
        tmp.remove(tmp.size() - 1);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
