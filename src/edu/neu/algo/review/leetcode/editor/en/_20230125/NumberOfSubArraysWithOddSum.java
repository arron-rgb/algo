package edu.neu.algo.review.leetcode.editor.en._20230125;

import edu.neu.util.InputUtil;
import java.util.*;

public class NumberOfSubArraysWithOddSum {
  // 1524

  // Given an array of integers arr, return the number of subarrays with an odd
  // sum.
  //
  // Since the answer can be very large, return it modulo 10⁹ + 7.
  //
  //
  // Example 1:
  //
  //
  // Input: arr = [1,3,5]
  // Output: 4
  // Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
  // All sub-arrays sum are [1,4,9,3,8,5].
  // Odd sums are [1,9,3,5] so the answer is 4.
  //
  //
  // Example 2:
  //
  //
  // Input: arr = [2,4,6]
  // Output: 0
  // Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
  // All sub-arrays sum are [2,6,12,4,10,6].
  // All sub-arrays have even sum and the answer is 0.
  //
  //
  // Example 3:
  //
  //
  // Input: arr = [1,2,3,4,5,6,7]
  // Output: 16
  //
  //
  //
  // Constraints:
  //
  //
  // 1 <= arr.length <= 10⁵
  // 1 <= arr[i] <= 100
  //
  //
  // Related Topics Array Math Dynamic Programming Prefix Sum 👍 1008 👎 48

  public static void main(String[] args) {
    Solution solution = new NumberOfSubArraysWithOddSum().new Solution();
    String[] data = """
                  [1,3,5]
      [2,4,6]
      [1,2,3,4,5,6,7]
                  """.trim().replaceAll("\n", "|").split("\\|");
    String[] paramTypes = InputUtil.param("[int[]]");
    Object[] params = new Object[data.length];
    for (int i = 0; i < data.length; i++) {
      params[i] = InputUtil.get(data[i], paramTypes[i % paramTypes.length]);
    }
    int loop = data.length / paramTypes.length;
    for (int i = 0; i < loop; i++) {
      int q = solution.numOfSubarrays((int[])params[1 - 1 + i * paramTypes.length]);
      System.out.println(q);
    }
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numOfSubarrays(int[] arr) {
      int[] count = new int[2];
      int mod = (int)(1e9 + 7);
      int pre = 0;
      int res = 0;
      count[0] = 1;
      for (int i : arr) {
        pre += i;
        res = pre % 2 == 0 ? (res + count[1]) % mod : (res + count[0]) % mod;
        count[pre % 2]++;
      }
      return res % mod;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
