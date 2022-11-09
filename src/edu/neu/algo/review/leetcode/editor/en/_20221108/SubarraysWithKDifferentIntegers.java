package edu.neu.algo.review.leetcode.editor.en._20221108;

import edu.neu.util.InputUtil;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

  // Given an integer array nums and an integer k, return the number of good
  // subarrays of nums.
  //
  // A good array is an array where the number of different integers in that
  // array is exactly k.
  //
  //
  // For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
  //
  //
  // A subarray is a contiguous part of an array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,2,1,2,3], k = 2
  // Output: 7
  // Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1],
  // [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [1,2,1,3,4], k = 3
  // Output: 3
  // Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2
  // ,1,3], [1,3,4].
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 2 * 10⁴
  // 1 <= nums[i], k <= nums.length
  //
  // Related Topics Array Hash Table Sliding Window Counting 👍 3755 👎 55

  public static void main(String[] args) {
    Solution solution = new SubarraysWithKDifferentIntegers().new Solution();
    String[] data = """
      [1,2,1,3,4]
      3""".trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.subarraysWithKDistinct((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
      // 恰好为k: >=k的数量 - >=k-1的数量
      return help(nums, k) - help(nums, k - 1);
    }

    public int help(int[] nums, int k) {
      Map<Integer, Integer> m = new HashMap<>();
      int left = 0, right = 0;
      int res = 0;
      int n = nums.length;
      while (right < n) {
        m.put(nums[right], m.getOrDefault(nums[right], 0) + 1);
        while (m.size() >= k) {
          int v = m.get(nums[left]);
          if (v == 1) {
            m.remove(nums[left]);
          } else {
            m.put(nums[left], v - 1);
          }
          left++;
        }
        res += (right - left);
        right++;
      }
      return res;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
