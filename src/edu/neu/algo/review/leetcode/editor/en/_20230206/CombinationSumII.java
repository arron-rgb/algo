package edu.neu.algo.review.leetcode.editor.en._20230206;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class CombinationSumII {
  // 40
  // Given a collection of candidate numbers (candidates) and a target number (
  // target), find all unique combinations in candidates where the candidate numbers sum
  // to target.
  //
  // Each number in candidates may only be used once in the combination.
  //
  // Note: The solution set must not contain duplicate combinations.
  //
  //
  // Example 1:
  //
  //
  // Input: candidates = [10,1,2,7,6,1,5], target = 8
  // Output:
  // [
  // [1,1,6],
  // [1,2,5],
  // [1,7],
  // [2,6]
  // ]
  //
  //
  // Example 2:
  //
  //
  // Input: candidates = [2,5,2,1,2], target = 5
  // Output:
  // [
  // [1,2,2],
  // [5]
  // ]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= candidates.length <= 100
  // 1 <= candidates[i] <= 50
  // 1 <= target <= 30
  //
  //
  // Related Topics Array Backtracking 👍 7846 👎 198

  public static void main(String[] args) {
    Solution solution = new CombinationSumII().new Solution();
    String[] data = """
                  [10,1,2,7,6,1,5]
      8
      [2,5,2,1,2]
      5
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.combinationSum2((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(candidates);
      dfs(res, new ArrayList<>(), candidates, 0, target);
      return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int index, int target) {
      if (target < 0) {
        return;
      }
      if (target == 0) {
        res.add(new ArrayList<>(tmp));
        return;
      }
      for (int i = index; i < candidates.length; i++) {
        int c = candidates[i];
        // 避免两个连续的
        if (i > index && c == candidates[i - 1]) {
          continue;
        }
        tmp.add(c);
        dfs(res, tmp, candidates, i + 1, target - c);
        tmp.remove(tmp.size() - 1);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
