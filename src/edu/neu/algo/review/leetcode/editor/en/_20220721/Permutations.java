package edu.neu.algo.review.leetcode.editor.en._20220721;

import java.util.*;
import edu.neu.util.InputUtil;

public class Permutations {
  // 46
  // Given an array nums of distinct integers, return all the possible
  // permutations. You can return the answer in any order.
  //
  //
  // Example 1:
  // Input: nums = [1,2,3]
  // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  // Example 2:
  // Input: nums = [0,1]
  // Output: [[0,1],[1,0]]
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
  // Related Topics Array Backtracking 👍 11748 👎 206

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
      List<List<Integer>> q = solution.permute((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> list = new ArrayList<>();
      List<Integer> tmp = new ArrayList<>();
      for (int num : nums) {
        tmp.add(num);
      }
      dfs(list, tmp, 0);
      return list;
    }

    void dfs(List<List<Integer>> list, List<Integer> tmp, int i) {
      if (i == tmp.size()) {
        list.add(new ArrayList<>(tmp));
        return;
      }
      for (int j = i; j < tmp.size(); j++) {
        Collections.swap(tmp, j, i);
        dfs(list, tmp, i + 1);
        Collections.swap(tmp, j, i);
      }
    }

    void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
