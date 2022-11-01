package edu.neu.algo.review.leetcode.editor.en._20221101;

import java.util.*;
import edu.neu.util.InputUtil;

public class CombinationSum {
  // 39
  // Given an array of distinct integers candidates and a target integer target,
  // return a list of all unique combinations of candidates where the chosen numbers
  // sum to target. You may return the combinations in any order.
  //
  // The same number may be chosen from candidates an unlimited number of times.
  // Two combinations are unique if the frequency of at least one of the chosen
  // numbers is different.
  //
  // The test cases are generated such that the number of unique combinations
  // that sum up to target is less than 150 combinations for the given input.
  //
  //
  // Example 1:
  //
  //
  // Input: candidates = [2,3,6,7], target = 7
  // Output: [[2,2,3],[7]]
  // Explanation:
  // 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
  // times.
  // 7 is a candidate, and 7 = 7.
  // These are the only two combinations.
  //
  //
  // Example 2:
  //
  //
  // Input: candidates = [2,3,5], target = 8
  // Output: [[2,2,2,2],[2,3,3],[3,5]]
  //
  //
  // Example 3:
  //
  //
  // Input: candidates = [2], target = 1
  // Output: []
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= candidates.length <= 30
  // 2 <= candidates[i] <= 40
  // All elements of candidates are distinct.
  // 1 <= target <= 40
  //
  // Related Topics Array Backtracking 👍 13954 👎 284

  public static void main(String[] args) {
    Solution solution = new CombinationSum().new Solution();
    String[] data = """
          [2,3,6,7]
      7
      [2,3,5]
      8
      [2]
      1
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.combinationSum((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(candidates);
      dfs(res, new ArrayList<>(), candidates, target, 0);
      return res;
    }

    /**
     * @param res
     * @param tmp
     * @param nums
     * @param target
     * @param start
     *          从数组的某个位置开始寻找，避免[2,2,3], [2,3,2]重复
     */
    void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int target, int start) {
      if (target == 0) {
        res.add(new ArrayList<>(tmp));
        return;
      }
      for (int i = start; i < nums.length; i++) {
        int num = nums[i];
        // 后面必不可能出现符合条件的组合
        if (target < num) {
          break;
        }
        tmp.add(num);
        dfs(res, tmp, nums, target - num, i);
        tmp.remove(tmp.size() - 1);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
