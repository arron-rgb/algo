package edu.neu.algo.monotonic.leetcode.editor.en._20220803;

import java.util.*;
import edu.neu.util.InputUtil;

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
  // Related Topics Array Backtracking Bit Manipulation 👍 11271 👎 167

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
      List<List<Integer>> q = solution.subsets((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> list = new ArrayList<>();
      dfs(0, nums, new ArrayList<>(), list);
      return list;
    }

    void dfs(int index, int[] nums, List<Integer> cur, List<List<Integer>> list) {
      if (index == nums.length) {
        list.add(new ArrayList<>(cur));
        return;
      }
      cur.add(nums[index]);
      dfs(index + 1, nums, cur, list);
      cur.remove(cur.size() - 1);
      dfs(index + 1, nums, cur, list);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
