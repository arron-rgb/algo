package edu.neu.algo.review.leetcode.editor.en._20230216;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class MaximumSumOfDistinctSubarraysWithLengthK {
  // 2461
  // You are given an integer array nums and an integer k. Find the maximum
  // subarray sum of all the subarrays of nums that meet the following conditions:
  //
  //
  // The length of the subarray is k, and
  // All the elements of the subarray are distinct.
  //
  //
  // Return the maximum subarray sum of all the subarrays that meet the
  // conditions. If no subarray meets the conditions, return 0.
  //
  // A subarray is a contiguous non-empty sequence of elements within an array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,5,4,2,9,9,9], k = 3
  // Output: 15
  // Explanation: The subarrays of nums with length 3 are:
  // - [1,5,4] which meets the requirements and has a sum of 10.
  // - [5,4,2] which meets the requirements and has a sum of 11.
  // - [4,2,9] which meets the requirements and has a sum of 15.
  // - [2,9,9] which does not meet the requirements because the element 9 is
  // repeated.
  // - [9,9,9] which does not meet the requirements because the element 9 is
  // repeated.
  // We return 15 because it is the maximum subarray sum of all the subarrays that
  // meet the conditions
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [4,4,4], k = 3
  // Output: 0
  // Explanation: The subarrays of nums with length 3 are:
  // - [4,4,4] which does not meet the requirements because the element 4 is
  // repeated.
  // We return 0 because no subarrays meet the conditions.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= k <= nums.length <= 10⁵
  // 1 <= nums[i] <= 10⁵
  //
  //
  // Related Topics Array Hash Table Sliding Window 👍 559 👎 9

  public static void main(String[] args) {
    Solution solution = new MaximumSumOfDistinctSubarraysWithLengthK().new Solution();
    String[] data = """
                  [1,5,4,2,9,9,9]
      3
      [4,4,4]
      3
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      long q = solution.maximumSubarraySum((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
      int max = -1;
      for (int i : nums) {
        max = Math.max(i, max);
      }
      int[] freq = new int[max + 1];
      int n = nums.length;
      long sum = 0;
      long res = 0;
      int count = 0;
      int left = 0, right = 0;
      for (; right < n; right++) {
        if (freq[nums[right]]++ == 0) {
          count++;
        }
        sum += nums[right];
        if (right >= k - 1) {
          if (count == k) {
            res = Math.max(res, sum);
          }
          // 注意一下为什么count--需要加个if判断
          if (--freq[nums[left]] == 0) {
            count--;
          }
          sum -= nums[left];
          left++;
        }

      }
      return res;
    }
  }
  // runtime:7 ms
  // memory:73.9 MB

  // leetcode submit region end(Prohibit modification and deletion)

}
