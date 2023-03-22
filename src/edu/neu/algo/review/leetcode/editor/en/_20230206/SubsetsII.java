package edu.neu.algo.review.leetcode.editor.en._20230206;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class SubsetsII {
  // 90
  // Given an integer array nums that may contain duplicates, return all possible
  // subsets (the power set).
  //
  // The solution set must not contain duplicate subsets. Return the solution in
  // any order.
  //
  //
  // Example 1:
  // Input: nums = [1,2,2]
  // Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
  //
  // Example 2:
  // Input: nums = [0]
  // Output: [[],[0]]
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10
  // -10 <= nums[i] <= 10
  //
  //
  // Related Topics Array Backtracking Bit Manipulation 👍 7511 👎 214

  public static void main(String[] args) {
    Solution solution = new SubsetsII().new Solution();
    String[] data = """
                  [1,2,2]
      [0]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.subsetsWithDup((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
      dfs(res, new ArrayList<>(), nums, 0);
      return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index) {
      res.add(new ArrayList<>(tmp));
      for (int i = index; i < nums.length; i++) {
        if (i > index && nums[i] == nums[i - 1]) {
          continue;
        }
        tmp.add(nums[i]);
        dfs(res, tmp, nums, i + 1);
        tmp.remove(tmp.size() - 1);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
