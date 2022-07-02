package edu.neu.algo.leetcode.editor.en._20220701;

import java.util.ArrayList;
import java.util.List;

import edu.neu.util.InputUtil;

public class FindAllDuplicatesInAnArray {
  // 442
  // Given an integer array nums of length n where all the integers of nums are in
  // the range [1, n] and each integer appears once or twice, return an array of all
  // the integers that appears twice.
  //
  // You must write an algorithm that runs in O(n) time and uses only constant
  // extra space.
  //
  //
  // Example 1:
  // Input: nums = [4,3,2,7,8,2,3,1]
  // Output: [2,3]
  // Example 2:
  // Input: nums = [1,1,2]
  // Output: [1]
  // Example 3:
  // Input: nums = [1]
  // Output: []
  //
  //
  // Constraints:
  //
  //
  // n == nums.length
  // 1 <= n <= 10⁵
  // 1 <= nums[i] <= n
  // Each element in nums appears once or twice.
  //
  // Related Topics Array Hash Table 👍 6534 👎 257

  public static void main(String[] args) {
    Solution solution = new FindAllDuplicatesInAnArray().new Solution();
    String[] data = """
          [1,4,3,2,7,2,3,1]
      [1,1,2]
      [1]
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      List<Integer> q = solution.findDuplicates((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> findDuplicates(int[] nums) {
      int n = nums.length;
      for (int i = 0; i < n; ++i) {
        while (nums[i] != nums[nums[i] - 1]) {
          swap(nums, i, nums[i] - 1);
        }
      }
      List<Integer> ans = new ArrayList<>();
      for (int i = 0; i < n; ++i) {
        if (nums[i] - 1 != i) {
          ans.add(nums[i]);
        }
      }
      return ans;
    }

    void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
