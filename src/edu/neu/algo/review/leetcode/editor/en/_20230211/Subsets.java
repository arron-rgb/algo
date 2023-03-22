package edu.neu.algo.review.leetcode.editor.en._20230211;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class Subsets {
  // 78
  // Given an integer array nums of unique elements, return all possible subsets (
  // the power set).
  //
  // The solution set must not contain duplicate subsets. Return the solution in
  // any order.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,3]
  // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [0]
  // Output: [[],[0]]
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10
  // -10 <= nums[i] <= 10
  // All the numbers of nums are unique.
  //
  //
  // Related Topics Array Backtracking Bit Manipulation 👍 13561 👎 191

  public static void main(String[] args) {
    Solution solution = new Subsets().new Solution();
    String[] data = """
                  [1,2,3]
      [0]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.subsets((int[])params[i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
      res = new ArrayList<>();
      anotherDfs(nums, 0, new ArrayList<>());
      return res;
    }

    void dfs(int[] nums, int i, List<Integer> tmp) {
      // 当前操作: 选或者不选nums[i]
      if (i == nums.length) {
        res.add(new ArrayList<>(tmp));
        return;
      }
      dfs(nums, i + 1, tmp);

      tmp.add(nums[i]);
      dfs(nums, i + 1, tmp);
      tmp.remove(tmp.size() - 1);
    }

    void anotherDfs(int[] nums, int i, List<Integer> tmp) {
      // 在进入分支前就给他加入
      // 这样保证了不选的情况
      res.add(new ArrayList<>(tmp));
      if (i == nums.length) {
        return;
      }

      //
      for (int j = i; j < nums.length; j++) {
        tmp.add(nums[j]);
        anotherDfs(nums, j + 1, tmp);
        tmp.remove(tmp.size() - 1);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
