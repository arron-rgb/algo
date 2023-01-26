package edu.neu.algo.review.leetcode.editor.en._20230119;

import edu.neu.util.InputUtil;
import java.util.*;

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
  //
  // Related Topics Array Hash Table Prefix Sum 👍 5405 👎 217

  public static void main(String[] args) {
    Solution solution = new SubarraySumsDivisibleByK().new Solution();
    String[] data = """
                  [4,5,0,-2,-3,1]
      5
      [5]
      9
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("${question.paramTypes}");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    // for (int i = 0; i < loop; i++) {
    // }
    int i = solution.subarraysDivByK(InputUtil.stringToArray("[4,5,0,-2,-3,1]"), 5);
    System.out.println(i);
    i = solution.subarraysDivByK(new int[] {5}, 9);
    System.out.println(i);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int subarraysDivByK(int[] nums, int k) {
      int res = 0;
      int[] count = new int[k];
      count[0] = 1;
      int sum = 0;
      for (int num : nums) {
        // +k 防止 sum + num%k为负数
        // count[0]=1 防止
        sum = (sum + num % k + k) % k;
        // num为5的时候 通过计算[4,5] - [4]发现有个差值为5 % k == 0
        // 所以需要统计 count[sum]的个数

        // 但count[0]是为了避免 num%k==0的时候错过
        res += count[sum]++;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
