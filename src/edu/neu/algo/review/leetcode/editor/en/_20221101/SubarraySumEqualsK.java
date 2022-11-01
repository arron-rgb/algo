package edu.neu.algo.review.leetcode.editor.en._20221101;

import java.util.*;
import edu.neu.util.InputUtil;

public class SubarraySumEqualsK {
  // 560
  // Given an array of integers nums and an integer k, return the total number of
  // subarrays whose sum equals to k.
  //
  // A subarray is a contiguous non-empty sequence of elements within an array.
  //
  //
  // Example 1:
  // Input: nums = [1,1,1], k = 2
  // Output: 2
  // Example 2:
  // Input: nums = [1,2,3], k = 3
  // Output: 2
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 2 * 10⁴
  // -1000 <= nums[i] <= 1000
  // -10⁷ <= k <= 10⁷
  //
  // Related Topics Array Hash Table Prefix Sum 👍 16075 👎 476

  public static void main(String[] args) {
    Solution solution = new SubarraySumEqualsK().new Solution();
    String[] data = """
          [1,1,1]
      2
      [1,2,3]
      3
          """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q =
        solution.subarraySum((int[])params[1 + i * paramTypes.length - 1], (int)params[2 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int subarraySum(int[] nums, int k) {
      // return tle(nums, k);
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      int sum = 0;
      int res = 0;
      // map里放
      for (int num : nums) {
        sum += num;
        // 累加到sum的时候，看看前面出现过几次sum -k
        // sum - (sum - k) = k
        // 所以加上出现的次数
        res += map.getOrDefault(sum - k, 0);
        // 更新sum出现的次数
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
      return res;
    }

    private int tle(int[] nums, int k) {
      // 朴素前缀和
      int n = nums.length;
      int[] prefix = new int[n + 1];
      for (int i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
      }
      int res = 0;
      for (int i = 0; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
          if (prefix[j] - prefix[i] == k) {
            res++;
          }
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
