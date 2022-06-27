package edu.neu.algo.leetcode.editor.en._20220627;

import edu.neu.util.InputUtil;

public class SubarraySumsDivisibleByK {

  // Given an integer array nums and an integer k, return the number of non-empty
  // subarrays that have a sum divisible by k.
  //
  // A subarray is a contiguous part of an array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [4,5,0,-2,-3,1], k = 5
  // Output: 7
  // Explanation: There are 7 subarrays with a sum divisible by k = 5:
  // [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [5], k = 9
  // Output: 0
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 3 * 10⁴
  // -10⁴ <= nums[i] <= 10⁴
  // 2 <= k <= 10⁴
  //
  // Related Topics Array Hash Table Prefix Sum 👍 3051 👎 136

  public static void main(String[] args) {
    Solution solution = new SubarraySumsDivisibleByK().new Solution();
    String[] data = """
          [4,5,0,-2,-3,1]
      5
      [5]
      9
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.subarraysDivByK((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int subarraysDivByK(int[] nums, int k) {
      int[] count = new int[k];
      count[0] = 1;
      int prefix = 0, res = 0;
      for (int n : nums) {
        prefix = (prefix + n % k + k) % k;
        res = res + count[prefix]++;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
