package edu.neu.algo.review.leetcode.editor.en._20230125;

import edu.neu.util.InputUtil;
import java.util.*;

public class BinarySubarraysWithSum {
  // 966
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
  // Related Topics Array Hash Table Sliding Window Prefix Sum 👍 1864 👎 59

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
    public int numSubarraysWithSum(int[] nums, int goal) {
      Map<Integer, Integer> map = new HashMap<>();
      int res = 0;
      int prefix = 0;
      map.put(0, 1);
      for (int num : nums) {
        prefix += num;
        int target = prefix - goal;
        res += map.getOrDefault(target, 0);

        map.put(prefix, map.getOrDefault(prefix, 0) + 1);
      }
      // 1 + 2 + 3 + 4 + 5
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
