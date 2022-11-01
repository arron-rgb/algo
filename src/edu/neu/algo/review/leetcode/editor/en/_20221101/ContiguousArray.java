package edu.neu.algo.review.leetcode.editor.en._20221101;

import java.util.*;
import edu.neu.util.InputUtil;

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
  // Related Topics Array Hash Table Prefix Sum 👍 5927 👎 240

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
      int q = solution.findMaxLength((int[])params[1 + i * paramTypes.length - 1]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findMaxLength(int[] nums) {
      return arrayMapSolution(nums);
    }

    private int arrayMapSolution(int[] nums) {
      int n = nums.length;
      int count = 0;
      int[] temp = new int[2 * n + 1];
      Arrays.fill(temp, -2);
      temp[n] = -1;
      int res = 0;
      for (int i = 0; i < n; i++) {
        count += nums[i] == 0 ? -1 : 1;
        if (temp[n + count] >= -1) {
          res = Math.max(res, i - temp[n + count]);
        } else {
          temp[n + count] = i;
        }
      }
      return res;
    }

    private int hashMapSolution(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, -1);
      int count = 0, res = 0;
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        if (nums[i] == 1) {
          count += 1;
        } else {
          count -= 1;
        }
        if (map.containsKey(count)) {
          res = Math.max(res, i - map.get(count));
        } else {
          map.put(count, i);
        }
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
