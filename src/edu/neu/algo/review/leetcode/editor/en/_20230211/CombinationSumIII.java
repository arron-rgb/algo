package edu.neu.algo.review.leetcode.editor.en._20230211;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class CombinationSumIII {
  // 216
  // Find all valid combinations of k numbers that sum up to n such that the
  // following conditions are true:
  //
  //
  // Only numbers 1 through 9 are used.
  // Each number is used at most once.
  //
  //
  // Return a list of all possible valid combinations. The list must not contain
  // the same combination twice, and the combinations may be returned in any order.
  //
  //
  // Example 1:
  //
  //
  // Input: k = 3, n = 7
  // Output: [[1,2,4]]
  // Explanation:
  // 1 + 2 + 4 = 7
  // There are no other valid combinations.
  //
  // Example 2:
  //
  //
  // Input: k = 3, n = 9
  // Output: [[1,2,6],[1,3,5],[2,3,4]]
  // Explanation:
  // 1 + 2 + 6 = 9
  // 1 + 3 + 5 = 9
  // 2 + 3 + 4 = 9
  // There are no other valid combinations.
  //
  //
  // Example 3:
  //
  //
  // Input: k = 4, n = 1
  // Output: []
  // Explanation: There are no valid combinations.
  // Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
  // +2+3+4 = 10 and since 10 > 1, there are no valid combination.
  //
  //
  //
  // Constraints:
  //
  //
  // 2 <= k <= 9
  // 1 <= n <= 60
  //
  //
  // Related Topics Array Backtracking 👍 4687 👎 96

  public static void main(String[] args) {
    Solution solution = new CombinationSumIII().new Solution();
    String[] data = """
                  3
      7
      3
      9
      4
      1
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int, int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.combinationSum3((int)params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
      res = new ArrayList<>();
      dfs(k, n, new ArrayList<>(), 1);
      return res;
    }

    void dfs(int k, int n, List<Integer> tmp, int i) {
      if (k == 0 && n == 0) {
        res.add(new ArrayList<>(tmp));
        return;
      }

      for (int j = i; j < 10; j++) {
        if (j > n) {
          break;
        }
        tmp.add(j);
        dfs(k - 1, n - j, tmp, j + 1);
        tmp.remove(tmp.size() - 1);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
