package edu.neu.algo.review.leetcode.editor.en._20221108;

import edu.neu.util.InputUtil;

public class BinarySubarraysWithSum {

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
  // Related Topics Array Hash Table Sliding Window Prefix Sum 👍 1727 👎 57

  public static void main(String[] args) {
    Solution solution = new BinarySubarraysWithSum().new Solution();
    String[] data = """
          [1,0,1,0,1]
      2
      [0,0,0,0,0]
      0""".trim().replaceAll("\n", "|").split("\\|");
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
    public int numSubarraysWithSum(int[] nums, int target) {
      int sum = 0;
      int res = 0;
      int[] count = new int[nums.length + 1];
      count[0] = 1;
      for (int i : nums) {
        sum += i;
        if (sum >= target) {
          res += count[sum - target];
        }
        count[sum]++;
      }
      return res;
    }

    public int slidingWindow(int[] A, int S) {
      return atMost(A, S) - atMost(A, S - 1);
    }

    public int atMost(int[] nums, int target) {
      if (target < 0) {
        return 0;
      }
      int res = 0, i = 0, n = nums.length;
      for (int j = 0; j < n; j++) {
        target -= nums[j];
        while (target < 0) {
          target += nums[i++];
        }
        res += j - i + 1;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
