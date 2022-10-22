package edu.neu.algo.monotonic.leetcode.editor.en._20221021;

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
  // Related Topics Array Hash Table Prefix Sum 👍 15875 👎 473

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
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
      int ans = 0;
      int m = matrix.length, n = matrix[0].length;
      for (int i = 0; i < m; ++i) { // 枚举上边界
        int[] sum = new int[n];
        for (int j = i; j < m; ++j) { // 枚举下边界
          for (int c = 0; c < n; ++c) {
            sum[c] += matrix[j][c]; // 更新每列的元素和
          }
          ans += subarraySum(sum, target);
        }
      }
      return ans;
    }

    public int subarraySum(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      map.put(0, 1);
      int count = 0, pre = 0;
      for (int x : nums) {
        pre += x;
        if (map.containsKey(pre - k)) {
          count += map.get(pre - k);
        }
        map.put(pre, map.getOrDefault(pre, 0) + 1);
      }
      return count;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
