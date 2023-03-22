package edu.neu.algo.review.leetcode.editor.en._20230211;

import edu.neu.util.InputUtil;
import edu.neu.base.*;

import java.util.*;

public class Permutations {
  // 46
  // Given an array nums of distinct integers, return all the possible
  // permutations. You can return the answer in any order.
  //
  //
  // Example 1:
  // Input: nums = [1,2,3]
  // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  //
  // Example 2:
  // Input: nums = [0,1]
  // Output: [[0,1],[1,0]]
  //
  // Example 3:
  // Input: nums = [1]
  // Output: [[1]]
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 6
  // -10 <= nums[i] <= 10
  // All the integers of nums are unique.
  //
  //
  // Related Topics Array Backtracking 👍 14647 👎 250

  public static void main(String[] args) {
    Solution solution = new Permutations().new Solution();
    String[] data = """
                  [1,2,3]
      [0,1]
      [1]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<List<Integer>> q = solution.permute((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
      res = new ArrayList<>();
      int n = nums.length;
      boolean[] onPath = new boolean[n];
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        list.add(0);
      }
      dfs(onPath, 0, list, nums);
      return res;
    }

    void dfs(boolean[] onPath, int index, List<Integer> tmp, int[] nums) {
      if (index == nums.length) {
        res.add(new ArrayList<>(tmp));
        return;
      }
      for (int j = 0; j < nums.length; j++) {
        // 往tmp[index]里放每个可以放进去的数
        if (onPath[j]) {
          continue;
        }
        onPath[j] = true;
        tmp.set(index, nums[j]);
        dfs(onPath, index + 1, tmp, nums);
        onPath[j] = false;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
