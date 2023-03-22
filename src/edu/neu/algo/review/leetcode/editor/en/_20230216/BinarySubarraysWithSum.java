package edu.neu.algo.review.leetcode.editor.en._20230216;

import edu.neu.util.InputUtil;
import edu.neu.base.*;
import java.util.*;

public class BinarySubarraysWithSum {
  // 930
  // Given a binary array nums and an integer goal, return the number of non-empty
  // subarrays with a sum goal.
  //
  // A subarray is a contiguous part of the array.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [1,0,1,0,1], goal = 2
  // Output: 4
  // Explanation: The 4 subarrays are bolded and underlined below:
  // [1,0,1,0,1]
  // [1,0,1,0,1]
  // [1,0,1,0,1]
  // [1,0,1,0,1]
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [0,0,0,0,0], goal = 0
  // Output: 15
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 3 * 10⁴
  // nums[i] is either 0 or 1.
  // 0 <= goal <= nums.length
  //
  //
  // Related Topics Array Hash Table Sliding Window Prefix Sum 👍 1925 👎 61

  public static void main(String[] args) {
    Solution solution = new BinarySubarraysWithSum().new Solution();
    String[] data = """
                  [1,0,1,0,1]
      2
      [0,0,0,0,0]
      0
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[], int]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numSubarraysWithSum((int[])params[1 - 1 + i * paramTypes.length],
        (int)params[2 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numSubarraysWithSum(int[] nums, int t) {
      int n = nums.length;
      int ans = 0;
      for (int r = 0, l1 = 0, l2 = 0, s1 = 0, s2 = 0; r < n; r++) {
        s1 += nums[r];
        s2 += nums[r];
        while (l1 <= r && s1 > t)
          s1 -= nums[l1++];
        while (l2 <= r && s2 >= t)
          s2 -= nums[l2++];
        ans += l2 - l1;
      }
      return ans;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
