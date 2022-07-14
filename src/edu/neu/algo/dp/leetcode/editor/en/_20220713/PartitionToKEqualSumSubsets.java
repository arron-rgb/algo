package edu.neu.algo.dp.leetcode.editor.en._20220713;

import java.util.*;
import edu.neu.util.InputUtil;

public class PartitionToKEqualSumSubsets {
  // 698
  // Given an integer array nums and an integer k, return true if it is possible
  // to divide this array into k non-empty subsets whose sums are all equal.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [4,3,2,3,5,2,1], k = 4
  // Output: true
  // Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2
  // ,3) with equal sums.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,3,4], k = 3
  // Output: false
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= k <= nums.length <= 16
  // 1 <= nums[i] <= 10⁴
  // The frequency of each element is in the range [1, 4].
  //
  // Related Topics Array Dynamic Programming Backtracking Bit Manipulation
  // Memoization Bitmask 👍 5246 👎 350

  public static void main(String[] args) {
    Solution solution = new PartitionToKEqualSumSubsets().new Solution();
    String[] data = """
          [4,3,2,3,5,2,1]
      4
      [1,2,3,4]
      3
      [10,1,10,9,6,1,9,5,9,10,7,8,5,2,10,8]
      11
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      boolean q = solution.canPartitionKSubsets((int[])params[1 + i * paramTypes.length - 1],
        (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
      int sum = 0;
      for (int n : nums) {
        sum += n;
      }
      if (sum % k != 0) {
        return false;
      }
      Arrays.sort(nums);
      reverse(nums);
      return dfs(nums, new int[k], sum / k, 0);
    }

    private boolean dfs(int[] nums, int[] sums, int target, int index) {
      if (index == nums.length) {
        for (int sum : sums) {
          if (sum != target) {
            return false;
          }
        }
        return true;
      }

      for (int i = 0; i < sums.length; i++) {
        if (i > 0 && sums[i] == sums[i - 1]) {
          continue;
        }
        if (sums[i] + nums[index] > target) {
          continue;
        }
        sums[i] += nums[index];
        if (dfs(nums, sums, target, index + 1)) {
          return true;
        }
        sums[i] -= nums[index];
      }
      return false;
    }

    private void reverse(int[] nums) {
      int i = 0, j = nums.length - 1;
      while (i < j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
