package edu.neu.algo.review.leetcode.editor.en._20230124;

import edu.neu.util.InputUtil;
import java.util.*;

public class ContiguousArray {

  // 525
  // Given a binary array nums, return the maximum length of a contiguous subarray
  // with an equal number of 0 and 1.
  //
  //
  // Example 1:
  //
  //
  // Input: nums = [0,1]
  // Output: 2
  // Explanation: [0, 1] is the longest contiguous subarray with an equal number
  // of 0 and 1.
  //
  //
  // Example 2:
  //
  //
  // Input: nums = [0,1,0]
  // Output: 2
  // Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
  // number of 0 and 1.
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= nums.length <= 10⁵
  // nums[i] is either 0 or 1.
  //
  //
  // Related Topics Array Hash Table Prefix Sum 👍 6128 👎 243

  public static void main(String[] args) {
    Solution solution = new ContiguousArray().new Solution();
    String[] data = """
                  [0,1]
      [0,1,0]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.findMaxLength((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findMaxLength(int[] nums) {
      // [-1, 1]
      // [-1, 0]
      // 统计一样的有多少个
      int sum = 0;
      Map<Integer, Integer> map = new HashMap<>();
      int res = 0;
      map.put(0, -1);
      for (int j = 0; j < nums.length; j++) {
        sum += nums[j] == 0 ? -1 : 1;
        if (map.containsKey(sum)) {
          res = Math.max(j - map.get(sum), res);
        } else {
          map.put(sum, j);
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
